package com.web.dazu.model;

public class Board {
	String board_code;
	String board_write_datetime;
	String board_title;
	String board_contents;
	String board_good;
	String board_visit;
	String member_usercode;
	
	public Board() {}
	public Board(String board_code, String board_write_datetime, String board_title, String board_contents,
			String board_hood, String board_visit, String user_code) {
		super();
		this.board_code = board_code;
		this.board_write_datetime = board_write_datetime;
		this.board_title = board_title;
		this.board_contents = board_contents;
		this.board_good = board_hood;
		this.board_visit = board_visit;
		this.member_usercode = user_code;
	}
	public String getBoard_code() {
		return board_code;
	}
	public void setBoard_code(String board_code) {
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
	public String getBoard_hood() {
		return board_good;
	}
	public void setBoard_hood(String board_hood) {
		this.board_good = board_hood;
	}
	public String getBoard_visit() {
		return board_visit;
	}
	public void setBoard_visit(String board_visit) {
		this.board_visit = board_visit;
	}
	public String getUser_code() {
		return member_usercode;
	}
	public void setUser_code(String user_code) {
		this.member_usercode = user_code;
	}
	@Override
	public String toString() {
		return "Board [board_code=" + board_code + ", board_write_datetime=" + board_write_datetime + ", board_title="
				+ board_title + ", board_contents=" + board_contents + ", board_good=" + board_good + ", board_visit="
				+ board_visit + ", member_usercode=" + member_usercode + "]";
	}
	
	
}
