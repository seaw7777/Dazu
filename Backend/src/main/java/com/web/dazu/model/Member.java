package com.web.dazu.model;

public class Member {
	private String usercode;
	private String user_name;
	private String create_date;
	private String addess;
	private int usertype;
	
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getAddess() {
		return addess;
	}
	public void setAddess(String addess) {
		this.addess = addess;
	}
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	
	public Member() {}
	public Member(String usercode, String user_name, String create_date, String addess, int usertype) {
		this.usercode = usercode;
		this.user_name = user_name;
		this.create_date = create_date;
		this.addess = addess;
		this.usertype = usertype;
	}
}
