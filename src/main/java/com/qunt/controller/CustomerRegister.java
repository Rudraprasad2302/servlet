package com.qunt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qunt.model.Customer;

public class CustomerRegister extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String cpassword = req.getParameter("cpassword");
		String email = req.getParameter("email");

		if (password.equals(cpassword)) {
			Customer c = new Customer(name, username, password, email);
			int rows = c.customerReegister();
			if (rows == 0) {
				resp.sendRedirect("/Car-Service-System/CustomerRegisterFailure.jsp");
			} else {
				resp.sendRedirect("/Car-Service-System/CustomerRegisterSuccess.jsp");
			}
		} else {
			resp.sendRedirect("/Car-Service-System/PasswordMismatch.html");
		}

	}

}
