package com.ch.report.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.ch.email.EmailUtility;
import com.ch.reports.FileUtility;
import com.ch.reports.TestCaseDetail;
import com.ch.reports.TestCaseFactory;
import com.ch.reports.TestSummaryResult;
import com.ch.utils.DriverFactory;
import com.ch.utils.PropertyUtil;

public class AbstractTestCaseReport extends CommonReportUtility implements ReportFileConstants {
	static String currentUrl = PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE);
	static long start = 0;
	static long end = 0;

	static String startDateTime = "";
	static String endDateTime = "";

	static String s = "";

	public AbstractTestCaseReport() {
	}

	@BeforeSuite
	public static void time() {
		start = System.currentTimeMillis();
	}

	@AfterSuite(alwaysRun = true)
	public static String endtime() {
		end = System.currentTimeMillis();
		long total = end - start;
		String format = String.format("%%0%dd", 2);
		total = total / 1000;
		String seconds = String.format(format, total % 60);
		String minutes = String.format(format, (total % 3600) / 60);
		String hours = String.format(format, total / 3600);
		String time = hours + ":" + minutes + ":" + seconds;
		return time;
	}

	public static void instantance() {
		DriverFactory.getDriver();
	}

	@AfterMethod
	public void testQuitDriver() {
		System.out.println("Browser CLosed");
	}

	public static String getdateAndTime() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("MMM dd, yyyy 'at' hh:mm:ss a zzz");
		return ft.format(dNow);
	}

	public static String getdate() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("MMM dd, yyyy");
		return ft.format(dNow);
	}

	@AfterSuite(alwaysRun = true)
	public void reportgenerator(ITestContext ctx) {
		String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
		generateHTML(TestCaseFactory.getTestcases(), suiteName);
		System.out.println("Report generated");
	}

	public void generateHTML(ArrayList<TestCaseDetail> list, String name) {
		try {
			String projecttitle = PropertyUtil.getConfigValue(PROJECT_TITLE);
			String starthtml = "<html>";
			String head = FileUtility.readContent(HEAD_FILE);
			String body = "<body>";
			String endhtml = "</body></html>";
			ArrayList<TestSummaryResult> testSuites = getAllTestSuites(list);
			String summaryTable = generateSummaryTable(testSuites);
			String detailReport = generateCaseDetailTable(testSuites, list);
			String htmlContent = starthtml + head + body + "<center><h3>" + projecttitle + "</h3></center>"
					+ "<center><u><h4>Total Execution Time: " + endtime() + "</h4></u></center>" + summaryTable
					+ detailReport + endhtml;
			String currentDate = getCurrentDate();
			String string = name + " TestcaseReport" + currentDate + ".html";
			String file = "";
			if (PropertyUtil.getConfigValue("LOGFILE_CONTROL").equalsIgnoreCase("Server")) {
				file = PropertyUtil.getConfigValue(LOG_PATH) + string;
				ReportFileUtility.writeHTMLContent(file, htmlContent);
				EmailUtility.sendFile(name + " Test CaseReport at - " + currentDate, htmlContent, file, string);
			} else if (PropertyUtil.getConfigValue("LOGFILE_CONTROL").equalsIgnoreCase("Local")) {
				file = REPORTS_HOME + string;
				ReportFileUtility.writeHTMLContent(file, htmlContent);
				EmailUtility.sendFile(name + " Test CaseReport at - " + currentDate, htmlContent, file, string);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String generateSummaryTable(ArrayList<TestSummaryResult> testsuites) throws Exception {
		if (0 == testsuites.size()) {
			return "";
		}
		String starttable = FileUtility.readContent(TABLEHEAD_FILE);
		String content = "";
		for (Iterator<TestSummaryResult> iterator = testsuites.iterator(); iterator.hasNext();) {
			TestSummaryResult testSuite = (TestSummaryResult) iterator.next();
			String color = "red";
			if ("-".equalsIgnoreCase(testSuite.getFailCount())) {
				color = "green";
			}
			content = content + "<tr><td>" + testSuite.getSuiteName() + "</td><td>" + testSuite.getTotal() + "</td><td>"
					+ testSuite.getPassCount() + "</td><td><font color= \"" + color + "\">" + testSuite.getFailCount()
					+ "</font color></td><td>" + testSuite.getPercentage() + "%</td></tr>";

		}
		String endtable = "</table>";
		return starttable + "" + content + "" + endtable;
	}

	public static String buildDetails(String type) {
		String build = "<table class=\"blue\" align=\"center\"><tr><th align=\"center\" height=\"25\""
				+ " bgcolor=\"#2E86C1\" colSpan=\"2\"><font color = \"#FFFFFF\" >Execution Details</font "
				+ "color></th></tr><tr><td>URL</a></td><td>"
				+ PropertyUtil.getPropertyValue("BOTURL", SERVER_PROPERTY_FILE) + "<tr><td>Browser</td><td>"
				+ PropertyUtil.getConfigValue("BROWSER_NAME") + "</td></tr>"
				+ "</td></tr><tr><td>Execution Time</td><td>" + startDateTime + "</td></tr>"
				+ "<tr><td>Duration</a></td><td>" + endtime() + "</td></tr></table>";
		return build;
	}

	public static String generateCaseDetailTable(ArrayList<TestSummaryResult> testSuites,
			ArrayList<TestCaseDetail> testcases) throws Exception {
		if (0 == testcases.size()) {
			return "";
		}
		String starttable = FileUtility.readContent(TABLE_DEATIL_CASE_HEAD_FILE);
		String content = "";

		for (Iterator<TestSummaryResult> iterator = testSuites.iterator(); iterator.hasNext();) {
			TestSummaryResult suite = (TestSummaryResult) iterator.next();
			boolean flag = true;
			for (Iterator<TestCaseDetail> iterator1 = testcases.iterator(); iterator1.hasNext();) {
				TestCaseDetail testcase = (TestCaseDetail) iterator1.next();
				if (suite.getSuiteName().equalsIgnoreCase(testcase.getTestsuitename())) {
					String color;
					if ("Pass".equalsIgnoreCase(testcase.getResult())) {
						color = "green";
					} else {
						color = "red";
					}
					if (true == flag) {
						content = content + "<tr><td rowspan=" + suite.getTotal() + ">" + suite.getSuiteName()
								+ "</td><td>" + testcase.getTestcasename() + "</td><td>" + testcase.getExpectedresult()
								+ "</td><td> <font color= \"" + color + "\">" + testcase.getResult() + "</td><td>"
								+ testcase.getErrorlog() + "</td>" + "<td>" + testcase.getComment() + "</td></tr>";
						flag = false;
					} else {
						content = content + "<tr><td>" + testcase.getTestcasename() + "</td><td>"
								+ testcase.getExpectedresult() + "</td><td> <font color= \"" + color + "\">"
								+ testcase.getResult() + "</td><td>" + testcase.getErrorlog() + "</td>" + "<td>"
								+ testcase.getComment() + "</td></tr>";
					}
				}
			}
		}
		String endtable = "</table>";
		return starttable + "" + content + "" + endtable;
	}

	private synchronized ArrayList<TestSummaryResult> getAllTestSuites(ArrayList<TestCaseDetail> list) {
		HashMap<String, TestSummaryResult> suites = new HashMap<String, TestSummaryResult>();
		for (Iterator<TestCaseDetail> iterator = list.iterator(); iterator.hasNext();) {
			TestCaseDetail testCaseDetail = (TestCaseDetail) iterator.next();
			String suite = testCaseDetail.getTestsuitename();
			int pass = 0, fail = 0;
			if (testCaseDetail.getResult().equalsIgnoreCase("PASS")) {
				pass = 1;
			} else {
				fail = 1;
			}
			if (suites.get(suite) == null) {
				suites.put(suite, new TestSummaryResult(suite, pass, fail));
			} else {
				TestSummaryResult result = suites.get(suite);
				if (pass == 1) {
					result.incrementPass();
				} else {
					result.incrementFail();
				}
			}
		}
		Set<String> set = suites.keySet();
		ArrayList<TestSummaryResult> testsuites = new ArrayList<TestSummaryResult>();
		for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
			String name = (String) iterator.next();
			testsuites.add(suites.get(name));
		}
		return testsuites;
	}

}
