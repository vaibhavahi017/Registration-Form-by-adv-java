package login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginServelet
 */
@WebServlet("/login")
public class LoginServelet extends HttpServlet {
	Connection con;
	private static final long serialVersionUID = 1L;
       
        public LoginServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","VAIBHAV09","VAIBHAV09");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String s1 = request.getParameter("uname");
			String s2 = request.getParameter("pword");
			PreparedStatement pstmt =con.prepareStatement("select * from userinfo where uname=? and pword=?");
			pstmt.setString(1, s1);
			pstmt.setString(2, s2);
			ResultSet rs=pstmt.executeQuery();
			PrintWriter pw =response.getWriter();
			
			pw.println("<html><body bgcolor = red text = yellow><h1>");
			if(rs.next()) {
				Cookie c1 = new Cookie("uname", s1);
				Cookie c2 = new Cookie("pword", s2);
				response.addCookie(c1);
				response.addCookie(c2);
						
				response.sendRedirect("welcome");
			}
			else {
				pw.println("invalid username /password");
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
			pw.println("</h1></body></html>");
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
