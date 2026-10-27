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
 * Servlet implementation class GetServelet
 */
@WebServlet("/get")
public class GetServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw =response.getWriter();
		pw.println("<html><body bgcolor = yellow text =blue>");
		pw.println("<h1><u>Selected Books</u></h1>");
		Cookie[]  c =request.getCookies();
		for(Cookie c2 :c) {
			String s =c2.getValue();
			pw.println(s+"<br>");
		}
		pw.println("</body></html>");
	}

}
