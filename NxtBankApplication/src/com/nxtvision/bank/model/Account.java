package com.nxtvision.bank.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nxtvision.bank.dao.ConnectionDAO;

public class Account {
	private int accountNumber;
	private String firstName;
	private String lastName;
	private double balance;
	private String userId;
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Account getAccountDetails(String userId) throws ClassNotFoundException, SQLException{
		Connection conn = ConnectionDAO.getDBConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from account where userid=?");
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		Account account = new Account();
		if(rs.next()){
			account.setAccountNumber(rs.getInt(1));
			account.setFirstName(rs.getString(2));
			account.setLastName(rs.getString(3));
			account.setBalance(rs.getDouble(4));
			account.setUserId(rs.getString(5));
		}
		
		return account;
		
	}
	
	
}
