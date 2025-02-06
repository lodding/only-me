package com.onle.me.sort;

import java.io.*;
import java.util.*;

public class ExternalSort {


    /**
     * 将大文件分成多个可以处理的小块，并对每个小块进行排序
     * @param file 待排序的大文件
     * @param cmp 排序比较器
     * @return 排序后的小块文件列表
     * @throws IOException
     */
    public static List<File> sortInBatch(File file, Comparator<String> cmp) throws IOException {
        List<File> files = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String> tempList = new ArrayList<>();
        String line = "";
        // 逐行读取文件内容，并分块处理
        while ((line = reader.readLine()) != null) {
            tempList.add(line);
            // 如果当前块达到指定大小，进行排序并写入磁盘// 例如每次读取10万行
            if (tempList.size() == 100000) {
                files.add(sortAndSave(tempList, cmp));
                tempList.clear();
            }
        }
        // 处理最后一块数据

        if (!tempList.isEmpty()) {
            files.add(sortAndSave(tempList, cmp));
            tempList.clear();
        }
        reader.close();
        return files;
    }

    /**
     * 对数据块进行排序并写入磁盘
     * @param tempList 待排序的数据块
     * @param cmp 排序比较器
     * @return 排序后的小块文件
     * @throws IOException
     */
    public static File sortAndSave(List<String> tempList, Comparator<String> cmp) throws IOException {
        // 对临时列表进行排序

        tempList.sort(cmp);
        // 创建临时文件

        File tempFile = File.createTempFile("sortedBatch", ".txt");
        tempFile.deleteOnExit();
        // 将排序后的数据写入临时文件

        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        for (String s : tempList) {
            writer.write(s);
            writer.newLine();
        }
        writer.close();
        return tempFile;
    }

    /**
     * 归并排序多个已排序的小块文件
     * @param files 已排序的小块文件列表
     * @param outputFile 输出文件
     * @param cmp 排序比较器
     * @throws IOException
     */
    public static void mergeSortedFiles(List<File> files, File outputFile, Comparator<String> cmp) throws IOException {
        // 使用优先队列进行归并排序

        PriorityQueue<BufferedReaderWrapper> pq = new PriorityQueue<>(new Comparator<BufferedReaderWrapper>() {
            @Override
            public int compare(BufferedReaderWrapper o1, BufferedReaderWrapper o2) {
                return cmp.compare(o1.peek(), o2.peek());
            }
        });

        // 将每个已排序的小块文件添加到优先队列中
        for (File file : files) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedReaderWrapper wrapper = new BufferedReaderWrapper(reader);
            if (wrapper.peek() != null) {
                pq.add(wrapper);
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        try {
            // 从优先队列中依次取出最小元素并写入输出文件

            while (!pq.isEmpty()) {
                BufferedReaderWrapper wrapper = pq.poll();
                writer.write(wrapper.pop());
                writer.newLine();
                // 如果当前文件还有数据，继续添加到优先队列中

                if (wrapper.peek() != null) {
                    pq.add(wrapper);
                }
            }
        } finally {
            writer.close();
            // 关闭所有BufferedReader

            for (BufferedReaderWrapper wrapper : pq) {
                wrapper.reader.close();
            }
        }
    }

    /**
     * 辅助类，用于包装BufferedReader并缓存当前行
     */
    static class BufferedReaderWrapper {
        BufferedReader reader;
        String cache;

        BufferedReaderWrapper(BufferedReader reader) throws IOException {
            this.reader = reader;
            this.cache = reader.readLine();
        }

        boolean isEmpty() {
            return this.cache == null;
        }

        String peek() {
            return this.cache;
        }

        String pop() throws IOException {
            String answer = this.cache;
            this.cache = reader.readLine();
            return answer;
        }
    }


    public static void main(String[] args) throws IOException {
        // 待排序的输入文件
        File inputFile = new File("input.txt");
        // 排序后的输出文件
        File outputFile = new File("output.txt");
        // 使用自然顺序比较器
        Comparator<String> comparator = Comparator.naturalOrder();

        // 步骤1：分割并排序数据块
        List<File> sortedFiles = ExternalSort.sortInBatch(inputFile, comparator);

        // 步骤2：归并排序
        ExternalSort.mergeSortedFiles(sortedFiles, outputFile, comparator);
    }

}
