package com.E.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.E.bean.ProductBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/edit")
public class EditProductServlet  extends HttpServlet{
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)  throws ServletException,IOException{
		HttpSession session=req.getSession(false);
		if(session==null) {
			req.getRequestDispatcher("AdminLogin.html").forward(req, res);
			
		}else {
			String pCode =req.getParameter("pcode");
			ProductBean pb=null;
			ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("productList");
			Iterator<ProductBean> i =al.iterator();
			while(i.hasNext()) {
				pb=i.next();
				if(pCode.equals(pb.getpCode())) {
					break;
				}
			}
			req.setAttribute("productBean", pb);
			req.getRequestDispatcher("EditProduct.jsp").forward(req, res);

			
		}
		
	}
	

}
