package com.ch.ExcelUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.ch.ksd.utils.constants.FileConstants;

public class ReadExcelUtils implements FileConstants {
	public ReadExcelUtils() {
	}

	private static Workbook getWorkbook(FileInputStream inputStream, String excelFilePath) throws IOException {
		Workbook workbook = null;
		if (excelFilePath.endsWith("xls")) {
			workbook = new HSSFWorkbook(inputStream);
		} else {
			throw new IllegalArgumentException(
					"Given excel sheet is not compatible or not Supported please correct the excel sheet");
		}
		return workbook;
	}

	private static FileInputStream getInputStreamFromExcelFile(String excelFilePath) {
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File(excelFilePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return inputStream;
	}

	public static List<ExcelSheet> readBooksFromExcelFile() throws Exception {
		String excelFilePath = EXCEL_FILENAME;
		List<ExcelSheet> list = new ArrayList();

		FileInputStream inputStream = getInputStreamFromExcelFile(excelFilePath);
		Workbook workbook = getWorkbook(inputStream, excelFilePath);

		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			String name = workbook.getSheetName(i);
			Sheet firstSheet = workbook.getSheet(name);
			ExcelSheet sheet = new ExcelSheet(name, firstSheet);
			list.add(sheet);
		}
		workbook.close();
		inputStream.close();
		return list;
	}
}
