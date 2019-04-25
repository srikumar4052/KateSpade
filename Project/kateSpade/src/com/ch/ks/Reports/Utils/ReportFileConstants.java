
package com.ch.report.utils;

public interface ReportFileConstants
{
    public static final String TEST_HOME                   = System.getProperty("test.home", "./");

    public static final String HTML_CONFIG_HOME            = TEST_HOME + "htmlConfig/";

    public static final String HEAD_FILE                   = HTML_CONFIG_HOME + "head.txt";

    public static final String TABLEHEAD_FILE              = HTML_CONFIG_HOME + "tablehead.txt";

    public static final String TABLEDETAIL_IMAGE_FILE      = HTML_CONFIG_HOME + "detailimagehead.txt";

    public static final String TABLE_DEATIL_CASE_HEAD_FILE = HTML_CONFIG_HOME + "detailtestcase.txt";
    
    public static final String REPORTS_HOME                = TEST_HOME + "reports/";
}
