package com.web.dazu.model;

public class Store {
	private String storecode;
	private String store_name;
	private String store_describe;
	private String store_location;
	private int store_grade;
	private String dong;
	private String lat;
	private String lng;
	private String member_usercode;
	
	public Store() {}

	public Store(String storecode, String store_name, String store_describe, String store_location, int store_grade,
			String dong, String lat, String lng, String member_usercode) {
		super();
		this.storecode = storecode;
		this.store_name = store_name;
		this.store_describe = store_describe;
		this.store_location = store_location;
		this.store_grade = store_grade;
		this.dong = dong;
		this.lat = lat;
		this.lng = lng;
		this.member_usercode = member_usercode;
	}

	public String getStorecode() {
		return storecode;
	}

	public void setStorecode(String storecode) {
		this.storecode = storecode;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getStore_describe() {
		return store_describe;
	}

	public void setStore_describe(String store_describe) {
		this.store_describe = store_describe;
	}

	public String getStore_location() {
		return store_location;
	}

	public void setStore_location(String store_location) {
		this.store_location = store_location;
	}

	public int getStore_grade() {
		return store_grade;
	}

	public void setStore_grade(int store_grade) {
		this.store_grade = store_grade;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
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

	public String getMember_usercode() {
		return member_usercode;
	}

	public void setMember_usercode(String member_usercode) {
		this.member_usercode = member_usercode;
	}
	
	
}
