package com.web.dazu.model;

public class ClassReview {
	private String member_usercode;
	private String class_review_write_datetime;
	private int class_review_code;
	private int class_review_point;
	private String class_review_describe;
	private String class_information_classcode;
	private String member_nickname;
	
	public ClassReview() {}
	
	public ClassReview(String member_usercode, String class_review_write_datetime, int class_review_code,
			int class_review_point, String class_review_describe, String class_information_classcode,
			String member_nickname) {
		super();
		this.member_usercode = member_usercode;
		this.class_review_write_datetime = class_review_write_datetime;
		this.class_review_code = class_review_code;
		this.class_review_point = class_review_point;
		this.class_review_describe = class_review_describe;
		this.class_information_classcode = class_information_classcode;
		this.member_nickname = member_nickname;
	}

	
	public String getMember_nickname() {
		return member_nickname;
	}

	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}

	public String getClass_review_write_datetime() {
		return class_review_write_datetime;
	}
	public void setClass_review_write_datetime(String class_review_write_datetime) {
		this.class_review_write_datetime = class_review_write_datetime;
	}
	public String getMember_usercode() {
		return member_usercode;
	}

	public void setMember_usercode(String member_usercode) {
		this.member_usercode = member_usercode;
	}

	public int getClass_review_point() {
		return class_review_point;
	}

	public void setClass_review_point(int class_review_point) {
		this.class_review_point = class_review_point;
	}

	public String getClass_review_describe() {
		return class_review_describe;
	}

	public void setClass_review_describe(String class_review_describe) {
		this.class_review_describe = class_review_describe;
	}

	public String getClass_information_classcode() {
		return class_information_classcode;
	}

	public void setClass_information_classcode(String class_information_classcode) {
		this.class_information_classcode = class_information_classcode;
	}

	public int getClass_review_code() {
		return class_review_code;
	}

	public void setClass_review_code(int class_review_code) {
		this.class_review_code = class_review_code;
	}

}
