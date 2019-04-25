package com.ch.ksd.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InvalidCreateAccount {

	String email = "";

	String confirmEmail = "";

	String password = "";

	String confirmPassword = "";

	String errorid = "";

	String errormessage = "";

	public InvalidCreateAccount(String[] data) {
		email = data[0];
		confirmEmail = data[1];
		password = data[2];
		confirmPassword = data[3];
		errorid = data[5];
		errormessage = data[4];
	}

	public String getErrorid() {
		return errorid;
	}

	public void setErrorid(String errorid) {
		this.errorid = errorid;
	}

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
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

	public String getConfirmEmail() {
		return confirmEmail;
	}

	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
