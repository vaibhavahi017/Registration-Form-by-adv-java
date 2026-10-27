package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/fs")
public class FirstServelet extends GenericServlet {
  
  @Override
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
	  
	  PrintWriter pw = res.getWriter();
	  res.setContentType("text/html");
	  String u_name = req.getParameter("uname");
	  String u_pwd = req.getParameter("upwd");

	  //System.out.println("UserName : "+u_name);
	  //System.out.println("Password :"+u_pwd);

	  pw.println("<center><h1>");
	  pw.println("********User Data********");
	  pw.println("UserName :"+u_name+"<br><br>");
	  pw.println("UserPassword :"+u_pwd.substring(0,1)+"*******"+u_pwd.substring(u_pwd.length()-1)+"<br><br>");

}
}
