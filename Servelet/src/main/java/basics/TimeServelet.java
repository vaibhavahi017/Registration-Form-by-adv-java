package basics;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

/**
 * Servlet implementation class TimeServelet
 */
@WebServlet("/time")
public class TimeServelet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public TimeServelet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

    
    
	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LocalTime lt = LocalTime.now();
		PrintWriter pw =response.getWriter();
		pw.println(lt);
	}

}
