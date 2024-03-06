package miniProject01;

import java.util.Scanner;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	Member[] memberArr = new Member[2];
	Member m1 = new Member();
	Member m2 = new Member();
	
	public void InitMenu() {	// 초기메뉴
		while(true) {
			System.out.println("** 초기메뉴 **");
			System.out.println("[1] 회원가입");
			System.out.println("[2] 로그인");
			System.out.println("[9] 프로그램 종료");
			System.out.print("메뉴를 선택하세요. : ");
			int option1 = sc.nextInt();
			sc.nextLine();
			
			switch(option1) {
			case 1:
				signUp();
				break;
			case 2:
				signIn();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
	
	public void signUp() {	// 회원가입
		System.out.println("** 회원가입 **");
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.print("성별을 입력하세요(m/f) : ");
		char gender = sc.nextLine().charAt(0);
		System.out.print("지역을 입력하세요 : ");
		String area = sc.nextLine();
		System.out.print("권한 등급을 설정하세요(1:관리자, 2:게스트) : ");
		int permission = sc.nextInt();
		sc.nextLine();
		
		m1.setName(name);
		m1.setAge(age);
		m1.setGender(gender);
		m1.setArea(area);
		m1.setPermission(permission);
		
		System.out.println(m1.toString());
	}
	
	public void signIn() {	// 로그인
		switch(m1.getPermission()) {
		case 1:
			break;
		case 2:
			break;
		}
	}
}
