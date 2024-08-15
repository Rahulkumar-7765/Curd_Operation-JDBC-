package org.jsp.fetchApp;

import java.sql.*;

public class FetchDemo 
{
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from btm.student";//DQL
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int sid=rs.getInt("id");//101
				String sname=rs.getString("name");//Rahul
				Double sperc=rs.getDouble("perc");//75.50
				System.out.println("Student id is " + sid);
				System.out.println("Student name is " + sname);
				System.out.println("Student perc is " + sperc);
				System.out.println("----------------------------");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
					if(pstmt!=null) {
						try {
							pstmt.close();
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
				System.out.println("close all the costly Resources");
			}
		}
	}

}
