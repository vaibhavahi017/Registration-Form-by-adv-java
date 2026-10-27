package com.servlet;

import java.io.IOException;

import com.DAO.UserLoginDAO;
import com.bean.UserBean;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserBean ub = new UserLoginDAO().checkLogin(req.getParameter("uname"), req.getParameter("pwd"));
		if(ub == null) {
			req.setAttribute("msg", "Invalid Credentials");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
		}else {
			ServletContext context = req.getServletContext();
			context.setAttribute("ubean", ub);
			Cookie ck = new Cookie("fname", ub.getFname());
			res.addCookie(ck);
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
	}

}