package cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SetCokie
 */
@WebServlet("/set")
public class SetCokie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetCokie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s1 =request.getParameter("book1");
		String s2 = request.getParameter("book2");
		String s3 = request.getParameter("book3");
		
		//if the s1 is not equal to null then create a cookie suppose it not null then book send to the client server
		if(s1!=null) {
			Cookie c1 = new Cookie("book1", s1); //name of the cookie,parameter of the cookie
		 	response.addCookie(c1);
		}
		if(s2!=null) {
			Cookie c2 =new Cookie("book2", s2);
			response.addCookie(c2);
		}
		if(s3!=null) {
			Cookie c3 = new Cookie("book3", s3);
			response.addCookie(c3);
		}
		PrintWriter pw =response.getWriter();
		pw.println("<html><body bgcolor=chyan text=red<center>");
		pw.println("<h1>Your Books Are Added To Cart</h1>");
		pw.println("<a href=get>Next</a>");
		pw.println("</center></body></html>");
		
	}

}
