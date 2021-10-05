package controller;

import java.util.Map;

import dao.MemberDAO;
import dto.Member_ex;

@Component("/lecture/members/add.do")
public class MemberAddController implements Controller, DataBinding{

	private MemberDAO memberDAO;

	public MemberAddController setMemberDao(MemberDAO memberDao) {
	    this.memberDAO = memberDao;
	    return this;
	}

	@Override
	public String execute(Map<String,Object> model) throws Exception{
		
		System.out.println("MemberAddController ½ÇÇà");
		Member_ex member = (Member_ex)model.get("member");
		if(member!=null) {
			memberDAO.insert(member);
			return "redirect:list.do";
		}else {
			return "/lecture/members/Memberform.jsp";
		}
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
			"member", dto.Member_ex.class
		};
	}
}
