package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Client;
import com.kh.model.vo.Hospital;

public class HospitalDao {
	
	private Properties prop = new Properties();
	
	public HospitalDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertClient(Connection conn, Client c) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertClient");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, c.getClId());
			pstmt.setString(2, c.getClPw());
			pstmt.setInt(3, c.getClGrade());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public Client searchClient(Connection conn, String clId, String clPw) {
		Client c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchClient");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, clId);
			pstmt.setString(2, clPw);
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				c = new Client();
				c.setClNo(rset.getInt("clno"));
				c.setClId(rset.getString("clid"));
				c.setClPw(rset.getString("clpw"));
				c.setClGrade(rset.getInt("clgrade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return c;
	}
	
	public ArrayList<Hospital> selectList(Connection conn) {
		ArrayList<Hospital> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Hospital h = new Hospital();
				
				h.setHosNo(rset.getInt("hosno"));
				h.setHosName(rset.getString("hosname"));
				h.setHosPhone(rset.getString("hosphone"));
				h.setAddress(rset.getString("address"));
				h.setVaccine_amount(rset.getInt("vaccine_amount"));
				
				list.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
	public int updateVaccine(Connection conn, Hospital h) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateVaccine");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, h.getVaccine_amount());
			pstmt.setInt(2, h.getHosNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int insertHospital(Connection conn, Hospital h) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertHospital");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, h.getHosName());
			pstmt.setString(2, h.getHosPhone());
			pstmt.setString(3, h.getAddress());
			pstmt.setInt(4, h.getVaccine_amount());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int deleteHospital(Connection conn, String inputHospitalName) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteHospital");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  inputHospitalName);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
}
