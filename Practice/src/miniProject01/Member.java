package miniProject01;

public class Member {
	private String name;	// 이름
	private int age;		// 나이
	private char gender;	// 성별
	private String area;	// 지역
	private int permission;	// 권한 등급(1:관리자, 2:게스트)
	
	public Member() {
		super();
	}

	public Member(String name, int age, char gender, String area, int permission) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.area = area;
		this.permission = permission;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	public int getPermission() {
		return permission;
	}
	
	public void setPermission(int permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "<생성완료> 이름 : " + name + "나이 : " + age + "성별 : " + gender + "지역 : " + area + "권한등급 : " + permission;
	}
	
}
