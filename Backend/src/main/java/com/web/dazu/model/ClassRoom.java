package com.web.dazu.model;

public class ClassRoom {
	private int class_roomcode;
	private String class_time_information_class_timecode;
	private String member_usercode;
	private String class_information_classcode;
	
	private String item_name;
	private int total_amount;
	
	public ClassRoom() {}
	
	public ClassRoom(int class_roomcode, String class_time_information_class_timecode, String member_usercode,
			String class_information_classcode, String item_name, int total_amount) {
		super();
		this.class_roomcode = class_roomcode;
		this.class_time_information_class_timecode = class_time_information_class_timecode;
		this.member_usercode = member_usercode;
		this.class_information_classcode = class_information_classcode;
		this.item_name = item_name;
		this.total_amount = total_amount;
	}
	
	

	public int getClass_roomcode() {
		return class_roomcode;
	}

	public void setClass_roomcode(int class_roomcode) {
		this.class_roomcode = class_roomcode;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
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
