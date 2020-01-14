
package com.joker.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 这个类的功能用于导入excel
 * 主要用到的包有：
 * poi-4.0.0.jar
 * poi-ooxml-4.0.0.jar
 * poi-ooxml-schemas-4.0.0.jar
 * xmlbeans-3.0.1.jar
 * commons-collections4-4.2.jar
 * commons-compress-1.18.jar
 */ 

/**
 * @author joker
 * @ClassName ImportExcel @
 */
public class ImportExcel {
	/**
	 * 从excel中得到数据，版本可2003，2007 ImportExcel
	 * 
	 * @param file
	 * @throws FileNotFoundException
	 *             void
	 */
	public static void getDataFromExcel(File file) throws FileNotFoundException {
		String fileName = file.getName();
		int flag = 0;
		// 通过文件名的结尾来判断是否为excel文件，以及excel的版本
		if (fileName.endsWith(".xls")) {
			flag = 1;
		} else if (fileName.endsWith(".xlsx")) {
			flag = 2;
		} else {
			System.out.println("此文件不是excel文件");
			return;
		}
		// 流的定义放在try外面，因为域的作用
		InputStream fis = null;
		Workbook workbook = null;
		try {
			fis = new FileInputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		switch (flag) {
		case 1:
			// 2003版本的处理
			try {
				workbook = new HSSFWorkbook(fis);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 2:
			// 2007版本的处理
			try {
				workbook = new XSSFWorkbook(fis);
			} catch (IOException e1) {
				// throw e1;
				e1.printStackTrace();
			}
		default:
			break;
		}
		Sheet sheet = workbook.getSheetAt(0);
		StringBuilder rowHead = new StringBuilder();
		Row row = sheet.getRow(0);
		// 获取表头的内容，来进行判断是否是自己需要的excel
		for (int i = 0; i < row.getLastCellNum(); i++) {
			rowHead.append(row.getCell(i).toString());
		}
		if (!"namelatitude".equals(rowHead.toString())) {
			System.out.println("导入模板不正确，请重新导入");
			return;
		}
		// 获取表的内容，及打印表的内容
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			row = sheet.getRow(i);
			Cell cell1 = row.getCell(0);
			Cell cell2 = row.getCell(1);
			System.out.println("第" + (i + 1) + "行 |" + cell1.toString() + "|" + cell2.toString() + "|");
		}
		// 关闭流的时候要进行非空判断，防止出现空指针
		try {
			if (fis != null) {
				fis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// test
	public static void main(String[] args) throws FileNotFoundException {
		// 已经在E盘创建了123.xlsx的excel文档
		File file = new File("E:" + File.separator + "123.xlsx");
		getDataFromExcel(file);
	}
}
