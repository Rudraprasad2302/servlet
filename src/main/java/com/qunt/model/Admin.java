package com.qunt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Admin {
    private String adminusername;
    private String adminpassword;
    private Connection con;
	private String username;
	private String carmodel;
	private String cartype;
	private String carregistrationnumber;
	private String servicerequest;
	private String servicestatus;

    // Constructor
    public Admin() {
        super();
        initializeConnection(); // Initialize connection when the object is created
    }

    // Parameterized Constructor
    public Admin(String adminusername, String adminpassword) {
        super();
        this.adminusername = adminusername;
        this.adminpassword = adminpassword;
        initializeConnection(); // Initialize connection when the object is created
    }

    // Method to initialize the database connection
    private void initializeConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_serice_system", "root", "Root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Getters and Setters
    public String getAdminusername() {
        return adminusername;
    }

    public void setAdminusername(String adminusername) {
        this.adminusername = adminusername;
    }

    public String getAdminpassword() {
        return adminpassword;
    }

    public void setAdminpassword(String adminpassword) {
        this.adminpassword = adminpassword;
    }

    @Override
    public String toString() {
        return "Admin [adminusername=" + adminusername + ", adminpassword=" + adminpassword + "]";
    }

    // Admin login method
    public int adminLogin() {
        try {
            String s = "SELECT * FROM admin WHERE admin_user_name=?";
            PreparedStatement pstmt = con.prepareStatement(s);
            pstmt.setString(1, adminusername);

            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                if (adminpassword.equals(res.getString(2))) {
                    return 1; // Successful login
                }
            } else {
                return -1; // Username not found
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Login failed
    }
    
}