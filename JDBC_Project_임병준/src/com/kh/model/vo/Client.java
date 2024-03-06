package com.kh.model.vo;

public class Client {
	private int clNo;
	private String clId;
	private String clPw;
	private int clGrade;
	
	public Client() {
		super();
	}

	public Client(String clId, String clPw, int clGrade) {
		super();
		this.clId = clId;
		this.clPw = clPw;
		this.clGrade = clGrade;
	}

	public Client(int clNo, String clId, String clPw, int clGrade) {
		super();
		this.clNo = clNo;
		this.clId = clId;
		this.clPw = clPw;
		this.clGrade = clGrade;
	}

	public int getClNo() {
		return clNo;
	}

	public void setClNo(int clNo) {
		this.clNo = clNo;
	}

	public String getClId() {
		return clId;
	}

	public void setClId(String clId) {
		this.clId = clId;
	}

	public String getClPw() {
		return clPw;
	}

	public void setClPw(String clPw) {
		this.clPw = clPw;
	}

	public int getClGrade() {
		return clGrade;
	}

	public void setClGrade(int clGrade) {
		this.clGrade = clGrade;
	}

	@Override
	public String toString() {
		return clNo + ", " + clId + ", " + clPw + ", " + clGrade;
	}
}
