package com.kh.Test240126_2;

import java.util.Scanner;

public class AnimalManager {
	
	/*
	 * 추상클래스
	 *  - 미완성된 클래스
	 *  - 객체생성이 불가(단, 레퍼런스 변수(참조변수)선언 가능)
	 *  - 일반필드 + 일반메소드 [+ 추상메소드]
	 *  => 추상메소드를 가진 클래스는 반드시 추상클래스로 명시해야됨.
	 *  
	 * * 추상메소드가 굳이 없어도 추상클래스를 사용할 수 있을까? ok
	 * 	> 개념적 : 단지 이 클래스가 미완성된 클래스다 라는 것을 알리기 위해서
	 * 	> 프로그래밍적 : 객체 생성이 불가 하게끔 하고자 할 때
	 * 
	 * * 추상메소드가 있는 추상클래스를 사용하는 이유
	 *  - 부모클래스에 추상메소드가 존재할 경우
	 *    자식클래스에서는 강제로 오 버라이딩해서 동일한 패턴의 메소드를 가지게 된다.
	 *  => 각 자식 클래스마다 실행시킬 내용은 다르지만 동일한 형태의 메소드로 구현했으면 할 때
	 */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Animal[] arr = new Animal[5];
		
		for(int i=0; i<arr.length; i++) {
			System.out.print("Dog(1) / Cat(2) 중 하나 선택(1 or 2 입력) : ");
			int kinds = sc.nextInt();
			sc.nextLine();
			
			switch (kinds) {
			case 1:
				arr[i] = new Dog();
				arr[i].setKinds("강아지");
				
				System.out.print("이름 : ");
				arr[i].setName(sc.nextLine());
				
				System.out.print("몸무게 : ");
				((Dog) arr[i]).setWeight(sc.nextInt());
				
				((Dog) arr[i]).speak();
				break;
			case 2:
				arr[i] = new Cat();
				arr[i].setKinds("고양이");
				
				System.out.print("이름 : ");
				arr[i].setName(sc.nextLine());
				
				System.out.print("서식지 : ");
				((Cat) arr[i]).setLocation(sc.nextLine());
				System.out.print("색상 : ");
				((Cat) arr[i]).setColor(sc.nextLine());
				
				((Cat) arr[i]).speak();
				break;
			}
		}
		
//		for(Animal i : arr) {
//			if(i instanceof Dog) {
//				((Dog) i).speak();
//			}
//			else if(i instanceof Cat) {
//				((Cat) i).speak();
//			}
//		}
		
	}

}