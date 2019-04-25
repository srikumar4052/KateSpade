
package com.ch.report.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ch.ksd.utils.constants.FileConstants;
import com.ch.utils.ParallelFactory;

public class CommonReportUtility extends ParallelFactory implements FileConstants {
	public static String getCurrentDate() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("ddMMMYYhhmmss");
		String str = df.format(date);
		return str;
	}

}
