package com.web.dazu.model;

public class ClassTime {
	private String timecode;
	private String starttime;
	private String endtime;
	private String date;
	private String classcode;
	
	public ClassTime() {}
	public ClassTime(String timecode, String starttime, String endtime, String date, String classcode) {
		this.timecode = timecode;
		this.starttime = starttime;
		this.endtime = endtime;
		this.date = date;
		this.classcode = classcode;
	}

	public String getTimecode() {
		return timecode;
	}

	public void setTimecode(String timecode) {
		this.timecode = timecode;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getClasscode() {
		return classcode;
	}

	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}
	
}
