package com.me.only.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author onle
 * @date 2020/7/1
 */
public class LinkedHashMapDemo {

    public static void main(String[] args) {

        //按插入顺序排序
        orderOfWrite();
        System.out.println("---------");
        //按访问顺序排序
        orderOfRreader();
    }

    public static void orderOfWrite() {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Apple", 1);
        map.put("Xiaomi", 2);
        map.put("Huawei", 3);
        System.out.println("按插入顺序排序:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void orderOfRreader() {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>(16, 0.75f, true);
        map.put("Apple", 1);
        map.put("Xiaomi", 2);
        map.put("Huawei", 3);
        System.out.println("按插入顺序排序:");
        // 访问"Xiaomi"
        System.out.println(map.get("Xiaomi"));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
