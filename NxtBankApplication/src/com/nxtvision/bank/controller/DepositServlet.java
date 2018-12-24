package com.nxtvision.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nxtvision.bank.dao.ConnectionDAO;

/**
 * Servlet implementation class DepositServlet
 */
@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositServlet() {
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
		String depositAmount = request.getParameter("depositAmount");
		HttpSession session = request.getSession();
		Integer accountNumber = (Integer) session.getAttribute("accountNo");
		try {
			Connection conn = ConnectionDAO.getDBConnection();
			PreparedStatement pstmt = conn.prepareStatement("update  account set balance=balance+? where account_number=?");
			pstmt.setDouble(1,Double.parseDouble(depositAmount));
			pstmt.setInt(2,accountNumber);
			pstmt.executeUpdate();
			
			PrintWriter out = response.getWriter();
			out.println(depositAmount+" is deposited successfully");
			RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
			rd.include(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
