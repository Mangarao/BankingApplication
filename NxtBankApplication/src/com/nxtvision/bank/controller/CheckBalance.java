package com.nxtvision.bank.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nxtvision.bank.dao.ConnectionDAO;
import com.nxtvision.bank.model.Account;

/**
 * Servlet implementation class CheckBalance
 */
@WebServlet("/checkBalance")
public class CheckBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckBalance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn;
		try {
			conn = ConnectionDAO.getDBConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from account where account_Number=?");
			HttpSession session = request.getSession();
			Integer accountNumber = (Integer) session.getAttribute("accountNo");
			pstmt.setInt(1, accountNumber);
			ResultSet rs = pstmt.executeQuery();
			Account account = new Account();
			if(rs.next()){
				account.setAccountNumber(rs.getInt(1));
				account.setFirstName(rs.getString(2));
				account.setLastName(rs.getString(3));
				account.setBalance(rs.getDouble(4));
				account.setUserId(rs.getString(5));
			}
			request.setAttribute("account", account);
			RequestDispatcher rd = request.getRequestDispatcher("/checkBalance.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
