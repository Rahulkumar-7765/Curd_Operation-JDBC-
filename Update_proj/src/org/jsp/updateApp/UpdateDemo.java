package org.jsp.updateApp;
import java.sql.*;

public class UpdateDemo 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		String qry="Update btm.student set name='Rocky' where id = 102";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			stmt=con.createStatement();
			stmt.executeUpdate(qry); 
			System.out.println("Record Updated");
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
