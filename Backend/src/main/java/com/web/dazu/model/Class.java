package com.web.dazu.model;

public class Class {
	private int classcode;
	private String class_name;
	private String class_time;
	private String class_describe;
	private String class_difficult;
	private String mealkit_ok;
	private String food_type;
	private String store_information_storecode;
	private String store_information_store_name;
	private String store_information_store_describe;
	private int mealkit_price;
	private int class_max;
	private int class_price;

	public Class(int classcode, String class_name, String class_time, String class_describe, String class_difficult,
			String mealkit_ok, String food_type, String store_information_storecode,
			String store_information_store_name, String store_information_store_describe, int mealkit_price,
			int class_max, int class_price) {
		super();
		this.classcode = classcode;
		this.class_name = class_name;
		this.class_time = class_time;
		this.class_describe = class_describe;
		this.class_difficult = class_difficult;
		this.mealkit_ok = mealkit_ok;
		this.food_type = food_type;
		this.store_information_storecode = store_information_storecode;
		this.store_information_store_name = store_information_store_name;
		this.store_information_store_describe = store_information_store_describe;
		this.mealkit_price = mealkit_price;
		this.class_max = class_max;
		this.class_price = class_price;
	}

	public Class() {}

	public int getClasscode() {
		return classcode;
	}

	public void setClasscode(int classcode) {
		this.classcode = classcode;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getClass_time() {
		return class_time;
	}

	public void setClass_time(String class_time) {
		this.class_time = class_time;
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

	public String getMealkit_ok() {
		return mealkit_ok;
	}

	public void setMealkit_ok(String mealkit_ok) {
		this.mealkit_ok = mealkit_ok;
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

	public String getStore_information_store_name() {
		return store_information_store_name;
	}

	public void setStore_information_store_name(String store_information_store_name) {
		this.store_information_store_name = store_information_store_name;
	}

	public String getStore_information_store_describe() {
		return store_information_store_describe;
	}

	public void setStore_information_store_describe(String store_information_store_describe) {
		this.store_information_store_describe = store_information_store_describe;
	}

	public int getMealkit_price() {
		return mealkit_price;
	}

	public void setMealkit_price(int mealkit_price) {
		this.mealkit_price = mealkit_price;
	}

	public int getClass_max() {
		return class_max;
	}

	public void setClass_max(int class_max) {
		this.class_max = class_max;
	}

	public int getClass_price() {
		return class_price;
	}

	public void setClass_price(int class_price) {
		this.class_price = class_price;
	}


}
