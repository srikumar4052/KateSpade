
package com.ch.reports;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtility implements com.ch.ksd.utils.constants.FileConstants {
	public static String readContent(String file) throws Exception {
		StringBuilder content = new StringBuilder();
		String substring = file.substring(1);
		InputStream resourceAsStream = FileUtility.class.getResourceAsStream(substring);
		if (resourceAsStream == null) {
			resourceAsStream = new FileInputStream(new File(file));
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));
		String line = reader.readLine();
		while (null != line) {
			content.append(line + "\n");
			line = reader.readLine();
		}
		reader.close();
		return content.toString();
	}

	public static void writeHTMLContent(String file, String content) throws Exception {
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(content);
		writer.close();
	}

}
