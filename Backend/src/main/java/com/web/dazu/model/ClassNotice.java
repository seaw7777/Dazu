package com.web.dazu.model;

public class ClassNotice {
	private int class_notice_board_code;
	private String class_notice_board_datetime;
	private String class_notice_board_title;
	private String class_notice_board_contents;
	private int class_notice_board_visit;
	private String class_information_classcode;
	
	public ClassNotice() {}

	public ClassNotice(int class_notice_board_code, String class_notice_board_datetime, String class_notice_board_title,
			String class_notice_board_contents, int class_notice_board_visit, String class_information_classcode) {
		super();
		this.class_notice_board_code = class_notice_board_code;
		this.class_notice_board_datetime = class_notice_board_datetime;
		this.class_notice_board_title = class_notice_board_title;
		this.class_notice_board_contents = class_notice_board_contents;
		this.class_notice_board_visit = class_notice_board_visit;
		this.class_information_classcode = class_information_classcode;
	}

	public int getClass_notice_board_code() {
		return class_notice_board_code;
	}

	public void setClass_notice_board_code(int class_notice_board_code) {
		this.class_notice_board_code = class_notice_board_code;
	}

	public String getClass_notice_board_datetime() {
		return class_notice_board_datetime;
	}

	public void setClass_notice_board_datetime(String class_notice_board_datetime) {
		this.class_notice_board_datetime = class_notice_board_datetime;
	}

	public String getClass_notice_board_title() {
		return class_notice_board_title;
	}

	public void setClass_notice_board_title(String class_notice_board_title) {
		this.class_notice_board_title = class_notice_board_title;
	}

	public String getClass_notice_board_contents() {
		return class_notice_board_contents;
	}

	public void setClass_notice_board_contents(String class_notice_board_contents) {
		this.class_notice_board_contents = class_notice_board_contents;
	}

	public int getClass_notice_board_visit() {
		return class_notice_board_visit;
	}

	public void setClass_notice_board_visit(int class_notice_board_visit) {
		this.class_notice_board_visit = class_notice_board_visit;
	}

	public String getClass_information_classcode() {
		return class_information_classcode;
	}

	public void setClass_information_classcode(String class_information_classcode) {
		this.class_information_classcode = class_information_classcode;
	}
	
}
