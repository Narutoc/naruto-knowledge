package com.local.naruto.knowledge.util;

import com.alibaba.fastjson.JSON;
import com.local.naruto.knowledge.mybatis.entity.ContentModel;
import com.local.naruto.knowledge.mybatis.entity.MenuModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportExcelUtil {

    public static void readInfo(String path) throws IOException {
        Workbook workbook = null;
        InputStream inputStream = null;
        String fileName;
        try {
            // path是指欲下载的文件的路径。
            File file = new File(path);
            // 取得文件名
            fileName = file.getName();
            // 获取Excel后缀名
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
            // 根据路径获取输入流
            inputStream = new FileInputStream(file.getAbsolutePath());
            workbook = new XSSFWorkbook(inputStream);
//            if (fileType.equalsIgnoreCase("xls")) {
//                workbook = new HSSFWorkbook(inputStream);
//            } else if (fileType.equalsIgnoreCase("xlsx")) {
//                workbook = new XSSFWorkbook(inputStream);
//            }
            String[][] cellVals;
            System.out.println("sheet num is " + workbook.getNumberOfSheets());
            for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
                Sheet sheet = workbook.getSheetAt(sheetNum);
                // 校验sheet是否合法
                if (sheet == null) {
                    continue;
                }
                // 获取第一行数据
                int firstRowNum = sheet.getFirstRowNum();
                System.out.println("firstRowNum is " + firstRowNum);
                // 解析起始行
                int rowStart = firstRowNum + 2;
                System.out.println("rowStart is " + rowStart);
                // 数据总行数
                int rowEnd = sheet.getPhysicalNumberOfRows();
                System.out.println("all row num is " + rowEnd);
                // 解析每一行的数据，构造数据对象
                for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
                    System.out.println("读取第" + rowNum + "行的数据");
                    // 获取第rowNum行的数据
                    Row row = sheet.getRow(rowNum);
                    if (null == row) {
                        continue;
                    }
                    // 获取每行有多少列数据
                    int cellLength = row.getLastCellNum();
                    System.out.println("cellLength is " + cellLength);
                    Cell cell;
                    cellVals = new String[rowNum][cellLength];
                    for (int i = 0; i < cellLength; i++) {
                        // 获取rowNum行i列的数据
                        cell = row.getCell(i);
                        String value = convertGeneralCellValueToString(cell);
                        cellVals[rowNum - 1][i] = value;
                        System.out.println(
                            "第" + (rowNum + 1) + "行，第" + (i + 1) + "列数据为" + cellVals[rowNum
                                - 1][i]);
                        // 语言类型分为三类
//                        for (int lanNum = 1; lanNum <= 3; lanNum++) {
//                            System.out.println("第" + i + "种语言信息如下");
//                            System.out.println("名称：" + cellVals[rowNum - 1][lanNum * 4 + 0 - 2]);
//                            System.out.println("描述：" + cellVals[rowNum - 1][lanNum * 4 + 1 - 2]);
//                            System.out.println("访问链接：" + cellVals[rowNum - 1][lanNum * 4 + 2 - 2]);
//                            System.out.println("状态：" + cellVals[rowNum - 1][lanNum * 4 + 3 - 2]);
//                        }
                    }
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
    }

    public static List<MenuModel> readExcelByPath(String path) throws IOException {
        Workbook workbook = null;
        InputStream inputStream = null;
        String fileName;
        List<MenuModel> menuList = new ArrayList<>();
        try {
            // path是指欲下载的文件的路径。
            File file = new File(path);
            // 取得文件名
            fileName = file.getName();
            // 获取Excel后缀名
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
            // 根据路径获取输入流
            inputStream = new FileInputStream(file.getAbsolutePath());
            workbook = new XSSFWorkbook(inputStream);
//            if (fileType.equalsIgnoreCase("xls")) {
//                workbook = new HSSFWorkbook(inputStream);
//            } else if (fileType.equalsIgnoreCase("xlsx")) {
//                workbook = new XSSFWorkbook(inputStream);
//            }
            String[][] cellVals;
            System.out.println("sheet num is " + workbook.getNumberOfSheets());
            for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
                Sheet sheet = workbook.getSheetAt(sheetNum);
                // 校验sheet是否合法
                if (sheet == null) {
                    continue;
                }
                // 获取第一行数据
                int firstRowNum = sheet.getFirstRowNum();
                System.out.println("firstRowNum is " + firstRowNum);
                // 解析起始行
                int rowStart = firstRowNum + 2;
                System.out.println("rowStart is " + rowStart);
                // 数据总行数
                int rowEnd = sheet.getPhysicalNumberOfRows();
                System.out.println("all row num is " + rowEnd);
                // 解析每一行的数据，构造数据对象
                for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
                    System.out.println("读取第" + rowNum + "行的数据");
                    // 获取第rowNum行的数据
                    Row row = sheet.getRow(rowNum);
                    if (null == row) {
                        continue;
                    }
                    // 获取每行有多少列数据
                    int cellLength = row.getLastCellNum();
                    System.out.println("cellLength is " + cellLength);
                    Cell cell;
                    cellVals = new String[rowNum][cellLength];
                    for (int i = 0; i < cellLength; i++) {
                        // 获取rowNum行i列的数据
                        cell = row.getCell(i);
                        String value = convertGeneralCellValueToString(cell);
                        cellVals[rowNum - 1][i] = value;
                        System.out.println(
                            "第" + (rowNum + 1) + "行，第" + (i + 1) + "列数据为" + cellVals[rowNum
                                - 1][i]);
                        MenuModel single = new MenuModel();
                        single.setSortNum(cellVals[rowNum - 1][0]);
                        System.out.println("menu sort num is " + single.getSortNum());
                        System.out.println("第3行，第2列的数据" + cellVals[rowNum - 1][1]);
                        if (cellVals[rowNum - 1][1].equals("启用")) {
                            single.setStatus("1");
                        }
                        if (cellVals[rowNum - 1][1].equals("停用")) {
                            single.setStatus("2");
                        }
                        if (cellVals[rowNum - 1][1].equals("删除")) {
                            single.setStatus("3");
                        }
                        System.out.println("menu status is " + single.getStatus());
                        // 语言类型分为三类
                        for (int lanNum = 1; lanNum <= 3; lanNum++) {
                            List<ContentModel> contentList = null;
                            ContentModel singleContent = new ContentModel();
                            singleContent.setContent1(cellVals[rowNum - 1][lanNum * 4 + 0 - 2]);
                            singleContent.setContent2(cellVals[rowNum - 1][lanNum * 4 + 1 - 2]);
                            singleContent.setContent3(cellVals[rowNum - 1][lanNum * 4 + 2 - 2]);
                            if (cellVals[rowNum - 1][lanNum * 4 + 3 - 2].equals("启用")) {
                                singleContent.setStatus("1");
                            }
                            if (cellVals[rowNum - 1][lanNum * 4 + 3 - 2].equals("停用")) {
                                singleContent.setStatus("2");
                            }
                            if (cellVals[rowNum - 1][lanNum * 4 + 3 - 2].equals("删除")) {
                                singleContent.setStatus("3");
                            }
                            System.out.println("content status is " + singleContent.getStatus());
                            contentList.add(singleContent);
                            System.out.println(
                                "single content info is " + JSON.toJSONString(single));
                            single.setContentList(contentList);
                        }
                        System.out.println("single menu info is " + JSON.toJSONString(single));
                        menuList.add(single);
                    }
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
        return menuList;
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

    /**
     * 解析excel每一行每一列的数据
     *
     * @param rowStart 开始行数
     * @param rowEnd   excel一共有多少行
     * @param sheet    当前处理的sheet
     */
//    private List<MenuInfo> analyseAllRowAndCell(int rowStart, int rowEnd, Sheet sheet) {
//        List<MenuInfo> menuList = new ArrayList<>();
//        String[][] cellVals;
//        // 解析每一行的数据，构造数据对象
//        for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
//            // 获取第rowNum行的数据
//            Row row = sheet.getRow(rowNum);
//            if (null == row) {
//                continue;
//            }
//            // 获取每行有多少列数据
//            int cellLength = row.getLastCellNum();
//            Cell cell;
//            cellVals = new String[rowNum][cellLength];
//            MenuInfo single = null;
//            List<ContentInfo> contentList = null;
//            for (int i = 0; i < cellLength; i++) {
//                // 获取rowNum行i列的数据
//                cell = row.getCell(i);
//                String value = convertGeneralCellValueToString(cell);
//                cellVals[rowNum - 1][i] = value;
//                single = new MenuInfo();
//                single.setSortNum(Integer.getInteger(cellVals[rowNum - 1][1]));
//                if (cellVals[rowNum - 1][2].equals("启用")) {
//                    single.setStatus("1");
//                }
//                if (cellVals[rowNum - 1][2].equals("停用")) {
//                    single.setStatus("2");
//                }
//                if (cellVals[rowNum - 1][2].equals("删除")) {
//                    single.setStatus("3");
//                }
//                // 语言类型分为三类
//                for (int lanNum = 1; lanNum <= 3; lanNum++) {
//                    ContentInfo singleContent = new ContentInfo();
//                    singleContent.setContent1(cellVals[rowNum - 1][lanNum * 4 + 1 - 2]);
//                    singleContent.setContent2(cellVals[rowNum - 1][lanNum * 4 + 2 - 2]);
//                    singleContent.setContent3(cellVals[rowNum - 1][lanNum * 4 + 3 - 2]);
//                    if (cellVals[rowNum - 1][lanNum * 4 + 4 - 2].equals("启用")) {
//                        singleContent.setStatus("1");
//                    }
//                    if (cellVals[rowNum - 1][lanNum * 4 + 4 - 2].equals("停用")) {
//                        singleContent.setStatus("2");
//                    }
//                    if (cellVals[rowNum - 1][lanNum * 4 + 4 - 2].equals("删除")) {
//                        singleContent.setStatus("3");
//                    }
//                    contentList.add(singleContent);
//                }
//            }
//            single.setContentList(contentList);
//            System.out.println("single is " + JSON.toJSONString(single));
//            menuList.add(single);
//        }
//        return menuList;
//    }

//    private MenuInfo analyseSingleRowAndCell(int cellLength, Row row, String[][] cellVals,
//        int rowNum) {
//        List<ContentInfo> contentList = null;
//        MenuInfo single = null;
//        Cell cell;
//        for (int i = 0; i < cellLength; i++) {
//            // 获取rowNum行i列的数据
//            cell = row.getCell(i);
//            String value = convertGeneralCellValueToString(cell);
//            cellVals[rowNum - 1][i] = value;
//            single.setSortNum(Integer.getInteger(cellVals[rowNum - 1][1]));
//            if (cellVals[rowNum - 1][2].equals("启用")) {
//                single.setStatus("1");
//            }
//            if (cellVals[rowNum - 1][2].equals("停用")) {
//                single.setStatus("2");
//            }
//            if (cellVals[rowNum - 1][2].equals("删除")) {
//                single.setStatus("3");
//            }
//            // 语言类型分为三类
//            for (int lanNum = 1; lanNum <= 3; lanNum++) {
//                ContentInfo singleContent = new ContentInfo();
//                singleContent.setContent1(cellVals[rowNum - 1][lanNum * 4 + 1 - 2]);
//                singleContent.setContent2(cellVals[rowNum - 1][lanNum * 4 + 2 - 2]);
//                singleContent.setContent3(cellVals[rowNum - 1][lanNum * 4 + 3 - 2]);
//                if (cellVals[rowNum - 1][lanNum * 4 + 4 - 2].equals("启用")) {
//                    singleContent.setStatus("1");
//                }
//                if (cellVals[rowNum - 1][lanNum * 4 + 4 - 2].equals("停用")) {
//                    singleContent.setStatus("2");
//                }
//                if (cellVals[rowNum - 1][lanNum * 4 + 4 - 2].equals("删除")) {
//                    singleContent.setStatus("3");
//                }
//                contentList.add(singleContent);
//            }
//        }
//        single.setContentList(contentList);
//        return single;
//    }
}
