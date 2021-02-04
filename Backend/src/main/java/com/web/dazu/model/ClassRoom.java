package com.web.dazu.model;

public class ClassRoom {
	private String class_time_information_class_timecode;
	private String member_usercode;
	private String class_information_classcode;
	
	public ClassRoom() {}

	public ClassRoom(String class_time_information_class_timecode, String member_usercode,
			String class_information_classcode) {
		super();
		this.class_time_information_class_timecode = class_time_information_class_timecode;
		this.member_usercode = member_usercode;
		this.class_information_classcode = class_information_classcode;
	}

	public String getClass_time_information_class_timecode() {
		return class_time_information_class_timecode;
	}

	public void setClass_time_information_class_timecode(String class_time_information_class_timecode) {
		this.class_time_information_class_timecode = class_time_information_class_timecode;
	}

	public String getMember_usercode() {
		return member_usercode;
	}

	public void setMember_usercode(String member_usercode) {
		this.member_usercode = member_usercode;
	}

	public String getClass_information_classcode() {
		return class_information_classcode;
	}

	public void setClass_information_classcode(String class_information_classcode) {
		this.class_information_classcode = class_information_classcode;
	}
	
}
