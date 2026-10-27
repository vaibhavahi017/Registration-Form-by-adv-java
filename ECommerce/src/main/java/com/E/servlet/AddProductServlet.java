package com.E.servlet;

import java.io.IOException;

import com.E.DAO.AddProductDAO;
import com.E.bean.ProductBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/aps")
public class AddProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		HttpSession session = req.getSession(false);
		
		if(session==null) {
			req.getRequestDispatcher("AdminLogin.html").forward(req, res);
			
		}else {
			ProductBean pb = new ProductBean();
			pb.setpCode(req.getParameter("pCode"));
			pb.setpName(req.getParameter("pName"));
			pb.setpComp(req.getParameter("pComp"));
			pb.setpPrice(req.getParameter("pPrice"));
			pb.setpQty(req.getParameter("pQty"));
			
			
			int rowCount = new AddProductDAO().addproduct(pb);
			if(rowCount>0) {
				
				req.setAttribute("msg", "Product Data Inserted!!!");
				req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
				
			}else throw new RuntimeException("Product Not Inserted!!!");
		}
		
	}

}
