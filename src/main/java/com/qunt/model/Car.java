package com.qunt.model;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Car {
	private static final String ServiceRequest = null;
	private String username;
private String carmodel;
private String cartype;
private String carregisternumber;
private  String servicerequest;
private  String servicestatus;
Connection con;
private String carregistrationnumber;



public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getCarmodel() {
	return carmodel;
}

public void setCarmodel(String carmodel) {
	this.carmodel = carmodel;
}

public String getCartype() {
	return cartype;
}

public void setCartype(String cartype) {
	this.cartype = cartype;
}

public String getCarregisternumber() {
	return carregisternumber;
}

public void setCarregisternumber(String carregisternumber) {
	this.carregisternumber = carregisternumber;
}

public String getServicerequest() {
	return servicerequest;
}

public void setServicerequest(String servicerequest) {
	this.servicerequest = servicerequest;
}

public String getServicestatus() {
	return servicestatus;
}

public void setServicestatus(String servicestatus) {
	this.servicestatus = servicestatus;
}

public Car() {
	super();
}

@Override
public String toString() {
	return "Car [username=" + username + ", carmodel=" + carmodel + ", cartype=" + cartype + ", carregisternumber="
			+ carregisternumber + ", servicerequest=" + servicerequest + ", servicestatus=" + servicestatus + "]";
}

public Car(String username, String carmodel, String cartype, String carregisternumber, String servicerequest,
		String servicestatus) {
	super();
	this.username = username;
	this.carmodel = carmodel;
	this.cartype = cartype;
	this.carregisternumber = carregisternumber;
	this.servicerequest = servicerequest;
	this.servicestatus = servicestatus;
}
{
	try {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_serice_system", "root", "Root");
	} catch (Exception e) {
		e.printStackTrace();
	}

}
public int customerDetails() {
	try {
		String s = "insert into car values(?,?,?,?,?,?)";
		PreparedStatement pstm = con.prepareStatement(s);
		pstm.setString(1, username);
		pstm.setString(2, carmodel);
		pstm.setString(3, cartype);
		pstm.setString(4, carregisternumber);
		pstm.setString(5, "NA");
		pstm.setString(6, "NA");
		
		int rows = pstm.executeUpdate();
		return rows;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return 0;

}
public int ServiceRequest() {
	try {
		String s = "update car set servicerequest=?, servicestatus=? where username=? and carregistrartionnumber=?";
		PreparedStatement pstmt = con.prepareStatement(s);
		pstmt.setString(1, ServiceRequest);
		pstmt.setString(2, "pending");
		pstmt.setString(3, username);
		pstmt.setString(4, carregisternumber);
		int rows=pstmt.executeUpdate();
		return rows;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
	
}
public String ServiceStatus() {
	
	try {
		String s = "select * from car where carregistrartionnumber=? and username=?";
		PreparedStatement pstmt = con.prepareStatement(s);
		pstmt.setString(1, carregisternumber);
		pstmt.setString(2, username);
		ResultSet res = pstmt.executeQuery();
		if(res.next()) {
			servicestatus = res.getString(6);
			return servicestatus;
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	return null;
}
public int EditCarDetails() {
	try {
		String s = "UPDATE car SET carmodel = ?, cartype = ?, carregistrartionnumber = ? WHERE username = ?";
		PreparedStatement pstm = con.prepareStatement(s);
		pstm.setString(1, carmodel);
		pstm.setString(2, cartype);
		pstm.setString(3, carregisternumber);
		pstm.setString(4, username);
		
		int rows = pstm.executeUpdate();
		return rows;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return 0;

}

public ArrayList<Car> viewCustomers() {
	 try {
		 String s = "select * from car";
		PreparedStatement pstmt = con.prepareStatement(s);
		ResultSet res = pstmt.executeQuery();
		ArrayList<Car> carDetails = new ArrayList<>();
		while(res.next() ) {
			username = res.getString(1);
			carmodel = res.getString(2);
			cartype = res.getString(3);
			carregistrationnumber = res.getString(4);
			servicerequest = res.getString(5);
			servicestatus = res.getString(6);
			
			carDetails.add(new Car(username, carmodel, cartype, carregistrationnumber, servicerequest, servicestatus));
			
		}
		return carDetails;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return null;
}
}