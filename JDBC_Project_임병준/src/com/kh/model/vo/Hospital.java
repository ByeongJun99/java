package com.kh.model.vo;

public class Hospital {
	private int hosNo;
	private String hosName;
	private String hosPhone;
	private String address;
	private int vaccine_amount;
	
	public Hospital() {
		super();
	}

	public Hospital(String hosName, String hosPhone, String address, int vaccine_amount) {
		super();
		this.hosName = hosName;
		this.hosPhone = hosPhone;
		this.address = address;
		this.vaccine_amount = vaccine_amount;
	}

	public Hospital(int hosNo, String hosName, String hosPhone, String address, int vaccine_amount) {
		super();
		this.hosNo = hosNo;
		this.hosName = hosName;
		this.hosPhone = hosPhone;
		this.address = address;
		this.vaccine_amount = vaccine_amount;
	}

	public int getHosNo() {
		return hosNo;
	}

	public void setHosNo(int hosNo) {
		this.hosNo = hosNo;
	}

	public String getHosName() {
		return hosName;
	}

	public void setHosName(String hosName) {
		this.hosName = hosName;
	}

	public String getHosPhone() {
		return hosPhone;
	}

	public void setHosPhone(String hosPhone) {
		this.hosPhone = hosPhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getVaccine_amount() {
		return vaccine_amount;
	}

	public void setVaccine_amount(int vaccine_amount) {
		this.vaccine_amount = vaccine_amount;
	}

	@Override
	public String toString() {
		return hosNo + ", " + hosName + ", " + hosPhone + ", " + address + ", " + vaccine_amount;
	}
}
