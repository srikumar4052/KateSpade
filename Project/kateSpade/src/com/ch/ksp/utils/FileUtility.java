package com.ch.avf.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.ch.avf.bean.Databean;
import com.ch.avf.bean.ForgotPwdDatabean;
import com.ch.avf.bean.ImageTextBean;
import com.ch.avf.bean.InvalidAboutYou;
import com.ch.avf.bean.InvalidCreateAccount;
import com.ch.avf.bean.LoadBean;
import com.ch.avf.bean.SignUpDataBean;
import com.ch.avf.bean.User;
import com.ch.avf.bean.VehicleSelectorBean;
import com.ch.avf.utils.constants.FileConstants;

public class FileUtility implements FileConstants
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

    public static ArrayList<Databean> readAllLoginData() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(LOGIN_DATA_FILE));
        ArrayList<Databean> data = new ArrayList<Databean>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 3)
            {
                data.add(new Databean(records[0], records[1], records[2]));
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }

    public static ArrayList<ForgotPwdDatabean> readAllForgotPwdData() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(FORGOT_PWD_DATA_FILE));
        ArrayList<ForgotPwdDatabean> data = new ArrayList<ForgotPwdDatabean>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 2)
            {
                data.add(new ForgotPwdDatabean(records[0], records[1]));
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }

    public static ArrayList<User> readAllUserData() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(USER_DATA_FILE));
        ArrayList<User> data = new ArrayList<User>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 10)
            {
                data.add(new User(records));
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }

    public static ArrayList<InvalidAboutYou> readAllInvalidAboutYouData() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(INVALID_ABOUT_YOU_FILE));
        ArrayList<InvalidAboutYou> data = new ArrayList<InvalidAboutYou>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 10)
            {
                data.add(new InvalidAboutYou(records));
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }

    public static ArrayList<InvalidAboutYou> readAllInvalidContactInfoData() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(INVALID_CONTACT_INFO_FILE));
        ArrayList<InvalidAboutYou> data = new ArrayList<InvalidAboutYou>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 10)
            {
                data.add(new InvalidAboutYou(records));
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }

    public static ArrayList<VehicleSelectorBean> readAllVehicleData() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(VEHICLE_DATA_FILE));
        ArrayList<VehicleSelectorBean> data = new ArrayList<VehicleSelectorBean>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 7)
            {
                data.add(new VehicleSelectorBean(records));
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }

    public static ArrayList<LoadBean> loadUser() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(LOAD_DATA_FILE));
        ArrayList<LoadBean> data = new ArrayList<LoadBean>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 1)
            {
                data.add(new LoadBean(records[0]));
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }

    public static void main(String[] args) throws Exception
    {
        ArrayList<LoadBean> data = loadUser();
        for (LoadBean loadBean : data)
        {
            System.out.println(loadBean.getEmail());
        }
    }

    public static ArrayList<ImageTextBean> readAllImages(String suiteName) throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(IMAGE_DATA_FILE));
        ArrayList<ImageTextBean> data = new ArrayList<ImageTextBean>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 16)
            {
                if ("".equalsIgnoreCase(suiteName) || line.contains(suiteName))
                {
                    data.add(new ImageTextBean(line));
                }
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }

    public static ArrayList<SignUpDataBean> readSignUpData() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(EMAIL_SIGNUP_DATA_FILE));
        ArrayList<SignUpDataBean> data = new ArrayList<SignUpDataBean>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 2)
            {
                data.add(new SignUpDataBean(records));
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }

    public static ArrayList<com.ch.avf.bean.InvalidSignInbean> readAllInvalidSignInData() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(INVALID_SIGNIN_USER_FILE));
        ArrayList<com.ch.avf.bean.InvalidSignInbean> data = new ArrayList<com.ch.avf.bean.InvalidSignInbean>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(";");
            if (records.length >= 3)
            {
                data.add(new com.ch.avf.bean.InvalidSignInbean(records));
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }

    public static ArrayList<InvalidCreateAccount> readAllInvalidCreateccountData()
    {
        // TODO Auto-generated method stub
        return null;
    }
}
