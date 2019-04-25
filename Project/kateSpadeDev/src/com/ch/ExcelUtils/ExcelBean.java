package com.ch.ExcelUtils;

public class ExcelBean {
	private String type;
	private String value;
	private String name;

	public ExcelBean() {
	}

	public String getName() {
		return name;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExcelBean other = (ExcelBean) obj;
		if (name == null) {
			if (name != null)
				return false;
		} else if (!name.equals(name))
			return false;
		if (type == null) {
			if (type != null)
				return false;
		} else if (!type.equals(type))
			return false;
		if (value == null) {
			if (value != null)
				return false;
		} else if (!value.equals(value))
			return false;
		return true;
	}

	public void setKey(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String toString() {
		return "Type: " + getType() + ", " + "Value: " + getValue() + "\n";
	}
}
