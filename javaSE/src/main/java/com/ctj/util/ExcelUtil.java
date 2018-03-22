package com.ctj.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Pattern;

public class ExcelUtil {

    public static void main(String[] args) {
        String path = "C:/Users/macycao/Desktop/注册未激活-3月白名单(1).xlsx";
        readExecl(path);
    }

    //读取excel表格中的数据，path代表excel路径
    public static void readExecl(String path) {
        try {
            /*String[] yidong = {"134", "135", "136", "137", "138", "139", "144", "147", "148", "150", "151", "152", "157", "158", "159", "1703", "1705", "1706", "178", "182", "183", "184", "187", "188", "198"};
            String[] liantong = {"130", "131", "132", "145", "146", "155", "156", "166", "1704", "1707", "1708", "1709", "171", "175", "176", "185", "186"};
            String[] dianxin = {"133", "141", "149", "153", "1700", "1701", "1702", "173", "177", "180", "181", "189", "199"};*/

            /**
             * 中国移动匹配正则
             */
            String CHINA_MOBILE_PATTERN = "^(134|135|136|137|138|139|144|147|148|150|151|152|157|158|159|1703|1705|1706|178|182|183|184|187|188|198)\\d{0,100}$";

            /**
             * 中国联通匹配正则
             */
            String CHINA_UNICOM_PATTERN = "^(130|131|132|145|146|155|156|166|1704|1707|1708|1709|171|175|176|185|186)\\d{0,100}$";
            //String CHINA_UNICOM_PATTERN = "^(130|131|132|145|146|155|156|166|1704|1707|1708|1709|171|175|176|185|186)\\d{7,8}$";

            /**
             * 中国电信匹配正则
             */
            String CHINA_TELECOM_PATTERN = "^(133|141|149|153|1700|1701|1702|173|177|180|181|189|199)\\d{0,100}$";


            StringBuilder yidongStr = new StringBuilder();
            StringBuilder liantongStr = new StringBuilder();
            StringBuilder dianxinStr = new StringBuilder();
            //读取的时候可以使用流，也可以直接使用文件名
            XSSFWorkbook xwb = new XSSFWorkbook(path);
            //循环工作表sheet
            for (int numSheet = 0; numSheet < xwb.getNumberOfSheets(); numSheet++) {
                XSSFSheet xSheet = xwb.getSheetAt(numSheet);
                if (xSheet == null) {
                    continue;
                }
                //循环行row
                for (int numRow = 0; numRow <= xSheet.getLastRowNum(); numRow++) {
                    XSSFRow xRow = xSheet.getRow(numRow);
                    xRow.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                    if (xRow == null) {
                        continue;
                    }
                    //循环列cell
                    for (int numCell = 0; numCell <= xRow.getLastCellNum(); numCell++) {
                        XSSFCell xCell = xRow.getCell(numCell);
                        if (xCell == null) {
                            continue;
                        }
                        String stringCellValue = getValue(xCell);

                        boolean isFind = false;
                        if (Pattern.matches(CHINA_MOBILE_PATTERN, stringCellValue)) {
                            yidongStr.append(stringCellValue).append(",");
                            isFind = true;
                        }
                        if (!isFind) {
                            if (Pattern.matches(CHINA_UNICOM_PATTERN, stringCellValue)) {
                                liantongStr.append(stringCellValue).append(",");
                                isFind = true;
                            }
                        }
                        if (!isFind) {
                            if (Pattern.matches(CHINA_TELECOM_PATTERN, stringCellValue)) {
                                dianxinStr.append(stringCellValue).append(",");
                            }
                        }


                        /*for (String str : yidong) {
                            if (stringCellValue.startsWith(str)) {
                                yidongStr.append(stringCellValue).append(",");
                                isFind = true;
                                break;
                            }
                        }
                        if (!isFind) {
                            for (String str : liantong) {
                                if (stringCellValue.startsWith(str)) {
                                    liantongStr.append(stringCellValue).append(",");
                                    isFind = true;
                                    break;
                                }
                            }
                        }
                        if (!isFind) {
                            for (String str : dianxin) {
                                if (stringCellValue.startsWith(str)) {
                                    dianxinStr.append(stringCellValue).append(",");
                                    break;
                                }
                            }
                        }*/
                        //输出值
                        //System.out.println("excel表格中取出的数据" + getValue(xCell));
                    }
                }
            }

            long currentTimeMillis = System.currentTimeMillis();
            if (yidongStr.length() > 0) {
                createExcel(yidongStr.toString().substring(0, yidongStr.length() - 1), "yidong" + currentTimeMillis);
            }
            if (liantongStr.length() > 0) {
                createExcel(liantongStr.toString().substring(0, liantongStr.length() - 1), "liantong" + currentTimeMillis);
            }
            if (dianxinStr.length() > 0) {
                createExcel(dianxinStr.toString().substring(0, dianxinStr.length() - 1), "dianxin" + currentTimeMillis);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 取出每列的值
     *
     * @param xCell 列
     * @return
     */
    private static String getValue(XSSFCell xCell) {
        if (xCell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xCell.getBooleanCellValue());
        } else if (xCell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(xCell.getNumericCellValue());
        } else {
            return String.valueOf(xCell.getStringCellValue());
        }
    }

    public static void createExcel(String phones, String fileName) {
        try {
            String path = "C:/Users/macycao/Desktop/" + fileName + ".xlsx";
            // 创建新的Excel 工作簿
            XSSFWorkbook workbook = new XSSFWorkbook();
            // 在Excel工作簿中建一工作表，其名为缺省值
            // 如要新建一名为"用户表"的工作表，其语句为：
            XSSFSheet sheet = workbook.createSheet("data");
            // 在索引0的位置创建行（最顶端的行）
            XSSFRow row = sheet.createRow((short) 0);
            //在索引0的位置创建单元格（左上端）
            XSSFCell cell = row.createCell((short) 0);
            //创建单元格样式
            CellStyle cellStyle = workbook.createCellStyle();
            // 设置这些样式
            /*cellStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
            cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
            cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
            cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);*/

            // 定义单元格为字符串类型
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
            // 在单元格中输入一些内容
            cell = row.createCell((short) 0);
            cell.setCellValue("手机号码");
            cell.setCellStyle(cellStyle);

            String[] phoneArr = phones.split(",");
      /*//第一个sheet第一行为标题
      XSSFRow rowFirst = sheet.createRow(0);
      rowFirst.setHeightInPoints(21.75f);*/
            for (int i = 0; i < phoneArr.length; i++) {
                row = sheet.createRow((int) i + 1);
                // 第四步，创建单元格，并设置值
                row.createCell((short) 0).setCellValue(phoneArr[i]);
                //sheet.autoSizeColumn((short) 0); //调整第一列宽度（自适应），只识别数字、字母

        /*Font font = workbook.createFont();
        font.setFontHeightInPoints((short)18); //字体大小
        sheet.setDefaultRowHeightInPoints(21.75f);
        font.setFontName("楷体");
        font.setBoldweight(Font.BOLDWEIGHT_BOLD); //粗体
        font.setColor(HSSFColor.GREEN.index);    //绿字- 字体颜色*/
            }
            // 新建一输出文件流
            FileOutputStream fOut = new FileOutputStream(path);
            // 把相应的Excel 工作簿存盘
            workbook.write(fOut);
            //清空缓冲区数据
            fOut.flush();
            // 操作结束，关闭文件
            fOut.close();
            System.out.println("文件生成...");
        } catch (Exception e) {
            System.out.println("已运行 xlCreate() : " + e);
        }
    }
}
