package com.web.dazu.model;

public class Class {
	private String classcode;
	private String class_name;
	private String class_startdate;
	private String class_enddate;
	private String class_describe;
	private String class_difficult;
	private int class_price;
	private String food_type;
	private String store_information_storecode;
	
	public Class() {}
	

	public Class(String classcode, String class_name, String class_startdate, String class_enddate,
			String class_describe, String class_difficult, int class_price, String food_type,
			String store_information_storecode) {
		super();
		this.classcode = classcode;
		this.class_name = class_name;
		this.class_startdate = class_startdate;
		this.class_enddate = class_enddate;
		this.class_describe = class_describe;
		this.class_difficult = class_difficult;
		this.class_price = class_price;
		this.food_type = food_type;
		this.store_information_storecode = store_information_storecode;
	}


	public String getClasscode() {
		return classcode;
	}

	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getClass_startdate() {
		return class_startdate;
	}

	public void setClass_startdate(String class_startdate) {
		this.class_startdate = class_startdate;
	}

	public String getClass_enddate() {
		return class_enddate;
	}

	public void setClass_enddate(String class_enddate) {
		this.class_enddate = class_enddate;
	}

	public String getClass_describe() {
		return class_describe;
	}

	public void setClass_describe(String class_describe) {
		this.class_describe = class_describe;
	}

	public String getClass_difficult() {
		return class_difficult;
	}

	public void setClass_difficult(String class_difficult) {
		this.class_difficult = class_difficult;
	}

	public String getFood_type() {
		return food_type;
	}

	public void setFood_type(String food_type) {
		this.food_type = food_type;
	}

	public String getStore_information_storecode() {
		return store_information_storecode;
	}

	public void setStore_information_storecode(String store_information_storecode) {
		this.store_information_storecode = store_information_storecode;
	}


	public int getClass_price() {
		return class_price;
	}


	public void setClass_price(int class_price) {
		this.class_price = class_price;
	}
	
	
}
