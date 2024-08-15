package org.jsp.fetchnameApp;

import java.sql.*;

import java.util.Scanner;

public class FetchNameDemo
{
//	private static final String sname = null;

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name ??");
		String sname=sc.next();
		
		
		
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from btm.student where name=?";//DQL
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			// set the data for place holder
			pstmt.setString(1, sname);
			// Execute
			rs=pstmt.executeQuery();
			if(rs.next()) {
				Integer sid=rs.getInt(1);
				Double sperc=rs.getDouble("perc");
				System.out.println("Student id is " + sid);
				System.out.println("Student perc is " + sperc);
			}
			else {
				System.out.println("Invalid name !! ");
			}
			
			
			System.out.println("load and register the driver");
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
		}
		
	}

}
