package com.nxtvision.bank.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nxtvision.bank.dao.ConnectionDAO;

public class LoginBean {
	private String userId;
	private String password;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validateLogin() throws ClassNotFoundException, SQLException{
		
		Connection conn = ConnectionDAO.getDBConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from login where userid=? and password=?");
		pstmt.setString(1, userId);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			return true;
		}
		return false;
		
		
	}
	
	

}
