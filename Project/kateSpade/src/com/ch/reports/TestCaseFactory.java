
package com.ch.reports;

import java.util.ArrayList;


public class TestCaseFactory
{

    public static ArrayList<TestCaseDetail> testcases = new ArrayList<TestCaseDetail>();

    public static ArrayList<TestCaseDetail> getTestcases()
    {
        return testcases;
    }

    /**
     * @param testcases
     *            the testcases to set
     */
    public static void setTestcases(ArrayList<TestCaseDetail> testcases)
    {
        TestCaseFactory.testcases = testcases;
    }

    public static TestCaseDetail createTestCaseDetail(Class<?> object, String name)
    {
        TestCaseDetail testcase = new TestCaseDetail(object, name);
        testcases.add(testcase);

        return testcase;
    }
}