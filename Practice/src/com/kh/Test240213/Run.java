package com.kh.Test240213;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// 홀수 짝수 출력하기
		
		// 랜덤으로 숫자 5개 입력받아 출력하기
		
		// 랜덤으로 숫자 10개 입력받아 짝수만 출력하기
		
		// 문자열 입력받아서 문자열 한 글자씩 출력하기
//		String str = sc.nextLine();
//		for(int i=0; i<str.length(); i++) {
//			System.out.println(str.charAt(i));
//		}
		
		// 문자열 입력받아서 문자열 첫글자 대문자로 변경하기
//		String str = sc.nextLine();
//		String str2 = str.toUpperCase().charAt(0) + "";
//		for(int i=1; i<str.length(); i++) {
//			str2 += str.charAt(i);
//		}
//		System.out.println(str2);
		
		// 오버라이딩, 오버로딩에 대한 문제
		// 상속 관계에 있는 클래스 2개를 제공해주고 오버라이딩된 메소드 출력시 어떤 결과가 출력되냐?
//		객체의 실제 타입이 아니라 메소드를 호출하는 참조 변수의 타입에 따라 오버라이딩된 메소드가 호출된다.

		// 클래스 하나 주어진 상태에서 해당 클래스를 상속받는 새로운 클래스를 만들고 다음과 같은 결과가 되도록 오버라이딩을 해라
		
		// 똑같은 이름의 메소드 한 10개 제공해주고 에러가 발생하는 이유를 기술해라
//		메소드 오버로딩시에 매개변수의 타입, 개수, 순서를 다르게 정의하지 않으면 어떠한 메소드를 호출할지 모호해지기 때문이다.
		
		// void sample(int n); -> sample(3); sample(5, 7.0); 해당 코드가 문제가 되지 않도록 코드를 수정해라
//		void sample(int n);	void sample(int n, double m);
		
		// 배열 -> 길이가 정해져있는 것 -> 배열의 범위를 초과하는 코드 조심
		// 배열을 제공하고 모든 객체를 출력해라
		
		// 다형성 -> 다운캐스팅 조심
		
		// Human을 담을 수 있는 ArrayList 1개를 생성하고 임의로 Human객체 5개를 생성해서 담아라
		// 단, 해당 List에는 Human객체만 담을 수 있게 구성하세요.		
//		 ArrayList<Human> arr = new ArrayList<>();
//		 arr.add(new Human("최지원"))
//		 arr.add("김수민")
		
		// 파일에 내용 작성하기, 파일로부터 내용 가져오기
		// 파일에 객체정보 저장하기(직렬화), 파일로부터 객체정보 가져오기(역직렬화)
		
		// udp또는 tcp에서 클라이언트, 서버 구성하기
		
	}

}
