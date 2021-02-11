package com.web.dazu.model;

public class ClassTime {
	private int class_timecode;
	private String class_describe;
	private String class_starttime;
	private String class_endtime;
	private String class_date;
	private int class_information_classcode;

	public ClassTime() {}


	public ClassTime(int class_timecode, String class_describe, String class_starttime, String class_endtime,
			String class_date, int class_information_classcode) {
		super();
		this.class_timecode = class_timecode;
		this.class_describe = class_describe;
		this.class_starttime = class_starttime;
		this.class_endtime = class_endtime;
		this.class_date = class_date;
		this.class_information_classcode = class_information_classcode;
	}


	public String getClass_describe() {
		return class_describe;
	}


	public void setClass_describe(String class_describe) {
		this.class_describe = class_describe;
	}


	public int getClass_timecode() {
		return class_timecode;
	}

	public void setClass_timecode(int class_timecode) {
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

	public int getClass_information_classcode() {
		return class_information_classcode;
	}

	public void setClass_information_classcode(int class_information_classcode) {
		this.class_information_classcode = class_information_classcode;
	}
		
}
