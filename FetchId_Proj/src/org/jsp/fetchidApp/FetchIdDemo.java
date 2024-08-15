package org.jsp.fetchidApp;
import java.sql.*;
import java.util.Scanner;

public class FetchIdDemo 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id ??");
		int sid=sc.nextInt();
		
		
		
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from btm.student where id=?";//DQL
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			// set the data for place holder
			pstmt.setInt(1, sid);
			// Execute
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String sname=rs.getString(2);
				Double sperc=rs.getDouble("perc");
				System.out.println("Student name is " + sname);
				System.out.println("Student perc is " + sperc);
			}
			else {
				System.out.println("Invalid id !! ");
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
