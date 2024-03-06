package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.vo.Client;
import com.kh.model.vo.Hospital;
import com.kh.service.HospitalService;
import com.kh.view.HospitalMenu;

public class HospitalController {
	
	public void insertClient(String clId, String clPw, int clGrade) {
		Client c = new Client(clId, clPw, clGrade);
		
		int result = new HospitalService().insertClient(c);
		
		if (result > 0) {
			new HospitalMenu().displaySuccess("성공적으로 회원이 추가되었습니다.");
		}
		else {
			new HospitalMenu().displayFail("회원추가를 실패하였습니다.");
		}
	}
	
	public Client searchClient(String clId, String clPw) {
		Client c = new HospitalService().searchClient(clId, clPw);
		if (c != null) {
			System.out.println("로그인된 아이디 : " + c.getClId());
		}

		return c;
	}
	
	public void selectList() {
		ArrayList<Hospital> list = new HospitalService().selectList();
		
		if(list.isEmpty()) {
			new HospitalMenu().displayNoHospital("병원 조회 결과가 없습니다.");
		}
		else {
			new HospitalMenu().displayHospitalList(list);
		}
	}
	
	public void updateVaccine(int hosNo, int vaccine_amount) {
		Hospital h = new Hospital();
		h.setHosNo(hosNo);
		h.setVaccine_amount(vaccine_amount);
		
		int result = new HospitalService().updateVaccine(h);
		
		if (result > 0) {
			new HospitalMenu().displaySuccess("성공적으로 백신 정보가 변경되었습니다.");
		}
		else {
			new HospitalMenu().displayFail("백신 정보 변경에 실패하였습니다.");
		}
	}

	public void insertHospital(String hosName, String hosPhone, String address, int vaccine_amount) {
		Hospital h = new Hospital(hosName, hosPhone, address, vaccine_amount);
		
		int result = new HospitalService().insertHospital(h);
		
		if (result > 0) {
			new HospitalMenu().displaySuccess("성공적으로 병원 정보가 추가되었습니다.");
		}
		else {
			new HospitalMenu().displayFail("병원 정보 추가에 실패했습니다.");
		}
	}

	public void deleteHospital(String inputHospitalName) {
		int result = new HospitalService().deleteHospital(inputHospitalName);
		
		if (result > 0) {
			new HospitalMenu().displaySuccess("성공적으로 병원이 삭제되었습니다.");
		}
		else {
			new HospitalMenu().displayFail("병원 삭제에 실패했습니다.");
		}
	}
	
}
