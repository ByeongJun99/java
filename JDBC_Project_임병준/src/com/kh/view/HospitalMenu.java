package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.HospitalController;
import com.kh.model.vo.Client;
import com.kh.model.vo.Hospital;
import com.kh.service.HospitalService;

// View : 사용자가 보게될 시각적인 요소(화면) 출력및 입력
public class HospitalMenu {
	
	//Scanner객체 생성(전역으로 다 입력받을 수 있도록)
	private Scanner sc = new Scanner(System.in);

	//MemberController 객체생성(전역에서 바로 요청할 수 있도록)
	private HospitalController hc = new HospitalController();
	
	/*
	 * 사용자가 보개될 첫 화면(메인화면)
	 */
	public void mainMenu() {
		while(true) {
			System.out.println("==================백신 잔량확인 프로그램==================");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 입력 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				this.inputClient();
				break;
			case 2:
				this.signIn();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("메뉴를 잘못입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void inputClient() {
		System.out.println("==================회원가입 메뉴==================");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		System.out.print("회원등급을 설정하세요(1:관리자, 2:사용자) : ");
		int grade = sc.nextInt();
		sc.nextLine();
		
		hc.insertClient(id, pw, grade);
	}
	
	public void signIn() {
		System.out.println("==================로그인 메뉴==================");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		
		Client c = hc.searchClient(id, pw);
		
		if (c == null) {
			System.out.println("해당 아이디의 회원이 없습니다.");
		}
		else if (c.getClGrade() == 1) {	// 관리자 계정일 경우
			this.mngMenu();
		}
		else if (c.getClGrade() == 2) {	// 사용자 계정일 경우
			this.usrMenu();
		}
	}
	
	public void mngMenu() {
		while(true) {
			System.out.println("==================관리자 메뉴==================");
			System.out.println("1. 병원 목록 조회");
			System.out.println("2. 백신 현황 수정");
			System.out.println("3. 병원 목록 추가");
			System.out.println("4. 병원 삭제");
			System.out.println("0. 로그인 메뉴로 돌아가기");
			System.out.print("메뉴 입력 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				this.searchHospitalList();
				break;
			case 2:
				this.updateVaccine();
				break;
			case 3:
				this.insertHospital();
				break;
			case 4:
				hc.deleteHospital(this.deleteHospitalName());
				break;
			case 0:
				System.out.println("로그인 메뉴로 돌아갑니다.");
				return;
			default:
				System.out.println("메뉴를 잘못입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	public void usrMenu() {
		while(true) {
			System.out.println("==================사용자 메뉴==================");
			System.out.println("1. 병원목록 조회");
			System.out.println("2. 백신 접종 예약하기");
			System.out.println("0. 로그인 메뉴로 돌아가기");
			System.out.print("메뉴 입력 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				this.searchHospitalList();
				break;
			case 2:
				this.bookVaccine();
				break;
			case 0:
				System.out.println("로그인 메뉴로 돌아갑니다.");
				return;
			default:
				System.out.println("메뉴를 잘못입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	public void searchHospitalList() {
		hc.selectList();
	}
	
	public void updateVaccine() {
		System.out.println("==================병원 백신정보 변경 메뉴==================");
		this.searchHospitalList();
		System.out.print("변경할 병원의 번호 : ");
		int hosNo = sc.nextInt();
		sc.nextLine();
		
		System.out.print("변경할 백신의 수량 : ");
		int vaccine_amount = sc.nextInt();
		sc.nextLine();
		
		hc.updateVaccine(hosNo, vaccine_amount);
	}
	
	private void bookVaccine() {
		System.out.println("==================백신 예약하기==================");
		this.searchHospitalList();
		System.out.print("예약할 병원의 번호 : ");
		int hosNo = sc.nextInt();
		sc.nextLine();
		
		Hospital h = new HospitalService().selectList().get(hosNo-1);
		
		hc.updateVaccine(hosNo, h.getVaccine_amount() - 1);
	}
	
	private void insertHospital() {
		System.out.println("==================병원 정보 추가==================");
		
		System.out.print("추가 할 병원 이름 : ");
		String hosName = sc.nextLine();
		
		System.out.print("병원 전화번호 : ");
		String hosPhone = sc.nextLine();
		
		System.out.print("병원 주소 : ");
		String address = sc.nextLine();
		
		System.out.print("백신 잔량 : ");
		int vaccine_amount = sc.nextInt();
		sc.nextLine();
		
		hc.insertHospital(hosName, hosPhone, address, vaccine_amount);
	}
	
	private String deleteHospitalName() {
		System.out.println("==================병원 정보 삭제==================");
		
		this.searchHospitalList();
		System.out.print("삭제 할 병원 이름 : ");
		String hospitalName = sc.nextLine();
		return hospitalName;
	}
	
	//-------------------------------- 응답화면------------------------------------
	/**
	 * 서비스요청 처리 후 성공했을 경우 사용자가 보게될 응답화면
	 * @param : 객체별 성공메세지
	 */
	public void displaySuccess(String message) {
		System.out.println("\n서비스 요청 성공 : " + message);
	}
	
	/**
	 * 서비스요청 처리 후 실패했을 경우 사용자가 보게될 응답화면
	 * @param message: 객체별 실패메세지
	 */
	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패 : " + message);
	}
	
	/**
	 * 조회서비스 요청시 조회결과가 없을 떄 사용자가 보게될 응답화면
	 * @param message: 조회결과에 대한 응답메세지
	 */
	public void displayNoClient(String message) {
		System.out.println("\n" + message);
	}
	
	public void displayNoHospital(String message) {
		System.out.println("\n" + message);
	}
	
	/**
	 * 조회서비스 요청시 결과가 여러행일 경우 보게될 응답화면
	 * @param list: 조회결과
	 */
	public void displayHospitalList(ArrayList<Hospital> list) {
		//for loop
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).toString());
//		}
		
		//for each
		for(Hospital h : list) {
			System.out.println(h);
		}
	}
	
	public void displayClient(Client c) {
		System.out.println("\n조회된 데이터는 다음과 같습니다.");
		System.out.println(c);
	}
	
	
	
	
	
	
	
	
	
}
