package com.qunt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qunt.model.Customer;


public class CustomerLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
	Customer c=new Customer();
	c.setUsername(username);
	c.setPassword(password);
	 HttpSession session;  
	 session = req.getSession(true);
	 session.setAttribute("username", username);
	
	int status=c.customerLogin();
	if(status==1) {
		
		resp.sendRedirect("/Car-Service-System/CustomerLoginSuccess.jsp");
	}
	else if(status==-1) {resp.sendRedirect("/Car-Service-System/IncorrectCustomerUsernameLogin.jsp");
}
	else {resp.sendRedirect("/Car-Service-System/IncorrectCustomerPassword.jsp");
}
		


		
	}

}
