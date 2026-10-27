package com.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/view")
public class ViewProfileServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Cookie arr[] = req.getCookies();
		String fname = null;
		
		if(arr==null) {
			req.setAttribute("msg","Session Exprired");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
			
		}else {
			for(Cookie ck:arr) {
				if("fname".equals(ck.getName())) {
					fname=ck.getValue();
				}
			}
			req.setAttribute("fname", fname);
			req.getRequestDispatcher("ViewProfile.jsp").forward(req, res);
		}
	}

}