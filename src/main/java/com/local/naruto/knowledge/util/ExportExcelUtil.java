package com.local.naruto.knowledge.util;

import com.alibaba.fastjson.JSON;
import com.local.naruto.knowledge.jpa.entity.MenuInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportExcelUtil {

    public static List<MenuInfo> readExcelByPath(String path) throws IOException {
        Workbook workbook = null;
        InputStream inputStream = null;
        String[][] cellVals;
        String fileName;
        List<MenuInfo> deliveryList = new ArrayList<>();
        try {
            // path是指欲下载的文件的路径。
            File file = new File(path);
            // 取得文件名
            fileName = file.getName();
            // 获取Excel后缀名
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
            // 根据路径获取输入流
            inputStream = new FileInputStream(file.getAbsolutePath());
            if (fileType.equalsIgnoreCase("xls")) {
                workbook = new HSSFWorkbook(inputStream);
            } else if (fileType.equalsIgnoreCase("xlsx")) {
                workbook = new XSSFWorkbook(inputStream);
            }
            for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
                Sheet sheet = workbook.getSheetAt(sheetNum);
                // 校验sheet是否合法
                if (sheet == null) {
                    continue;
                }
                // 获取第一行数据
                int firstRowNum = sheet.getFirstRowNum();
                // 解析起始行
                int rowStart = firstRowNum + 1;
                // 数据总行数
                int rowEnd = sheet.getPhysicalNumberOfRows();
                // 解析每一行的数据，构造数据对象
                for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
                    // 获取第rowNum行的数据
                    Row row = sheet.getRow(rowNum);
                    if (null == row) {
                        continue;
                    }
                    // 获取每行有多少列数据
                    int cellLength = row.getLastCellNum();
                    Cell cell;
                    cellVals = new String[rowNum][cellLength];
                    MenuInfo single = null;
                    for (int i = 0; i < cellLength; i++) {
                        // 获取rowNum行i列的数据
                        cell = row.getCell(i);
                        String value = convertGeneralCellValueToString(cell);
                        cellVals[rowNum - 1][i] = value;
                        single = new MenuInfo();

                    }
                    System.out.println("single is " + JSON.toJSONString(single));
                    deliveryList.add(single);
                }
            }
        } finally {
            if (null != workbook) {
                workbook.close();
            }
            if (null != inputStream) {
                inputStream.close();
            }
        }
        return deliveryList;
    }

    /**
     * 将单元格内容转换为字符串
     *
     * @param cell
     * @return
     */
    private static String convertGeneralCellValueToString(Cell cell) {
        String returnValue = null;
        switch (cell.getCellType()) {
            case NUMERIC:   //数字
                Double doubleValue = cell.getNumericCellValue();
                returnValue = doubleValue.toString();
                break;
            case STRING:    //字符串
                returnValue = cell.getStringCellValue();
                break;
            case BOOLEAN:   //布尔
                Boolean booleanValue = cell.getBooleanCellValue();
                returnValue = booleanValue.toString();
                break;
            case BLANK:     // 空值
                break;
            case FORMULA:   // 公式
                returnValue = cell.getCellFormula();
                break;
            case ERROR:     // 故障
                break;
            default:
                break;
        }
        return returnValue;
    }
}
