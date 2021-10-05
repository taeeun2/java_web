package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dao.MemberDAOImpl_ex;
import dto.Member_ex;

@Component("lecture/members/login.do")
public class LoginController implements Controller, DataBinding{
	private MemberDAO memberDAO;
	
	
	public LoginController setMemberDao(MemberDAO memberDao) {
		this.memberDAO = memberDao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		System.out.println("login_controller");
		Member_ex member = (Member_ex)model.get("member");
		
		if(member == null) {
			return "lecture/members/LogInForm.jsp";
		}else {						
//			Member_ex member = memberDao.exist(member.getEmail(), loginInfo.getPassword());
//			Member_ex member = new MemberDAOImpl_ex().exist(((HttpServletRequest)model.get("req")).getParameter("email"),
//					((HttpServletRequest)model.get("req")).getParameter("password"));
			if(member != null) {
				HttpSession session = (HttpSession)model.get("session");
				session.setAttribute("member", member);
				return "redirect:../members/list.do";	   		
			}else {
				return "/auth/LogInFail.jsp";
			}
		}
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"loginInfo",dto.Member_ex.class
		};
	}

}
