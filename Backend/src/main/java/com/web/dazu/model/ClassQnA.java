package com.web.dazu.model;

public class ClassQnA {
	private int class_qna_board_code;
	private String class_qna_baoard_write_datetime;
	private String class_qna_board_write_contents;
	private String class_qna_answer_write_content;
	private String member_usercode;
	private String class_information_classcode;
	private String member_nickname;
	
	public ClassQnA() {}



	public ClassQnA(int class_qna_board_code, String class_qna_baoard_write_datetime,
			String class_qna_board_write_contents, String class_qna_answer_write_content, String member_usercode,
			String class_information_classcode, String member_nickname) {
		super();
		this.class_qna_board_code = class_qna_board_code;
		this.class_qna_baoard_write_datetime = class_qna_baoard_write_datetime;
		this.class_qna_board_write_contents = class_qna_board_write_contents;
		this.class_qna_answer_write_content = class_qna_answer_write_content;
		this.member_usercode = member_usercode;
		this.class_information_classcode = class_information_classcode;
		this.member_nickname = member_nickname;
	}



	public String getClass_qna_answer_write_content() {
		return class_qna_answer_write_content;
	}



	public void setClass_qna_answer_write_content(String class_qna_answer_write_content) {
		this.class_qna_answer_write_content = class_qna_answer_write_content;
	}



	public String getMember_nickname() {
		return member_nickname;
	}



	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}



	public int getClass_qna_board_code() {
		return class_qna_board_code;
	}

	public void setClass_qna_board_code(int class_qna_board_code) {
		this.class_qna_board_code = class_qna_board_code;
	}

	public String getClass_qna_baoard_write_datetime() {
		return class_qna_baoard_write_datetime;
	}

	public void setClass_qna_baoard_write_datetime(String class_qna_baoard_write_datetime) {
		this.class_qna_baoard_write_datetime = class_qna_baoard_write_datetime;
	}

	public String getClass_qna_board_write_contents() {
		return class_qna_board_write_contents;
	}

	public void setClass_qna_board_write_contents(String class_qna_board_write_contents) {
		this.class_qna_board_write_contents = class_qna_board_write_contents;
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
