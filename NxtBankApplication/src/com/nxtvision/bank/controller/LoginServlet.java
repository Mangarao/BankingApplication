package com.nxtvision.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nxtvision.bank.model.Account;
import com.nxtvision.bank.model.LoginBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		LoginBean loginBean = new LoginBean();
		loginBean.setUserId(userId);
		loginBean.setPassword(password);
		boolean status;
		try {
			status = loginBean.validateLogin();
			Account accountBean = new Account();
			Account accountDetails = accountBean.getAccountDetails(userId);
			if(status){
				
				HttpSession session = request.getSession();
				session.setAttribute("accountNo",accountDetails.getAccountNumber());
				session.setAttribute("fullName", accountDetails.getFirstName()+" "+accountDetails.getLastName());
				RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
				rd.forward(request,response);
			}
			PrintWriter out = response.getWriter();
			out.println("Invalid user or Password");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.include(request,response);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Unexpected exception is occurred");
			e.printStackTrace();
		}
		
		
		
	}

}
