package com.qunt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qunt.model.Car;

public class viewCustomers extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
	Car c = new Car();
	ArrayList<Car> carDetails = c.viewCustomers();
	HttpSession session = req.getSession();
	session.setAttribute("scarDetails", carDetails);
	if(carDetails==null) {
		resp.sendRedirect("/Car-Service-System/viewCarsFailure.jsp");
	}
	else {
		resp.sendRedirect("/Car-Service-System/viewCarsSuccess.jsp");
	}
	};
	}