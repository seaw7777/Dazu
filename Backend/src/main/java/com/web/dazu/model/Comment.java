package com.web.dazu.model;

public class Comment {
	String comment_code;
	String comment_write_datetime;
	String comment_contents;
	String board_code;
	String member_usercode;
	String nickname;
	public Comment() {}
	public Comment(String comment_code, String comment_write_datetime, String comment_contents, String board_code,
			String member_usercode, String nickname) {
		super();
		this.comment_code = comment_code;
		this.comment_write_datetime = comment_write_datetime;
		this.comment_contents = comment_contents;
		this.board_code = board_code;
		this.member_usercode = member_usercode;
		this.nickname = nickname;
	}
	public String getComment_code() {
		return comment_code;
	}
	public void setComment_code(String comment_code) {
		this.comment_code = comment_code;
	}
	public String getComment_write_datetime() {
		return comment_write_datetime;
	}
	public void setComment_write_datetime(String comment_write_datetime) {
		this.comment_write_datetime = comment_write_datetime;
	}
	public String getComment_contents() {
		return comment_contents;
	}
	public void setComment_contents(String comment_contents) {
		this.comment_contents = comment_contents;
	}
	public String getBoard_code() {
		return board_code;
	}
	public void setBoard_code(String board_code) {
		this.board_code = board_code;
	}
	public String getMember_usercode() {
		return member_usercode;
	}
	public void setMember_usercode(String member_usercode) {
		this.member_usercode = member_usercode;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
