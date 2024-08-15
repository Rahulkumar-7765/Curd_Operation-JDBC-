package org.jsp.InsertPreApp;

import java.sql.*;

public class InsertPreDemo 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="insert into btm.student values(?,?,?)";//DML
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt=con.prepareStatement(qry);//compilation--------1
			// set the data for Place Holder
			pstmt.setInt(1, 104);
			pstmt.setString(2, "Rahul");
			pstmt.setDouble(3, 75.5);
			// Execute the Query
			pstmt.executeUpdate();//Execution---1
			
			pstmt.setInt(1, 105);
			pstmt.setString(2, "Suraj");
			pstmt.setDouble(3, 70.5);
			// Execute the Query
			pstmt.executeUpdate();//Execution---2
			
			pstmt.setInt(1, 106);
			pstmt.setString(2, "Golu");
			pstmt.setDouble(3, 73.5);
			// Execute the Query
			pstmt.executeUpdate();//Execution--------3
			
			System.out.println("Record Inserted!!!");
			
			System.out.println("Load and Register the Driver");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		finally {
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
