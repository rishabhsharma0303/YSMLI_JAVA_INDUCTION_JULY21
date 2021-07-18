package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class JdbcTxDemo {

	public static void main(String[] args) {
		
		Connection connection=null;
		try{
			 connection=ConnectionFactory.getConnection();
			 
			connection.setAutoCommit(false);
			
			PreparedStatement pstmt = connection.prepareStatement(
					"insert into customer(name, address, mobile, email, dob) values(?,?,?,?,?)");

			pstmt.setString(1, "leena");
			pstmt.setString(2, "delhi");
			pstmt.setString(3, "545454545");
			pstmt.setString(4, "leena@g.com");
			pstmt.setDate(5, new java.sql.Date(new Date().getTime()));
			pstmt.executeUpdate();
			
			connection.commit();
			System.out.println("rec is inserted...");
		}catch(SQLException ex) {
			ex.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		

		
	}
}
