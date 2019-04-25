package com.ch.ExcelUtils;

import java.util.HashMap;
import java.util.List;

public class ExcelProperty extends ReadExcelUtils {
	static HashMap<String, ExcelSheet> excelSheet = null;

	public ExcelProperty() {
	}

	public static ExcelBean getElementValue(String sheetName, String key) throws Exception {
		if (excelSheet == null) {
			excelSheet = new HashMap();
			List<ExcelSheet> sheets = readBooksFromExcelFile();
			for (ExcelSheet excelSheet : sheets) {
				System.out.println(excelSheet);
			}
		}
		ExcelSheet sheet = (ExcelSheet) excelSheet.get(sheetName);
		if (sheet == null) {
			throw new Exception("Sheet name is wrong");
		}
		ExcelBean bean = sheet.getBean(key);
		if (bean == null) {
			throw new Exception("Key name is wrong");
		}
		return bean;
	}

	public HashMap<String, ExcelSheet> getExcelSheet() {
		return excelSheet;
	}

	public static void setExcelSheet(String name, ExcelSheet sheet) {
		excelSheet.put(name, sheet);
	}
}
