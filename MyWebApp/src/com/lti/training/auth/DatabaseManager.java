package com.lti.training.auth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DatabaseManager {
	
	String user = "system";
	String pass = "admin";
	
	public boolean isValidUser (String username, String password) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",user,pass);
			/*
			 * Use this comman to create the table.
			 * create table table_user_login (name varchar2(20), password varchar2(20),
			 * active varchar2(5));
			 * insert into table_user_login values ('Saurav','password','true');
			 * insert into table_user_login values ('Shreyansh','password','false');
			 * insert into table_user_login values ('Sriya','password','true');
			 * Use the above queires to populate the table.
			 */
			String query = "select count(*) from table_user_login where name = ? and password = ? and active ='true'";
			statement = connection.prepareStatement(query);
			
			statement.setString(1, username);
			statement.setString(2, password);
			resultset = statement.executeQuery();
			resultset.next();
			int rowCount = resultset.getInt(1);
			if(rowCount == 1)
				return true;
			else
				return false;
		}
		catch (ClassNotFoundException e) {
			System.out.println("JDBC driver not found");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			}
			catch (Exception e) {
			}
		}
		return false;
	}

	public void registerUser(String name, String email, String city, String username, String password) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",user,pass);
			String query = "insert into table_user values (?,?,?,?,?)";
			/*
			 * Use this code to create the table in DBMS
			 * create table table_user ( name varchar2(20), email varchar2(20), city
			 * varchar2(20), username varchar2(20), password varchar2(20));
			 */
			statement = connection.prepareStatement(query);
			statement.setString(1,name );
			statement.setString(2, email);
			statement.setString(3, city);
			statement.setString(4, username);
			statement.setString(5, password);
			statement.executeUpdate();
			System.out.println("Record Inserted Successfully!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void dispAll() {
		
	}
}
