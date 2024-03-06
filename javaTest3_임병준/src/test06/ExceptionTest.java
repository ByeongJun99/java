package test06;

import java.util.Scanner;

public class ExceptionTest {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		double res = (new Calculator()).getSum(input);
		if (res != 0) {
			System.out.print("결과값 : ");
			System.out.println(res);	
		}
		else {
			System.out.println(new InvalidException("입력 값에 오류가 있습니다."));
		}
		
	}

}
