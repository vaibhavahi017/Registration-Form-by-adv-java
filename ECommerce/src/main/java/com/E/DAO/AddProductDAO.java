package com.E.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.E.bean.ProductBean;

public class AddProductDAO {
	
	public int addproduct(ProductBean pb) {
		int rowCount =0;
		
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement pstmt =con.prepareStatement("insert into product values(?,?,?,?,?)");
			pstmt.setString(1, pb.getpCode());
			pstmt.setString(2, pb.getpName());
			pstmt.setString(3, pb.getpComp());
			pstmt.setString(4, pb.getpPrice());
			pstmt.setString(5, pb.getpQty());
			
			rowCount=pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return rowCount;
		
	}

}
