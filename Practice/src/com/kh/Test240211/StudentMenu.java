package com.kh.Test240211;

public class StudentMenu {
	private StudentController ssm = new StudentController();
	
	public StudentMenu() {
		System.out.println("========== 학생 정보 출력 ==========");
		for(int i=0; i<5; i++) {
			System.out.println(ssm.printStudent()[i].inform());
		}
		
		System.out.println("========== 학생 성적 출력 ==========");
		System.out.println("학생 점수 합계 : " + (int)(ssm.avgScore()[0]));
		System.out.println("학생 점수 평균 : " + ssm.avgScore()[1]);
		
		System.out.println("========== 성적 결과 출력 ==========");
		for(int i=0; i<5; i++) {
			System.out.println(ssm.printStudent()[i].getName() + "학생은 " + ((ssm.printStudent()[i].getScore() >= ssm.CUT_LINE) ? "통과" : "재시험 대상") + "입니다.");
		}
	}
}
