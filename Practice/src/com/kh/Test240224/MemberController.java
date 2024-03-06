package com.kh.Test240224;

public class MemberController {
	public final int SIZE = 10;
	private Member[] m = new Member[SIZE];
	
	private int cnt = 0;
	
	public int existMemberNum() {
		return cnt;
	}
	
	public Boolean checkId(String inputId) {
		for(int i=0; i<cnt; i++) {
			if (m[i].getId().equals(inputId)) {
				return true;
			}
		}
		return false;
	}
	
	public void insertMember(String id, String name, String password, String email, char gender, int age) {
		m[cnt] = new Member(id, name, password, email, gender, age);
		cnt++;
	}
	
	public String searchId(String id) {
		for(int i=0; i<cnt; i++) {
			if (m[i].getId().equals(id)) {
				return m[i].inform();
			}
		}
		return "검색 결과가 없습니다.";
	}
	
	public Member[] searchName(String name) {
		Member[] m1 = new Member[SIZE];
		int count = 0;
		
		for(int i=0; i<cnt; i++) {
			if (m[i].getName().equals(name)) {
				m1[count++] = m[i];
			}
		}
		return m1;
	}
	
	public Member[] searchEmail(String email) {
		Member[] m2 = new Member[SIZE];
		int count = 0;
		
		for(int i=0; i<cnt; i++) {
			if (m[i].getEmail().equals(email)) {
				m2[count++] = m[i];
			}
		}
		return m2;
	}
	
	public Boolean updatePassword(String id, String password) {
		for(int i=0; i<cnt; i++) {
			if (m[i].getId().equals(id)) {
				m[i].setPassword(password);
				return true;
			}
		}
		return false;
	}
	
	public Boolean updateName(String id, String name) {
		for(int i=0; i<cnt; i++) {
			if (m[i].getId().equals(id)) {
				m[i].setName(name);
				return true;
			}
		}
		return false;
	}
	
	public boolean updateEmail(String id, String email) {
		for(int i=0; i<cnt; i++) {
			if (m[i].getId().equals(id)) {
				m[i].setEmail(email);
				return true;
			}
		}
		return false;
	}
	
	public Boolean delete(String id) {
		for(int i=0; i<cnt; i++) {
			if (m[i].getId().equals(id)) {
				Member[] m3 = new Member[SIZE];
				for(int j=0; j<i; j++) {
					m3[j] = m[j];
				}
				for(int j=i; j<cnt; j++) {
					m3[j] = m[j+1];
				}
				m = m3;
			}
		}
		return true;
	}
	
	public void delete() {
		m = new Member[SIZE];
	}
	
	public Member[] printAll() {
		return m;
	}
}