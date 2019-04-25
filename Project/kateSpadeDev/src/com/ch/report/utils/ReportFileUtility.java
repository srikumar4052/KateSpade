package com.ch.report.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ReportFileUtility implements ReportFileConstants
{
    public static String readContent(String file) throws Exception
    {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (null != line)
        {
            content.append(line + "\n");
            line = reader.readLine();
        }
        reader.close();

        return content.toString();
    }

    public static void writeHTMLContent(String file, String content) throws Exception
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(content);
        writer.close();
    }

}
