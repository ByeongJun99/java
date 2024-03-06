package com.kh.practice01;

import java.util.StringTokenizer;

public class TokenController {
	public TokenController() {
		
	}
	
	public String afterToken(String str) {
		String res = "";
		StringTokenizer stn = new StringTokenizer(str, " ");
		for(int i=0; i<stn.countTokens(); ) {
			res += stn.nextToken();
		}
		return res;
	}
	
	public String firstCap(String input) {
		if(input == null || input.isEmpty()) {
			return input;
		}
		
		String s1 = input.substring(0).toUpperCase();
		String s2 = input.substring(1, input.length());
		return s1.concat(s2);
	}
	
	public int findChar(String input, char one) {
		int cnt = 0;
		
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i) == one) {
				cnt++;
			}
		}
		
		return cnt;
	}
}
