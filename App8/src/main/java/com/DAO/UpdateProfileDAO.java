package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.UserBean;

public class UpdateProfileDAO {
	
	public int updateprofile(UserBean ub) {
		int rowCount = 0;
		
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement pstmt = con.prepareStatement("update registration set FIRSTNAME=?,LASTNAME=?,MAILID=? , PHONE =? where USERNAME =?");
			pstmt.setString(1, ub.getFname());
			pstmt.setString(2, ub.getLname());
			pstmt.setString(3, ub.getMailid());
			pstmt.setString(4, ub.getPhone());
			pstmt.setString(5, ub.getUname());
			
		rowCount= pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowCount;
		
			}

}
