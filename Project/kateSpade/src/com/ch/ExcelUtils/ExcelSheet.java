package com.ch.ExcelUtils;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.NumberToTextConverter;

public class ExcelSheet {
	String sheetName = "";

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public String toString() {
		return sheetName + " :: " + elementValues + "::" + elementTypes + "::" + elements;
	}

	public ExcelSheet(String sheetName, Sheet workSheet) {
		this.sheetName = sheetName;
		Iterator<Row> iterator = workSheet.iterator();

		while (iterator.hasNext()) {
			Row row = (Row) iterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			String key = "";
			ExcelBean bean = new ExcelBean();
			while (cellIterator.hasNext()) {
				Cell nextCell = (Cell) cellIterator.next();
				switch (nextCell.getColumnIndex()) {
				case 0:
					if (nextCell.getCellType() == 0) {
						key = NumberToTextConverter.toText(nextCell.getNumericCellValue());
						bean.setKey(key);
					} else {
						key = nextCell.getStringCellValue();
						bean.setType(key);
					}
					break;
				case 1:
					if (nextCell.getCellType() == 2) {
						String type = NumberToTextConverter.toText(nextCell.getNumericCellValue());
						bean.setType(type);
						setElementType(key, type);
					} else {
						String type = nextCell.getStringCellValue();
						bean.setType(type);
						setElementType(key, type);
					}
					break;
				case 2:
					if (nextCell.getCellType() == 0) {
						String value = NumberToTextConverter.toText(nextCell.getNumericCellValue());
						bean.setValue(value);
						setElementValue(key, value);
					} else {
						String value = nextCell.getStringCellValue();
						bean.setValue(value);
						setElementValue(key, value);
					}
					break;
				}
			}
			setElement(key, bean);
		}
		ExcelProperty.setExcelSheet(sheetName, this);
	}

	HashMap<String, String> elementValues = new HashMap();

	HashMap<String, String> elementTypes = new HashMap();

	HashMap<String, ExcelBean> elements = new HashMap();

	public HashMap<String, ExcelBean> getElements() {
		return elements;
	}

	public void setElements(HashMap<String, ExcelBean> elements) {
		this.elements = elements;
	}

	public void setElement(String key, ExcelBean bean) {
		elements.put(key, bean);
	}

	public ExcelBean getBean(String key) {
		return (ExcelBean) elements.get(key);
	}

	public HashMap<String, String> getElementTypes() {
		return elementTypes;
	}

	public void setElementTypes(HashMap<String, String> elementTypes) {
		this.elementTypes = elementTypes;
	}

	public HashMap<String, String> getElementValues() {
		return elementValues;
	}

	public void setElementValues(HashMap<String, String> elementValues) {
		this.elementValues = elementValues;
	}

	public void setElementValue(String key, String value) {
		elementValues.put(key, value);
	}

	public void setElementType(String key, String type) {
		elementTypes.put(key, type);
	}

	public String getElementType(String name) {
		return (String) elementTypes.get(name);
	}

	public String getElementValue(String name) {
		return (String) elementValues.get(name);
	}
}
