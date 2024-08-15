package org.jsp.loginvalidationApp;

import java.sql.*;
import java.util.Scanner;

public class LoginValidationDemo 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name???");
		String nm=sc.next();
		
		System.out.println("Enter password");
		String pw=sc.next();
		
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select username from btm.user where name=? and password=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			// set data for place holder
			pstmt.setString(1, nm);
			pstmt.setString(2, pw);
			// Execute
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String un=rs.getString(1);
				System.out.println("Welcome " + un);
			}
			else {
				System.out.println("Invalid Credentials");
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
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
