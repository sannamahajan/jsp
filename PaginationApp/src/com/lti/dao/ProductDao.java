package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.lti.model.Product;

public class ProductDao {

	public List<Product> fetchProducts (int from, int to){
		Connection conn= null;
		PreparedStatement stmt = null;	
		ResultSet rs=null ;			
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String user = "hr";
			String pass = "hr";
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",user,pass);                                              
			String sql = "SELECT T.* FROM ( SELECT T.*,rowNum as rowIndex FROM (SELECT * FROM table_product)T)T WHERE rowIndex > ? AND rowIndex <= ?;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt (1,  10);
			rs = stmt.executeQuery();      												
			List<Product> products = new ArrayList<Product>();
			while(rs.next()) {
				Product p=new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				p.setQuantity((rs.getInt(4)));
				products.add(p);
			}
			System.out.println("Balidaaan");
			return products;
		}
		catch(ClassNotFoundException e) {
			System.out.println("JDBC driver not found");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
		return null; // bad 
	}
}
