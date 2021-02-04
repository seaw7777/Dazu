package com.web.dazu.model;
//완료
public class Myclass {
	private String classcode;
	private String class_name;
	private String class_starttime;
	private String class_endtime;
	private String class_date;
	public String getClasscode() {
		return classcode;
	}
	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getClass_starttime() {
		return class_starttime;
	}
	public void setClass_starttime(String class_starttime) {
		this.class_starttime = class_starttime;
	}
	public String getClass_endtime() {
		return class_endtime;
	}
	public void setClass_endtime(String class_endtime) {
		this.class_endtime = class_endtime;
	}
	public String getClass_date() {
		return class_date;
	}
	public void setClass_date(String class_date) {
		this.class_date = class_date;
	}
	
	public Myclass() {}
	
	public Myclass(String classcode, String class_name, String class_starttime, String class_endtime,
			String class_date) {
		super();
		this.classcode = classcode;
		this.class_name = class_name;
		this.class_starttime = class_starttime;
		this.class_endtime = class_endtime;
		this.class_date = class_date;
	}
	@Override
	public String toString() {
		return "Myclass [classcode=" + classcode + ", class_name=" + class_name + ", class_starttime=" + class_starttime
				+ ", class_endtime=" + class_endtime + ", class_date=" + class_date + "]";
	}
	
	
	
}
