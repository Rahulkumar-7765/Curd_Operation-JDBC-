package org.jsp.insertApp;
import java.sql.*;

public class InsertDemo 
{
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String qry="insert into btm1.student1 values(101,'Rahul',78.45)";//DML
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class is loaded and register");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection Established with the database server !!");
			stmt=con.createStatement();
			System.out.println("Platform Created !!");
			stmt.executeUpdate(qry);
			System.out.println("Record Inserted !!");
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(stmt!=null) {
				try {
					stmt.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
			System.out.println("Closed all the costly resources !!");
		}
		
	}

}
