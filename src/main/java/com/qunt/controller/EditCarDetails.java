package com.qunt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qunt.model.Car;


public class EditCarDetails extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		String carmodel=req.getParameter("carmodel");
		String cartype=req.getParameter("cartype");
		String	carregisternumber=req.getParameter("carregisternumber");
		HttpSession session;  
		 session = req.getSession(true);
		 
		 String username =(String)session.getAttribute("username");
		 Car c=new Car();
		 c.setUsername(username);
		c.setCarmodel(carmodel);
		 c.setCartype(cartype);
		 c.setCarregisternumber(carregisternumber);
		 int statuss=c.customerDetails();
		 if(statuss==0) {
				resp.sendRedirect("/Car-Service-System/CarDetailsfailure.jsp");
 
		 }
		 else {
				resp.sendRedirect("/Car-Service-System/CarDetailsSuccess.jsp");

		 }
	

	
		};
	}