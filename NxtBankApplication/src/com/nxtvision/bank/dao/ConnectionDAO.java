package com.nxtvision.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
	
	
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException{
		//1. load driver Class
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2. create connection Object
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		return con;
	}

}
