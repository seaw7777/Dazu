package com.web.dazu.model;

public class Member {
	private String usercode;
	private String create_date;
	private String address;
	private String address_detail;
	private int usertype;
	
	private String lat;
	private String lng;
	
	private String nickname;
	private String profileImage;
	private String accessToken;
	
	public Member() {}

	public Member(String usercode, String create_date, String address, String address_detail, int usertype, String lat,
			String lng, String nickname, String profileImage, String accessToken) {
		this.usercode = usercode;
		this.create_date = create_date;
		this.address = address;
		this.address_detail = address_detail;
		this.usertype = usertype;
		this.lat = lat;
		this.lng = lng;
		this.nickname = nickname;
		this.profileImage = profileImage;
		this.accessToken = accessToken;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress_detail() {
		return address_detail;
	}

	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}
