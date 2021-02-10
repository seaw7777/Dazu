package com.web.dazu.model;

public class ClassTime {
	private String class_timecode;
	private String class_starttime;
	private String class_endtime;
	private String class_date;
	private String class_information_classcode;
	private String member_usercode;
	public ClassTime() {}
	public ClassTime(String class_timecode, String class_starttime, String class_endtime, String class_date,
			String class_information_classcode, String member_usercode) {
		super();
		this.class_timecode = class_timecode;
		this.class_starttime = class_starttime;
		this.class_endtime = class_endtime;
		this.class_date = class_date;
		this.class_information_classcode = class_information_classcode;
		this.member_usercode = member_usercode;
	}
	public String getClass_timecode() {
		return class_timecode;
	}
	public void setClass_timecode(String class_timecode) {
		this.class_timecode = class_timecode;
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
	public String getClass_information_classcode() {
		return class_information_classcode;
	}
	public void setClass_information_classcode(String class_information_classcode) {
		this.class_information_classcode = class_information_classcode;
	}
	public String getMember_usercode() {
		return member_usercode;
	}
	public void setMember_usercode(String member_usercode) {
		this.member_usercode = member_usercode;
	}
	@Override
	public String toString() {
		return "ClassTime [class_timecode=" + class_timecode + ", class_starttime=" + class_starttime
				+ ", class_endtime=" + class_endtime + ", class_date=" + class_date + ", class_information_classcode="
				+ class_information_classcode + ", member_usercode=" + member_usercode + "]";
	}
	
	
}
