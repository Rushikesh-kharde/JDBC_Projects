 package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
	static Connection con;
	public static Connection createC() {
		try {
			// Load JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Create the connection
			String user="root";
 			String password="root";
			String url="jdbc:mysql://localhost:3306/studentdb";
			con=DriverManager.getConnection(url, user, password);
			System.setProperty("useSSL", "false");
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			
//			//Class.forName("com.mysql.jdbc.driver");
//			
//			//Create the connection
//			String user="root";
//			String password="root";
//			String url="jdbc:mysql//localhost:3306/studentdb";
//			con=DriverManager.getConnection(url, user, password);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		return con;
	}

}
