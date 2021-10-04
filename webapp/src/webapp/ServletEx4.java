package webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEx4
 */
/*
 * 요청객체(request)와 파라미터 관련 메소드
 * - 사용자가 폼에 입력한 값을 서블릿에서 어떻게 얻어오는지 살펴본다.
 * - request 객체의 getParamater()메소드를 호출하여 <input>태크를 통해 입력된 값을 읽어올 수 있다.
 * - 원하는 값을 얻기 위해서는 name 속성 값을 getParameter()의 매게변수로 기술합니다.
 * - 다음 예문 중 이름이 id에 실려 온 파라미터 값을 얻어와서 String 변수 id에 저장한 예입니다.
 * ex1)
 * 		String id = request.getParameter("id");
 * 		input 태그의 name 속성 값
 * 		<input type = "text" name = "id">
 * ex2 ) 
 * 		int age = Integer.parseInt(request.getParameter("age"));
 * 		<input type = "text" name = "age">
 * 
 *	- 공백이 서블릿에 전송되어 이를 정수형태로 변환하려고 하면 
 *	  numberformatException이 발생할 수 있음
 *
 * ex3) 
 * 		다중 값 처리 예)
 * 		String items[] = request.getParameter("item");
 * 	
 */


@WebServlet("/ServletEx4")
public class ServletEx4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEx4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String id = request.getParameter("id");
//		if(request.getParameter("age")!=null)
//			out.println("null");
		int age = Integer.parseInt(request.getParameter("age"));
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("ID : "+id + ", AGE : "+age);
		out.println("</body>");
		out.println("</html>");
		out.close();
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
