package com.qunt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
	private String name;
	private String username;
	private String password;
	private String email;
	Connection con = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", username=" + username + ", password=" + password + ", email=" + email
				+ "]";
	}

	public Customer(String name, String username, String password, String email) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Customer() {
		super();
	}

	{
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_serice_system", "root", "Root");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int customerReegister() {
		try {
			String s = "insert into customer values(?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(s);
			pstm.setString(1, name);
			pstm.setString(2, username);
			pstm.setString(3, password);
			pstm.setString(4, email);
			int rows = pstm.executeUpdate();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	public int customerLogin() {
		try {
			String s = "select* from customer where username=?";
			PreparedStatement pstm = con.prepareStatement(s);

			pstm.setString(1, username);

			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				if (password.equals(rs.getString(3))) {
					return 1;
				}

			} else {
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}

