package org.jsp.deleteApp;

import java.sql.*;


	public class Deletedemo 
	{
		public static void main(String[] args) {
		
			Connection con=null;
			Statement stmt=null;
			String qry="Delete from btm.student where name='Rocky' ";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
				stmt=con.createStatement();
				stmt.executeUpdate(qry); 
				System.out.println("Record Deleted");
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


