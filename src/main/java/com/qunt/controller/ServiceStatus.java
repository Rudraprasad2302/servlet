package com.qunt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qunt.model.Car;



public class ServiceStatus extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		String CarRegistrationNumber =req.getParameter("CarRegistrationNumber");
		
		Car c = new Car();
		c.setCarregisternumber(CarRegistrationNumber);
		
		HttpSession session = req.getSession();
		String username = (String)session.getAttribute("username");
		c.setUsername(username);
		String status = c.ServiceStatus();
		session.setAttribute("SStatus", status);
		if(status == null) {
			resp.sendRedirect("/Car-Service-System/ServiceStatusFailure.jsp");
		}
		else {
			resp.sendRedirect("/Car-Service-System/ServiceStatusSuccess.jsp");
		}
		
		
		};
	}