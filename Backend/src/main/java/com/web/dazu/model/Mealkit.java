package com.web.dazu.model;

public class Mealkit {
	private String classcode;
	private String mealkit_name;
	private int mealkit_price;
	
	public Mealkit() {}

	public Mealkit(String classcode, String mealkit_name, int mealkit_price) {
		super();
		this.classcode = classcode;
		this.mealkit_name = mealkit_name;
		this.mealkit_price = mealkit_price;
	}

	public String getClasscode() {
		return classcode;
	}

	public void setClasscode(String classcode) {
		this.classcode = classcode;
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
	
}
