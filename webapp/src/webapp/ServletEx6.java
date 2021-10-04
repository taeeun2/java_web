package webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEx6
 */
@WebServlet("/ServletEx6")
public class ServletEx6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEx6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operator = request.getParameter("op");
		int v1 = Integer.parseInt(request.getParameter("v1"));
		int v2 = Integer.parseInt(request.getParameter("v2"));
		int result = 0;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		switch(operator) {
			case"+": result = v1+v2;break;
			case"-": result = v1-v2;break;
			case"*": result = v1*v2;break;
			case"/":
				if(v2==0) {
					out.println("0으로 나눌 수 없습니다.");
					return;
				}
				result = v1/v2;break;
		}
		out.println(v1 + " "+operator+" "+v2+"="+result);
		out.close();
		
		//http://localhost:8080/webapp/ServletEx6?op=%2b&v1=30&v2=5
		//+ => %2b
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
