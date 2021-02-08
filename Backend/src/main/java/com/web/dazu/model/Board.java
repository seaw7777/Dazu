package com.web.dazu.model;

public class Board {
	int board_code;
	String board_write_datetime;
	String board_title;
	String board_contents;
	int board_good;
	int board_visit;
	String member_usercode;
	String nickname;
		
	public Board() {}

	public Board(int board_code, String board_write_datetime, String board_title, String board_contents, int board_good,
		int board_visit, String member_usercode, String nickname) {
		super();
		this.board_code = board_code;
		this.board_write_datetime = board_write_datetime;
		this.board_title = board_title;
		this.board_contents = board_contents;
		this.board_good = board_good;
		this.board_visit = board_visit;
		this.member_usercode = member_usercode;
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getBoard_code() {
		return board_code;
	}
	public void setBoard_code(int board_code) {
		this.board_code = board_code;
	}
	public String getBoard_write_datetime() {
		return board_write_datetime;
	}
	public void setBoard_write_datetime(String board_write_datetime) {
		this.board_write_datetime = board_write_datetime;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_contents() {
		return board_contents;
	}
	public void setBoard_contents(String board_contents) {
		this.board_contents = board_contents;
	}
	public int getBoard_good() {
		return board_good;
	}
	public void setBoard_good(int board_good) {
		this.board_good = board_good;
	}
	public int getBoard_visit() {
		return board_visit;
	}
	public void setBoard_visit(int board_visit) {
		this.board_visit = board_visit;
	}
	public String getMember_usercode() {
		return member_usercode;
	}
	public void setMember_usercode(String member_usercode) {
		this.member_usercode = member_usercode;
	}
	@Override
	public String toString() {
		return "Board [board_code=" + board_code + ", board_write_datetime=" + board_write_datetime + ", board_title="
				+ board_title + ", board_contents=" + board_contents + ", board_good=" + board_good + ", board_visit="
				+ board_visit + ", member_usercode=" + member_usercode + "]";
	}

}
