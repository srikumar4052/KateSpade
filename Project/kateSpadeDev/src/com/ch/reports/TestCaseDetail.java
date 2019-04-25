
package com.ch.reports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import com.ch.report.utils.ReportFileConstants;
import com.ch.retry.Retry;
import com.ch.utils.DriverFactory;
import com.ch.utils.PropertyUtil;

public class TestCaseDetail implements com.ch.ksd.utils.constants.FileConstants, ReportFileConstants {
	String testsuitename = "";
	String testcasename = "";
	String expectedresult = "";
	String result = "";
	String errorlog = "";
	String exceptionmessage = "";
	String comment = "";

	public TestCaseDetail(String testsuitename, String tcname, String expectdresult, String result, String errorlog,
			String excepmsg) {
		this.testsuitename = testsuitename;
		testcasename = tcname;
		this.expectedresult = expectdresult;
		this.result = result;
		this.errorlog = errorlog;
		exceptionmessage = excepmsg;
	}

	public TestCaseDetail(Class<?> object, String name) {
		this.testsuitename = object.getSimpleName();
		this.testcasename = name;
	}

	public void pass(String expectedResult) {

		if ("".equalsIgnoreCase(result)) {
			this.expectedresult = expectedResult;
			result = "PASS";
		}
	}

	public static String getCurrentDate() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("ddMMYYhhmmss");
		String str = df.format(date);
		return str;
	}

	public void setErrorLogFile(Throwable trace) throws IOException {
		String s = "";
		try {
			String fileName = "err_" + getCurrentDate();
			if (PropertyUtil.getConfigValue("LOGFILE_CONTROL").equalsIgnoreCase("Server")) {
				String errorFile = PropertyUtil.getConfigValue("LOG_PATH") + fileName + ".log";
				File textr = (File) ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
				String file = getCurrentDate() + ".png";
				FileUtils.copyFile(textr, new File(PropertyUtil.getConfigValue("LOG_PATH") + file));
				PrintWriter printWriter = new PrintWriter(errorFile);
				trace.printStackTrace(printWriter);
				printWriter.close();

				s = "<a target=\"_balnk\" href=\"" + getMyIPAddress() + "/Reports/logs/" + fileName + ".log"
						+ "\"> <font color=\"red\">Error Log</a>" + "<br>" + "<a target=\"_balnk\" href=\""
						+ getMyIPAddress() + "/Reports/logs/" + file + "\"> <font color=\"red\">Screen Shot</a>";
				this.errorlog = s;
			} else if (PropertyUtil.getConfigValue("LOGFILE_CONTROL").equalsIgnoreCase("Local")) {
				String errorFile = fileName + ".log";
				File textr = (File) ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
				String file = getCurrentDate() + ".png";
				FileUtils.copyFile(textr, new File(REPORTS_HOME + file));
				PrintWriter printWriter = new PrintWriter(REPORTS_HOME + errorFile);
				trace.printStackTrace(printWriter);
				printWriter.close();
				s = "<a target=\"_balnk\" href=\"./" + errorFile + "\"> <font color=\"red\">Error Log</a>" + "<br>"
						+ "<a target=\"_balnk\" href=\"" + "./" + file + "\"> <font color=\"red\">Screen Shot</a>";
				this.errorlog = s;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void setScreenShot() throws IOException {
		File textr = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		String file = getCurrentDate() + ".png";
		if (PropertyUtil.getConfigValue("LOGFILE_CONTROL").equalsIgnoreCase("Server")) {
			FileUtils.copyFile(textr, new File(PropertyUtil.getConfigValue(LOG_PATH) + file));
			this.result = "<a target=\"_balnk\" href=\"" + getMyIPAddress() + "/Reports/logs/" + file
					+ "\"> <font color=\"red\">FAIL</a>";
		} else if (PropertyUtil.getConfigValue("LOGFILE_CONTROL").equalsIgnoreCase("Local")) {
			FileUtils.copyFile(textr, new File(REPORTS_HOME + file));
			this.result = "<a target=\"_balnk\" href=\"" + "./" + file + "\"> <font color=\"red\">FAIL</a>";
		}
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void comments(String def) {
		if (result == "PASS") {

		} else {
			this.comment = def;
		}
	}

	public void assertTrue(boolean flag, String expected, String actual) throws Exception {
		if (flag == false) {
			fail(expected, actual);
		}
	}

	public void assertFalse(boolean flag, String expected, String actual) throws Exception {
		if (flag == true) {
			fail(expected, actual);
		}
	}

	public void forceAssert(boolean flag, String expected, String actual) throws Exception {
		if (flag == false) {
			fail(expected, actual);
			Assert.fail(expected);
		}
	}

	public static String getMyIPAddress() {
		InetAddress addr;
		String host = "";
		try {
			addr = InetAddress.getLocalHost();
			host = "http://" + addr.getHostAddress() + ":9080";
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return host;
	}

	public void assertEquals(String expected, String actual) throws Exception {
		if (null == actual || null == expected || actual.equalsIgnoreCase(expected) == false) {
			fail(expected, actual);
		}
	}

	public void forceAssertEquals(String expected, String actual) throws Exception {
		if (null == actual || null == expected || actual.equalsIgnoreCase(expected) == false) {
			fail(expected, actual);
			Assert.assertEquals(actual, expected);
		}
	}

	public void fail(String expectedResult, String actual) throws Exception {
		if ("".equalsIgnoreCase(result)) {
			this.expectedresult = expectedResult;
			result = "FAIL";
			errorlog = actual;
			setScreenShot();
		} else {
			this.expectedresult = this.expectedresult + "\n" + expectedResult;
			result = "FAIL";
			errorlog = this.errorlog + "\n" + actual;
			setScreenShot();
		}
	}

	public void error(String expectedResult, Throwable trace) throws Exception {
		this.expectedresult = expectedResult;
		result = "ERROR";
		exceptionmessage = trace.getMessage();
		setErrorLogFile(trace);
	}

	public String getTestsuitename() {
		return testsuitename;
	}

	/**
	 * @param testsuitename the testsuitename to set
	 */
	public void setTestsuitename(String testsuitename) {
		this.testsuitename = testsuitename;
	}

	/**
	 * @return the testcasename
	 */
	public String getTestcasename() {
		return testcasename;
	}

	/**
	 * @param testcasename the testcasename to set
	 */
	public void setTestcasename(String testcasename) {
		this.testcasename = testcasename;
	}

	/**
	 * @return the expectedresult
	 */
	public String getExpectedresult() {
		return expectedresult;
	}

	/**
	 * @param expectedresult the expectedresult to set
	 */
	public void setExpectedresult(String expectedresult) {
		this.expectedresult = expectedresult;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @return the errorlog
	 */
	public String getErrorlog() {
		return errorlog;
	}

	/**
	 * @param errorlog the errorlog to set
	 */
	public void setErrorlog(String errorlog) {
		this.errorlog = errorlog;
	}

	public void retry(String s, TestCaseDetail testcase, Retry retry, Exception e) throws Exception {
		try {
			retry.startRetry();
		} catch (Exception e2) {
			e2.printStackTrace();
			testcase.error(s, e);
		}
	}

	/**
	 * @return the exceptionmessage
	 */
	public String getExceptionmessage() {
		return exceptionmessage;
	}

	/**
	 * @param exceptionmessage the exceptionmessage to set
	 */
	public void setExceptionmessage(String exceptionmessage) {
		this.exceptionmessage = exceptionmessage;
	}

}
