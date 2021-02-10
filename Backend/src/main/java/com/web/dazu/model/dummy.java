package com.web.dazu.model;

public class dummy {
	String address;
	String detailaddress;
	
	public dummy() {}

	public dummy(String address, String detailaddress) {
		super();
		this.address = address;
		this.detailaddress = detailaddress;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailaddress() {
		return detailaddress;
	}

	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}

	@Override
	public String toString() {
		return "dummy [address=" + address + ", detailaddress=" + detailaddress + "]";
	}
	
}
