package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lti.model.Employee;

public class EmployeeDao {

	String user = "hr";
	String pass = "hr";
	
	public Employee showEmp(int empno) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		Employee employee = new Employee();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",user,pass);
			String query = "select * from emp where empno=?";
			
			statement = connection.prepareStatement(query);
			statement.setInt(1, empno);
			result = statement.executeQuery();
			result.next();
			
			employee.setEmpno(result.getInt(1));
			employee.setEname(result.getString(2));
			employee.setJob(result.getString(3));
			employee.setMgr(result.getInt(4));
			employee.setHiredate(result.getDate(5).toString());
			employee.setSal(result.getDouble(6));
			employee.setComm(result.getDouble(7));
			employee.setDeptno(result.getInt(8));
			
			return employee;
			
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			try { connection.close(); } catch(Exception e) { }
		}
		return employee;
	}
}
