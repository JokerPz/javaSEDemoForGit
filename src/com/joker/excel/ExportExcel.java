/**
 * 
 */
package com.joker.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * 这个demo的功能是导出信息到excel文件，使用的jar包与importExcel的一样
 * poi-4.0.0.jar
 * poi-ooxml-4.0.0.jar
 * poi-ooxml-schemas-4.0.0.jar
 * xmlbeans-3.0.1.jar
 * commons-collections4-4.2.ja
 * commons-compress-1.18.jar
 */
/**
 * @author joker
 * @ClassName ExportExcel @
 */
public class ExportExcel {
	public static XSSFWorkbook putDataIntoExcel(String sheetName, String[] title, String[][] value,
			XSSFWorkbook workbook) {
		if (workbook == null) {
			workbook = new XSSFWorkbook();
		}
		XSSFSheet sheet = workbook.createSheet(sheetName);
		XSSFRow rowHead = sheet.createRow(0);
		XSSFCell cell = null;
		// 创建表头，没有做样式的设置
		for (int i = 0; i < title.length; i++) {
			cell = rowHead.createCell(i);
			cell.setCellValue(title[i]);
		}
		XSSFRow row = null;
		// 通过双层循环来赋值
		for (int i = 1; i < value.length; i++) {
			row = sheet.createRow(i);
			for (int j = 0; j < value[i].length; j++) {
				cell = row.createCell(j);
				cell.setCellValue(value[i][j]);
			}
		}
		return workbook;
	}

	public static void main(String[] args) throws FileNotFoundException {
		String[] title = { "name", "latitude" };
		String sheetName = "sheet1";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String fileName = "demo" + dateFormat.format(System.currentTimeMillis()) + ".xlsx";
		String filePath = "E:" + File.separator;
		// 通过二维数组来赋值cell的内容
		String[][] value = new String[17][];
		value[0] = new String[2];
		value[0][0] = "name";
		value[0][1] = "latitude";
		for (int i = 1; i < 17; i++) {
			value[i] = new String[2];
			value[i][0] = "A" + i;
			value[i][1] = i + ".0";
		}
		XSSFWorkbook workbook = putDataIntoExcel(sheetName, title, value, null);
		File file = null;
		FileOutputStream fos = null;
		try {
			file = new File(filePath + fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			fos = new FileOutputStream(file);
			// 通过输出流来写出文件
			workbook.write(fos);
			System.out.println("导出excel文件：" + fileName + "成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (fos != null) {
				fos.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
