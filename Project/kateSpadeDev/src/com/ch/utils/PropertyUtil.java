package com.ch.utils;

import java.io.FileInputStream;
import java.util.Properties;

import com.ch.ksd.utils.constants.FileConstants;

public class PropertyUtil implements FileConstants {

	private static Properties readPropertyFile(String fileName) {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}

	public static String getPropertyValue(String key, String file) {
		Properties properties = readPropertyFile(file);

		return properties.getProperty(key);
	}

	// object property file
	public static String getObjectValue(String key) {
		Properties properties = readPropertyFile(OBJECT_PROPERTY_FILE);

		return properties.getProperty(key);
	}

	// server property file
	public static String getServerValue(String key) {
		Properties properties = readPropertyFile(SERVER_PROPERTY_FILE);

		return properties.getProperty(key);
	}

	// testconfig file
	public static String getConfigValue(String key) {
		Properties properties = readPropertyFile(TEST_PROPERTY_FILE);
		return properties.getProperty(key);
	}

	// static text
	public static String getStaticText(String key) {
		Properties properties = readPropertyFile(STATIC_TEXT_PROPERTY);
		return properties.getProperty(key);
	}

	// mobile object
	public static String getMobileObjValue(String key) {
		Properties properties = readPropertyFile(MOBILE_OBJ_PROPERTY_FILE);
		return properties.getProperty(key);
	}

	// tablet object
	public static String getTabletObjValue(String key) {
		Properties properties = readPropertyFile(TABELT_OBJ_PROPERTY);
		return properties.getProperty(key);
	}

}