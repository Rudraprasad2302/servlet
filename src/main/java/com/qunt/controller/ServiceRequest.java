package com.qunt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qunt.model.Car;


public class ServiceRequest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ServiceRequest = req.getParameter("ServiceRequest");
		String carregistrationnumber  = req.getParameter("carregistrationnumber");
		Car c = new Car();
		HttpSession session = req.getSession();
		String username = (String)session.getAttribute("username");
		
		c.setServicerequest(ServiceRequest);
		c.setCarregisternumber(carregistrationnumber);
		c.setUsername(username);
		int status = c.ServiceRequest();
		if(status == 0) {
			resp.sendRedirect("/Car-Service-System/ServiceRequestFailure.jsp");
			}
		else {
			resp.sendRedirect("/Car-Service-System/ServiceRequestSuccess.jsp");
		}
		}
		
	}
