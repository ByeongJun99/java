package com.kh.Test240207;

import java.util.HashMap;
import java.util.TreeMap;

public class MemberController {
	private HashMap map = new HashMap();
	
	public boolean joinMembership(String id, Member m) {
		if (!map.containsKey(id)) {
			map.put(id, m);
			return true;
		}
		else {
			return false;
		}
	}
	
	public String logIn(String id, String password) {
		if (map.containsKey(id) && ((Member) map.get(id)).getPassword().equals(password)) {
			return ((Member) map.get(id)).getName();
		}
		else {
			return null;
		}
	}
	
	public boolean changePassword(String id, String oldPw, String newPw) {
		if (map.containsKey(id) && ((Member) map.get(id)).getPassword().equals(oldPw)) {
			((Member) map.get(id)).setPassword(newPw);
			return true;
		}
		else {
			return false;
		}
	}
	
	public void changeName(String id, String newName) {
		((Member) map.get(id)).setName(newName);
	}
	
	public TreeMap<String, String> sameName(String name) {
		TreeMap<String, String> sameNameMap = new TreeMap<>();
		
		for(Object key : map.keySet()) {
			Member m = (Member) map.get(key);
			if (m.getName().equals(name)) {
				sameNameMap.put((String) key, m.getName());
			}
		}
		return sameNameMap;
	}
}
