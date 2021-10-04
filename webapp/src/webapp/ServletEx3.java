package webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEx3
 */
@WebServlet("/ServletEx3")
public class ServletEx3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEx3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		

		out.println("<html>");
		out.println("<body>");
		out.println("<table border = '1'>");
		
		
		String dan = "2 ~ 9";
		out.println("</tr>");

		out.println("<html>");
		out.println("<body>");
		out.println("<table border = '1'>");
		//tr : row, td : column
		out.println("<tr><td colspan = '9'>´Ü : " +dan + "</td></tr>");
		for(int i=2;i<10;i++) {
			out.println("<tr>");
				for(int j=1;j<10;j++) {
					out.println("<td>" + j + " * "+i+"="+(j*i)+"</td>");
				}			
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
