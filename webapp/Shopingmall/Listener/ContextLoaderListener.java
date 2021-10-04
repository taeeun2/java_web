package Listener;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import controller.LoginController;
import controller.MemberAddController;
import controller.MemberDeleteController;
import controller.MemberListController;
import controller.MemberUpdateController;
import dao.MemberDAOImpl_ex;

@WebListener
public class ContextLoaderListener implements ServletContextListener{
	static ApplicationContext applicationContext;
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		try {
			System.out.println("contextInitialized");
			ServletContext sc = event.getServletContext();			
//			InitialContext initialContext = new InitialContext();
//		    DataSource ds = (DataSource)initialContext.lookup("java:comp/env/jdbc/oracle");
//		    MemberDAOImpl_ex memberDao = new MemberDAOImpl_ex();
//			memberDao.setDataSource(ds);
//			sc.setAttribute("/lecture/auth/login.do",  new LoginController().setMemberDao(memberDao));
//			sc.setAttribute("/lecture/members/list.do", new MemberListController().setMemberDao(memberDao));
//			sc.setAttribute("/lecture/members/add.do", new MemberAddController().setMemberDao(memberDao));
//			sc.setAttribute("/lecture/members/update.do", new MemberUpdateController().setMemberDao(memberDao));
//			sc.setAttribute("/lecture/members/delete.do", new MemberDeleteController().setMemberDao(memberDao));
//			sc.setAttribute("/lecture/auth/logout.do", new MemberLogOutController());
			
			String propertiesPath = sc.getRealPath(sc.getInitParameter("contextConfigLocation"));
			applicationContext = new ApplicationContext(propertiesPath);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
