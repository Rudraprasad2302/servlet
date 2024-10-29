package com.qunt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qunt.model.Admin;
import com.qunt.model.Customer;


public class AdminLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String adminusername=req.getParameter("adminusername");
		String adminpassword=req.getParameter("adminpassword");
		Admin a=new Admin();
	a.setAdminusername(adminusername);
	a.setAdminpassword(adminpassword);
	int status=a.adminLogin();
	
	
	if(status==1) {
		
		resp.sendRedirect("/Car-Service-System/AdminLoginSuccess.jsp");
	}
	else if(status==-1) {resp.sendRedirect("/Car-Service-System/IncorrectAdminUsernameLogin.jsp");
}
	else {resp.sendRedirect("/Car-Service-System/IncorrectAdminPassword.jsp");
}
		


		
	}

}
