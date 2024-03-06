package com.kh.Test240125;

import java.util.Scanner;

public class LibraryMenu {
	private LibraryController lc = new LibraryController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.print("성별 : ");
		char gender = sc.nextLine().charAt(0);
		Member mem = new Member(name, age, gender);
		lc.insertMember(mem);
		
		while(true) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색");
			System.out.println("4. 도서 대여하기");
			System.out.println("9. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				System.out.println(lc.myInfo().toString());
				break;
			case 2:
				selectAll();
				break;
			case 3:
				searchBook();
				break;
			case 4:
				selectAll();
				rentBook();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			}

		}
		
	}
	
	public void selectAll() {
		Book[] b = lc.selectAll();
		for(int i=0; i<b.length; i++) {
			System.out.print(i + "번 도서 : " + b[i].getTitle() + " / " + b[i].getAuthor() + " / " + b[i].getPublisher() + " / ");
			if (b[i] instanceof CookBook) {
				System.out.println(((CookBook)b[i]).isCoupon());
			}
			else {
				System.out.println(((AniBook)b[i]).getAccessAge());
			}
		}
	}
	
	public void searchBook() {
		sc.nextLine();
		System.out.print("검색할 제목 키워드 : ");
		String keyword = sc.nextLine();
		Book[] searchList = lc.searchBook(keyword);
		for(int i=0; i<searchList.length; i++) {
			if (searchList[i] != null) {				
				System.out.print(searchList[i].getTitle() + " / " + searchList[i].getAuthor() + " / " + searchList[i].getPublisher() + " / ");
				if (searchList[i] instanceof CookBook) {
					System.out.println(((CookBook)searchList[i]).isCoupon());
				}
				else {
					System.out.println(((AniBook)searchList[i]).getAccessAge());
				}
			}
		}
	}
	
	public void rentBook() {
		System.out.print("대여할 도서 번호 선택 : ");
		int index = sc.nextInt();
		int result = lc.rentBook(index);
		switch(result) {
		case 0:
			System.out.println("성공적으로 대여되었습니다.");
			break;
		case 1:
			System.out.println("나이 제한으로 대여 불가능입니다.");
			break;
		case 2:
			System.out.println("성공적으로 대여되었습니다. 우리학원 쿠폰이 발급되었으니 마이페이지에서 확인하세요.");
			break;
		}
	}
}
