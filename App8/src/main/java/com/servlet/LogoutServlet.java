package com.servlet;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie arr[] =req.getCookies();
		String fname = null;
		if(arr==null) {
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("Register.jsp").forward(req, resp);
			
		}else {
			ServletContext context = req.getServletContext();
			context.removeAttribute("ubean");
			arr[0].setMaxAge(0);
			resp.addCookie(arr[0]);
			req.setAttribute("msg", "user Logout");
			req.getRequestDispatcher("Register.jsp").forward(req, resp);
		}
	}
	
	
	
}
