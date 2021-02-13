package com.web.dazu.model;

public class Mealkit {
	private int class_information_classcode;
	private String mealkit_detail;
	private String mealkit_thumbnail;
	private int mealkitcode;
	private String mealkit_name;
	private int mealkit_price;
	
	private String class_information_classname;
	
	public Mealkit() {}

	public Mealkit(int class_information_classcode, String mealkit_detail, String mealkit_thumbnail, int mealkitcode,
			String mealkit_name, int mealkit_price, String class_information_classname) {
		super();
		this.class_information_classcode = class_information_classcode;
		this.mealkit_detail = mealkit_detail;
		this.mealkit_thumbnail = mealkit_thumbnail;
		this.mealkitcode = mealkitcode;
		this.mealkit_name = mealkit_name;
		this.mealkit_price = mealkit_price;
		this.class_information_classname = class_information_classname;
	}

	public int getClass_information_classcode() {
		return class_information_classcode;
	}

	public void setClass_information_classcode(int class_information_classcode) {
		this.class_information_classcode = class_information_classcode;
	}

	public String getMealkit_detail() {
		return mealkit_detail;
	}

	public void setMealkit_detail(String mealkit_detail) {
		this.mealkit_detail = mealkit_detail;
	}

	public String getMealkit_thumbnail() {
		return mealkit_thumbnail;
	}

	public void setMealkit_thumbnail(String mealkit_thumbnail) {
		this.mealkit_thumbnail = mealkit_thumbnail;
	}

	public int getMealkitcode() {
		return mealkitcode;
	}

	public void setMealkitcode(int mealkitcode) {
		this.mealkitcode = mealkitcode;
	}

	public String getMealkit_name() {
		return mealkit_name;
	}

	public void setMealkit_name(String mealkit_name) {
		this.mealkit_name = mealkit_name;
	}

	public int getMealkit_price() {
		return mealkit_price;
	}

	public void setMealkit_price(int mealkit_price) {
		this.mealkit_price = mealkit_price;
	}

	public String getClass_information_classname() {
		return class_information_classname;
	}

	public void setClass_information_classname(String class_information_classname) {
		this.class_information_classname = class_information_classname;
	}

	
}
