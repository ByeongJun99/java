package com.kh.Test240207_2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class FarmMenu {
	private Scanner sc = new Scanner(System.in);
	private FarmController fc = new FarmController();
	
	public void mainMenu() {
		System.out.println("========== KH 마트 ==========");
		while (true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 직원메뉴");
			System.out.println("2. 손님 메뉴");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				adminMenu();
				break;
			case 2:
				customerMenu();
				break;
			case 9:
				System.out.println("프로그램 종료.");
				return;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void adminMenu() {
		System.out.println("******* 직원 메뉴 *******");
		System.out.println("1. 새 농산물 추가");
		System.out.println("2. 종류 삭제");
		System.out.println("3. 수량 수정");
		System.out.println("4. 농산물 목록");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 선택 : ");
		int choice = sc.nextInt();
		sc.nextLine();
		
		switch(choice) {
		case 1:
			addNewKind();
			adminMenu();
			break;
		case 2:
			removeKind();
			adminMenu();
			break;
		case 3:
			changeAmount();
			adminMenu();
			break;
		case 4:
			printFarm();
			adminMenu();
			break;
		case 9:
			break;
		default:
			System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			adminMenu();
		}
	}
	
	public void customerMenu() {
		printFarm();
		System.out.println("******* 고객 메뉴 *******");
		System.out.println("1. 농산물 사기");
		System.out.println("2. 농산물 빼기");
		System.out.println("3. 구입한 농산물 보기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 선택 : ");
		int choice = sc.nextInt();
		sc.nextLine();
		
		switch(choice) {
		case 1:
			buyFarm();
			customerMenu();
			break;
		case 2:
			removeFarm();
			customerMenu();
			break;
		case 3:
			printBuyFarm();
			customerMenu();
			break;
		case 9:
			break;
		default:
			System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			customerMenu();
		}
	}
	
	public void addNewKind() {
		System.out.println("1. 과일 / 2. 채소 / 3. 견과");
		System.out.print("추가할 종류 번호 : ");
		int choice = sc.nextInt();
		sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("수량 : ");
		int amount = sc.nextInt();
		sc.nextLine();
		
		switch(choice) {
		case 1:
			Fruit f = new Fruit("과일", name);
			if (fc.addNewKind(f, amount)) {
				System.out.println("새 농산물이 추가되었습니다.");
			}
			else {
				System.out.println("새 농산물 추가에 실패하였습니다. 다시 입력해주세요.");
				addNewKind();
			}
			break;
		case 2:
			Vegetable v = new Vegetable("채소", name);
			if (fc.addNewKind(v, amount)) {
				System.out.println("새 농산물이 추가되었습니다.");
			}
			else {
				System.out.println("새 농산물 추가에 실패하였습니다. 다시 입력해주세요.");
				addNewKind();
			}
			break;
		case 3:
			Nut n = new Nut("견과", name);
			if (fc.addNewKind(n, amount)) {
				System.out.println("새 농산물이 추가되었습니다.");
			}
			else {
				System.out.println("새 농산물 추가에 실패하였습니다. 다시 입력해주세요.");
				addNewKind();
			}
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			addNewKind();
		}
	}
	
	public void removeKind() {
		System.out.println("1. 과일 / 2. 채소 / 3. 견과");
		System.out.print("삭제할 종류 번호 : ");
		int choice = sc.nextInt();
		sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		switch(choice) {
		case 1:
			Fruit f = new Fruit("과일", name);
			if (fc.removeFarm(f)) {
				System.out.println("농산물 삭제에 성공하였습니다.");
			}
			else {
				System.out.println("농산물 삭제에 실패하였습니다. 다시 입력해주세요.");
				removeKind();
			}
			break;
		case 2:
			Vegetable v = new Vegetable("채소", name);
			if (fc.removeFarm(v)) {
				System.out.println("농산물 삭제에 성공하였습니다.");
			}
			else {
				System.out.println("농산물 삭제에 실패하였습니다. 다시 입력해주세요.");
				removeKind();
			}
			break;
		case 3:
			Nut n = new Nut("견과", name);
			if (fc.removeFarm(n)) {
				System.out.println("농산물 삭제에 성공하였습니다.");
			}
			else {
				System.out.println("농산물 삭제에 실패하였습니다. 다시 입력해주세요.");
				removeKind();
			}
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			removeKind();
		}
	}
	
	public void changeAmount() {
		System.out.println("1. 과일 / 2. 채소 / 3. 견과");
		System.out.print("수정할 종류 번호 : ");
		int choice = sc.nextInt();
		sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("수량 : ");
		int amount = sc.nextInt();
		sc.nextLine();
		
		switch(choice) {
		case 1:
			Fruit f = new Fruit("과일", name);
			if (fc.changeAmount(f, amount)) {
				System.out.println("농산물 수량이 수정되었습니다.");
			}
			else {
				System.out.println("농산물 수량 수정에 실패하였습니다. 다시 입력해주세요.");
			}
			break;
		case 2:
			Vegetable v = new Vegetable("채소", name);
			if (fc.changeAmount(v, amount)) {
				System.out.println("농산물 수량이 수정되었습니다.");
			}
			else {
				System.out.println("농산물 수량 수정에 실패하였습니다. 다시 입력해주세요.");
			}
			break;
		case 3:
			Nut n = new Nut("견과", name);
			if (fc.changeAmount(n, amount)) {
				System.out.println("농산물 수량이 수정되었습니다.");
			}
			else {
				System.out.println("농산물 수량 수정에 실패하였습니다. 다시 입력해주세요.");
			}
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			changeAmount();
		}
	}
	
	public void printFarm() {
		HashMap<Farm, Integer> farm = fc.printFarm();
		for (Farm mapKey : farm.keySet()) 
		{
			if (mapKey instanceof Fruit) {
				System.out.println(((Fruit) mapKey).getName() + "(" + farm.get(mapKey) + "개)");
			}
			else if (mapKey instanceof Vegetable) {
				System.out.println(((Vegetable) mapKey).getName() + "(" + farm.get(mapKey) + "개)");
			}
			else if (mapKey instanceof Nut) {
				System.out.println(((Nut) mapKey).getName() + "(" + farm.get(mapKey) + "개)");
			}
		}
	}
	
	public void buyFarm() {
		System.out.println("1. 과일 / 2. 채소 / 3. 견과");
		System.out.print("구매할 종류 번호 : ");
		int choice = sc.nextInt();
		sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		switch(choice) {
		case 1:
			Fruit f = new Fruit("과일", name);
			if (fc.buyFarm(f)) {
				System.out.println("구매에 성공하였습니다.");
			}
			else {
				System.out.println("마트에 없는 물건이거나 수량이 없습니다. 다시 입력해주세요.");
			}
			break;
		case 2:
			Vegetable v = new Vegetable("채소", name);
			if (fc.buyFarm(v)) {
				System.out.println("구매에 성공하였습니다.");
			}
			else {
				System.out.println("마트에 없는 물건이거나 수량이 없습니다. 다시 입력해주세요.");
			}
			break;
		case 3:
			Nut n = new Nut("견과", name);
			if (fc.buyFarm(n)) {
				System.out.println("구매에 성공하였습니다.");
			}
			else {
				System.out.println("마트에 없는 물건이거나 수량이 없습니다. 다시 입력해주세요.");
			}
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			buyFarm();
		}
	}
	
	public void removeFarm() {
		System.out.println("1. 과일 / 2. 채소 / 3. 견과");
		System.out.print("구매 취소할 종류 번호 : ");
		int choice = sc.nextInt();
		sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		switch(choice) {
		case 1:
			Fruit f = new Fruit("과일", name);
			if (fc.removeFarm(f)) {
				System.out.println("구매 취소에 성공하였습니다.");
			}
			else {
				System.out.println("구매매 목록에 존재하지 않습니다. 다시 입력해주세요.");
			}
			break;
		case 2:
			Vegetable v = new Vegetable("채소", name);
			if (fc.removeFarm(v)) {
				System.out.println("구매 취소에 성공하였습니다.");
			}
			else {
				System.out.println("구매매 목록에 존재하지 않습니다. 다시 입력해주세요.");
			}
			break;
		case 3:
			Nut n = new Nut("견과", name);
			if (fc.removeFarm(n)) {
				System.out.println("구매 취소에 성공하였습니다.");
			}
			else {
				System.out.println("구매매 목록에 존재하지 않습니다. 다시 입력해주세요.");
			}
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			removeFarm();
		}
	}
	
	public void printBuyFarm() {
		Iterator<Farm> iterator = fc.printBuyFarm().iterator();
		System.out.println("현재 KH마트 농산물 수량");
		for (Farm str : fc.printBuyFarm()) {
			if (str instanceof Fruit) {
				System.out.println(str.getKind() + " : " + ((Fruit) str).getName());
			}
			else if (str instanceof Vegetable) {
				System.out.println(str.getKind() + " : " + ((Vegetable) str).getName());
			}
			else if (str instanceof Nut) {
				System.out.println(str.getKind() + " : " + ((Nut) str).getName());
			}
		}
	}
}
