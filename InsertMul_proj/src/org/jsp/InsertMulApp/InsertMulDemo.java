package org.jsp.InsertMulApp;

import java.sql.*;


public class InsertMulDemo 
{
	public static void main(String[] args) {
		
		Connection con=null;
		Statement stmt=null;
		String qry1="insert into btm.student values(104,'Rahul',78.43)";
		String qry2="insert into btm.student values(108,'Rocky',75.43)";
		String qry3="insert into btm.student values(109,'Suraj',73.43)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			stmt=con.createStatement();
			stmt.executeUpdate(qry1);
			stmt.executeUpdate(qry2);
			stmt.executeUpdate(qry3);
			
			System.out.println("Record Inserted");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(con!=null) {
					try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
