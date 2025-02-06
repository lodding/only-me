/*
package com.me.only;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class Excel {

    @Resource
    private CrmGoodsMapper crmGoodsMapper;

    */
/**
     * 每个sheet存储的记录数 100W
     *//*

    public static final Integer PER_SHEET_ROW_COUNT = 100000;

    */
/**
     * 每次向EXCEL写入的记录数(查询每页数据大小) 20W
     *//*

    public static final Integer PER_WRITE_ROW_COUNT = 20000;




    public void exportSysSystemExcel(HttpServletResponse response)  {
        String name = "测试导出百万数据";
        BufferedOutputStream out = new BufferedOutputStream(EasyExcelUtils.buildStream(name, response));
        ExcelWriter excelWriter = EasyExcel.write(out, InventoryExportResp.class)
                .registerWriteHandler(new WriteSheetHandler(null))
                .automaticMergeHead(false)
                .orderByIncludeColumn(true)
                .includeColumnFieldNames(null)
                .build();
        try {
            Integer totalRowCount =   crmGoodsMapper.selecttotal(new InventoryPageReq());
            Integer perSheetRowCount = PER_SHEET_ROW_COUNT;
            Integer pageSize = PER_WRITE_ROW_COUNT;
            Integer sheetCount = totalRowCount % perSheetRowCount == 0 ? (totalRowCount / perSheetRowCount) : (totalRowCount / perSheetRowCount + 1);
            Integer previousSheetWriteCount = perSheetRowCount / pageSize;
            Integer lastSheetWriteCount = totalRowCount % perSheetRowCount == 0 ?
                    previousSheetWriteCount :
                    (totalRowCount % perSheetRowCount % pageSize == 0 ? totalRowCount % perSheetRowCount / pageSize : (totalRowCount % perSheetRowCount / pageSize + 1));

            for (int i = 0; i < sheetCount; i++) {
                WriteSheet writeSheet = EasyExcel.writerSheet("测试导出百万数据" + i).build();
                for (int j = 0; j < (i != sheetCount - 1 ? previousSheetWriteCount : lastSheetWriteCount); j++) {
                    List<InventoryExportResp> dataList = new ArrayList<>();
                    PageHelper.startPage(j + 1 + previousSheetWriteCount * i, pageSize);
                    List<InventoryPageResp> result = crmGoodsMapper.findInventoryByPage(new InventoryPageReq()).getResult();
                    if (CollectionUtils.isEmpty(result)){
                        continue;
                    }
                    List<InventoryExportResp> inventoryExportResps = BeanUtil.copyPropertiesToList(result, InventoryExportResp.class);
                    dataList.addAll(inventoryExportResps);
                    excelWriter.write(dataList, writeSheet);
                }
            }
            out.flush();

        }catch (Exception e){
            throw new GlobalException("导出失败");
        }finally {
            out.flush();
            excelWriter.finish();
        }

    }

}
*/
