package com.ch.ksd.bean;

public class Databean {
	String username = "";
	String password = "";
	String errormessage = "";

	public Databean(String user, String pwd, String error) {
		username = user;
		password = pwd;
		errormessage = error;
	}

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "user:: " + username + ";; pwd :: " + password;
	}
}
