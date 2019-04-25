
package com.ch.ksd.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoadBean {
	String email = "";

	public LoadBean(String user) {
		email = user;
	}

	public static String random() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dmMM");
		String str = df.format(date);
		return str;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
