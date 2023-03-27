package only.me.common.util.excelUtil;

import com.alibaba.excel.EasyExcel;
import lombok.extern.slf4j.Slf4j;
import only.me.common.Exception.BusinessException;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: ExcelUtil
 * @description:
 * @author: szh
 * @create: 2020-09-01 14:28
 **/
@Slf4j
public class ExcelUtil {

    public static <T> List<T> readExcel(MultipartFile excel, Class<T> clazz) {
        ExcelListener excelListener = new ExcelListener();
        //读取Excel文件
        getReader(excel, excelListener, clazz);
        return excelListener.getDatas();
    }

    private static void getReader(MultipartFile excel, ExcelListener excelListener, Class<?> clazz) {
        checkFile(excel);
        try {
            EasyExcel.read(excel.getInputStream(), clazz, excelListener).sheet(0).doRead();
        } catch (IOException e) {
            log.error("读取Excel失败", e);
        }
    }

    private static void checkFile(MultipartFile excel) {
        String fileName = excel.getOriginalFilename();
        if (null == fileName
                || !(fileName.toLowerCase().endsWith(".xls")
                || fileName.toLowerCase().endsWith(".xlsx")
                || fileName.toLowerCase().endsWith(".xlsm"))) {
            throw new BusinessException(500, "文件格式错误");
        }
    }



    /**
     * 多sheet读取时的模型映射
     */
    private static final Map<String, Integer> brandModelMap = new HashMap<>();
    static {
        brandModelMap.put(Class.class.getName(), 0);
        brandModelMap.put(Class.class.getName(),1);
    }



    private static void getReaderMulti(MultipartFile excel, ExcelListener excelListener, Class<?> clazz, int sheetNo) {
        checkFile(excel);
        try {
            EasyExcel.read(excel.getInputStream(), clazz, excelListener).sheet(sheetNo).doRead();
        } catch (IOException e) {
            log.error("读取Excel失败", e);
        }catch (Exception e ){
            throw  new BusinessException(888,e.getMessage()+"excel字段类型有误，请确认格式的正确性");
        }
    }

    /**
     * 多sheet读取
     * @param excel
     * @param clazz
     * @return
     */
    public static Map<String, List<Object>> readExcelBrandModel(MultipartFile excel, Class<?>... clazz) {
        Map<String, List<Object>> sheetMap = new HashMap<>();
        if (clazz != null && clazz.length > 0) {
            for (Class clazzItem : clazz) {
                ExcelListener excelListener = new ExcelListener();
                //读取Excel文件
                getReaderMulti(excel, excelListener, clazzItem, brandModelMap.get(clazzItem.getName()));
                List<Object> objectList = excelListener.getDatas();
                sheetMap.put(clazzItem.getName(), objectList);
            }
        }
        return sheetMap;
    }
}