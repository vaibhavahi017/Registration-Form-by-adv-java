package com.pack2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/vs")
public class SecondServelet extends GenericServlet
{
 @Override
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	 PrintWriter pw = res.getWriter();
	 res.setContentType("text/html");
	 
	 String uname = req.getParameter("name");
	 String udob = req.getParameter("dob");
	 String arr[]=udob.split("-");
	 int age =2026-Integer.parseInt(arr[2]);
	 pw.println("<center><h1>");
	 if(age>=18) {
		 pw.println(uname+"You are are elligibe for vote");
	 }else {
		 pw.println(uname+"You are not elligible for vote");
	 }
}
}
