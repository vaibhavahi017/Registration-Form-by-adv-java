package com.pack03;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Provider.Service;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ap")
public class EmpServelet extends GenericServlet
{
 @Override
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	 PrintWriter pw = res.getWriter();
	 res.setContentType("text/html");
	  
	 String uname  = req.getParameter("ename");
	 String id  = req.getParameter("eid");
	 double sal = Double.parseDouble(req.getParameter("ename"));
	 int expe = Integer.parseInt(req.getParameter("exe"));
	 
	 if(expe>=5) {
		 sal =sal*0.1;
				 }
	 
}
	
	

}
