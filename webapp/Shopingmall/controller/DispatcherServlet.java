package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Listener.ApplicationContext;
import Listener.ContextLoaderListener;
import dto.Member_ex;
import util.ServletRequestDataBinder;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * 	- MVC �����ӿ�ũ �����
		������ MVC�� ����� ������ MVC �����ӿ�ũ ����� ����
		������ �����ӿ�ũ�� ���� ������ ���� ������ �����ϱ�
		������ ���� �����ϴ� ����� ���� �ҽ� ���̺귯���� ����ϴ� ����� �����ϱ�
		���÷��� API ���� ������
		�ֳ����̼��� �����ϰ� ����ϴ� ��� ������ 
		
		<<�н�����>>
			- ����Ʈ ��Ʈ�ѷ��� ���� 
			����Ʈ ��Ʈ�ѷ� ������ ����
			����Ʈ ��Ʈ�ѷ��� ���������� �����ڵ带 ó��
			���� �������� �������� ���� ��û ó���� ���
			Ŭ���̾�Ʈ�� ��û�� ���� ������ ������ ��Ʈ�ѷ� ����
			�� ���� �� ������ �̵� ����
			
			- ������ ��Ʈ�ѷ� ��ȭ (������ ��ü) <�׸� ��������Ʈ�� ����1> <�׸� ������ ��ü ����2>
			Controller �������̽�
			����Ʈ ��Ʈ�ѷ��� ������ ��Ʈ�ѷ� ������ ȣ�� ��Ģ
			������ ��Ʈ�ѷ��� �Ϲ� Ŭ����ȭ -> �� ��뼺 ����
			
			- DI�� �̿��� �� ������ ����
			1. ������ ����(DI : Dependency Injection)
			Ư�� �۾��� ������ �� ����ϴ� ��ü�� "���� ��ü" �� �θ�
			�̷� ���� ��ü�� �ܺο��� ������ -> ���յ��� ������ -> ��ü�� ����, ������ �������� 
			���� -> ���� ��ü�� ���� �ν��Ͻ� ������ ���� �޼��带 �غ�  
			2. ���� ��ü�� ����
			���� ��ü�� ������ ������ �� �����̳ʰ� ����
			ContextLoaderListener�� �� �����̳� ���� ����
			�������̽��� ���� ���� ��ü�� ���� ���յ� ����
			MemberDao�� �������̽� ����
     * 
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override    
    protected void service(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
    	resp.setContentType("text/html;charset=UTF-8");
    	String servletPath = req.getServletPath();
    	try {    		
    		ServletContext sc = this.getServletContext();    		
    		HashMap<String, Object> model = new HashMap<String, Object>();
    		model.put("session", req.getSession());
    		model.put("req", req);
//    		Controller pageController  = (Controller)sc.getAttribute(servletPath);
    		ApplicationContext ctx = ContextLoaderListener.getApplicationContext();
//    		if(ctx==null)
//    			System.out.println("ctx == null");
//    		
    		
    		System.out.println(servletPath);
    		Controller pageController  = (Controller)ctx.getBean(servletPath);
    		if(pageController == null) {
    			throw new Exception("��û�� ���񽺸� ã�� �� �����ϴ�.");
    		}
    		
    		
//    		
//    		if("/lecture/members/add.do".equals(servletPath)) {
//    			if(req.getParameter("email") != null) {
//    			model.put("member", new Member_ex().setEmail(req.getParameter("email"))
//    					.setName(req.getParameter("name")).setPassword(req.getParameter("password")));    			
//    		
//    			}
//    		}
//    		else if("/lecture/members/list.do".equals(servletPath)) {   
//    			model.put("member", new Member_ex().setEmail(req.getParameter("email"))
//    					.setName(req.getParameter("name")).setPassword(req.getParameter("password")));    			
//    		}
//    		
//    		else if("/lecture/members/update.do".equals(servletPath)) {   
//    			if(req.getParameter("email")!=null) {
//    				model.put("member", new Member_ex().setEmail(req.getParameter("email"))
//        					.setName(req.getParameter("name")).setPassword(req.getParameter("password"))
//        					.setNo(Integer.parseInt(req.getParameter("no"))));   			
//    			}else {
//    				model.put("no",req.getParameter("no"));
//    			}
//    		}
//    		else if("/lecture/members/delete.do".equals(servletPath)) {
//    			model.put("no", req.getParameter("no"));
//    		}
//    		else if("/lecture/auth/logout.do".equals(servletPath)) {
//    			
//    		}
//    		
    		
    		if(pageController instanceof DataBinding) {
    			prepareRequestData(req,model,(DataBinding)pageController);
    		}
    		
    		String viewUrl = pageController.execute(model);
    		for(String key : model.keySet()) {
    			req.setAttribute(key, model.get(key));    		
    		}
    		
    		//redirect�Ұ���,dispatcher�Ұ��� ��
    		if(viewUrl.startsWith("redirect:")) {
    			resp.sendRedirect(viewUrl.substring(9));
    			return;
    		}else {
    			RequestDispatcher rd = req.getRequestDispatcher(viewUrl);
    			rd.include(req, resp);
    		}    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private void prepareRequestData(HttpServletRequest request, HashMap<String, Object> model, DataBinding dataBinding)throws Exception{
		Object[] dataBinders = dataBinding.getDataBinders();
		for(int i=0;i<dataBinders.length;i+=2) {
			String dataName=(String)dataBinders[i];
			Class<?> dataType = (Class<?>)dataBinders[i+1];
			Object dataObj = ServletRequestDataBinder.bind(request, dataType, dataName);
			model.put(dataName, dataObj);
		}
	}
	

}