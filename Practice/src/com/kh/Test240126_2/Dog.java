package com.kh.Test240126_2;

public class Dog extends Animal {
	public final String PLACE = "애견카페";
	private int weight;
	
	public Dog() {
		super();
	}

	public Dog(String name, String kinds, int weight) {
		super(name, kinds);
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getPLACE() {
		return PLACE;
	}

	@Override
	public void speak() {
		System.out.println(super.toString() + "몸무게는 " + getWeight() + "kg 입니다.");
	}
}
