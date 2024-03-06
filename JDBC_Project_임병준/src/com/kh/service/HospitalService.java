package com.kh.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.HospitalDao;
import com.kh.model.vo.Client;
import com.kh.model.vo.Hospital;

public class HospitalService {
	public int insertClient(Client c) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new HospitalDao().insertClient(conn, c);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}
	
	public Client searchClient(String clId, String clPw) {
		Connection conn = JDBCTemplate.getConnection();
		Client c = new HospitalDao().searchClient(conn, clId, clPw);
		JDBCTemplate.close(conn);
		
		return c;
	}
	
	public ArrayList<Hospital> selectList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Hospital> list = new HospitalDao().selectList(conn);
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	public int updateVaccine(Hospital h) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new HospitalDao().updateVaccine(conn, h);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertHospital(Hospital h) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new HospitalDao().insertHospital(conn, h);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteHospital(String inputHospitalName) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new HospitalDao().deleteHospital(conn, inputHospitalName);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
}
