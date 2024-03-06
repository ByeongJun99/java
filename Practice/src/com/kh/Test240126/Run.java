package com.kh.Test240126;

public class Run {

	public static void main(String[] args) {

		String[] me = new PhoneController().method();
		
		for(int i=0; i<me.length; i++) {
			System.out.println(me[i]);
			System.out.println();
		}
		
	}

}
