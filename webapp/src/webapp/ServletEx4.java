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
 * ��û��ü(request)�� �Ķ���� ���� �޼ҵ�
 * - ����ڰ� ���� �Է��� ���� �������� ��� �������� ���캻��.
 * - request ��ü�� getParamater()�޼ҵ带 ȣ���Ͽ� <input>��ũ�� ���� �Էµ� ���� �о�� �� �ִ�.
 * - ���ϴ� ���� ��� ���ؼ��� name �Ӽ� ���� getParameter()�� �ŰԺ����� ����մϴ�.
 * - ���� ���� �� �̸��� id�� �Ƿ� �� �Ķ���� ���� ���ͼ� String ���� id�� ������ ���Դϴ�.
 * ex1)
 * 		String id = request.getParameter("id");
 * 		input �±��� name �Ӽ� ��
 * 		<input type = "text" name = "id">
 * ex2 ) 
 * 		int age = Integer.parseInt(request.getParameter("age"));
 * 		<input type = "text" name = "age">
 * 
 *	- ������ ������ ���۵Ǿ� �̸� �������·� ��ȯ�Ϸ��� �ϸ� 
 *	  numberformatException�� �߻��� �� ����
 *
 * ex3) 
 * 		���� �� ó�� ��)
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
