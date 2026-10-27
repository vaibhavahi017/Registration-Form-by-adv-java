package session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class GetSession
 */
@WebServlet("/get")
public class GetSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw =response.getWriter();
		
		HttpSession hs = request.getSession();
		String s1 = (String) hs.getAttribute("book1");
		String s2 =(String) hs.getAttribute("book2");
		String s3 =(String) hs.getAttribute("book3");
		
		pw.println("<html><body bgcolor=green text = yellow>");
		pw.println("<h1>Selected Books</h1>");
		
		if(s1!=null) {
			pw.println(s1+"<br>");
		}
		if(s2!=null) {
			pw.println(s2+"<br>");
		}
		if(s3!=null) {
			pw.println(s3+"<br>");
		}
		
	}

}
