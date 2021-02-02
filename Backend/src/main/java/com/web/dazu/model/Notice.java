package com.web.dazu.model;

public class Notice {
	private int main_notice_board_code;
	private String main_notice_board_write_datetime;
	private int main_notice_board_visit;
	private String main_notice_board_title;
	private String main_notice_board_contents;
	private String member_usercode;
	
	public Notice() {}

	public Notice(int main_notice_board_code, String main_notice_board_write_datetime, int main_notice_board_visit,
			String main_notice_board_title, String main_notice_board_contents, String member_usercode) {
		super();
		this.main_notice_board_code = main_notice_board_code;
		this.main_notice_board_write_datetime = main_notice_board_write_datetime;
		this.main_notice_board_visit = main_notice_board_visit;
		this.main_notice_board_title = main_notice_board_title;
		this.main_notice_board_contents = main_notice_board_contents;
		this.member_usercode = member_usercode;
	}

	public int getMain_notice_board_code() {
		return main_notice_board_code;
	}

	public void setMain_notice_board_code(int main_notice_board_code) {
		this.main_notice_board_code = main_notice_board_code;
	}

	public String getMain_notice_board_write_datetime() {
		return main_notice_board_write_datetime;
	}

	public void setMain_notice_board_write_datetime(String main_notice_board_write_datetime) {
		this.main_notice_board_write_datetime = main_notice_board_write_datetime;
	}

	public int getMain_notice_board_visit() {
		return main_notice_board_visit;
	}

	public void setMain_notice_board_visit(int main_notice_board_visit) {
		this.main_notice_board_visit = main_notice_board_visit;
	}

	public String getMain_notice_board_title() {
		return main_notice_board_title;
	}

	public void setMain_notice_board_title(String main_notice_board_title) {
		this.main_notice_board_title = main_notice_board_title;
	}

	public String getMain_notice_board_contents() {
		return main_notice_board_contents;
	}

	public void setMain_notice_board_contents(String main_notice_board_contents) {
		this.main_notice_board_contents = main_notice_board_contents;
	}

	public String getMember_usercode() {
		return member_usercode;
	}

	public void setMember_usercode(String member_usercode) {
		this.member_usercode = member_usercode;
	}

	
}
