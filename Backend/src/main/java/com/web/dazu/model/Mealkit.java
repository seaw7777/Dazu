package com.web.dazu.model;

public class Mealkit {
	private int class_information_classcode;
	private String mealkit_image;
	private int mealkitcode;
	private String mealkit_name;
	private int mealkit_price;
	
	private String class_information_classname;
	
	public Mealkit() {}

	public Mealkit(int class_information_classcode, String mealkit_image, int mealkitcode, String mealkit_name,
			int mealkit_price, String class_information_classname) {
		super();
		this.class_information_classcode = class_information_classcode;
		this.mealkit_image = mealkit_image;
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

	public String getMealkit_image() {
		return mealkit_image;
	}

	public void setMealkit_image(String mealkit_image) {
		this.mealkit_image = mealkit_image;
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
