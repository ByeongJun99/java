package com.kh.Test240201;

import java.util.Scanner;

public class FileMenu {
	private Scanner sc = new Scanner(System.in);
	private FileController fc = new FileController();
	
	public void mainMenu() {
		System.out.println("***** My Note *****");
		System.out.println("1. 노트 새로 만들기");
		System.out.println("2. 노트 열기");
		System.out.println("3. 노트 열어서 수정하기");
		System.out.println("9. 끝내기");
		System.out.print("메뉴 번호 : ");
		int option = sc.nextInt();
		sc.nextLine();
		
		switch(option) {
		case 1:
			fileSave();
			mainMenu();
			break;
		case 2:
			fileOpen();
			mainMenu();
			break;
		case 3:
			fileEdit();
			mainMenu();
			break;
		case 9:
			System.out.println("프로그램을 종료합니다.");
			return;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			mainMenu();
			
		}
	}
	
	public void fileSave() {
		System.out.println("파일에 저장할 내용을 입력하세요.");
		System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
		System.out.print("내용 : ");
		String input = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		while (!(input.equals("ex끝it"))) {
			sb.append(input + "\n");
			System.out.println("파일에 저장할 내용을 입력하세요.");
			System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
			System.out.print("내용 : ");
			input = sc.nextLine();
		}
		while (true) {
			System.out.print("저장할 파일 명을 입력해주세요(ex. myFile.txt) : ");
			String fName = sc.nextLine();
			if (fc.checkName(fName) == true) {
				System.out.print("이미 존재하는 파일입니다. 덮어쓰시겠습니까?(y/n) : ");
				char yorn = sc.nextLine().toLowerCase().charAt(0);
				if (yorn == 'y') {
					fc.fileSave(fName, sb);
					break;
				}
			}
			else {
				fc.fileSave(fName, sb);
				break;
			}
			
		}
	}
	
	public void fileOpen() {
		System.out.print("열 파일 명 : ");
		String input = sc.nextLine();
		if (fc.checkName(input) == true) {
			System.out.println(fc.fileOpen(input));
		}
		else {
			System.out.println("없는 파일입니다.");
		}
	}
	
	public void fileEdit() {
		System.out.print("수정할 파일 명 : ");
		String fName = sc.nextLine();
		if (fc.checkName(fName) == false) {
			System.out.println("없는 파일입니다.");
		}
		else {
			System.out.println("파일에 저장할 내용을 입력하세요.");
			System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
			System.out.print("내용 : ");
			String input = sc.nextLine();
			StringBuilder sb = new StringBuilder();
			while (!(input.equals("ex끝it"))) {
				sb.append(input + "\n");
				System.out.println("파일에 저장할 내용을 입력하세요.");
				System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
				System.out.print("내용 : ");
				input = sc.nextLine();
			}
			fc.fileEdit(fName, sb);
		}
	}
}
