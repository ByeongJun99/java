package com.kh.Test240126;

public abstract class SmartPhone implements CellPhone, TouchDisplay {
	private String maker;	// 제조사 정보

	public SmartPhone() {
		super();
	}
	
	public String printInformation() {
		return "은 " + maker + "에서 만들어졌고 제원은 다음과 같다.";
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}
	
}
