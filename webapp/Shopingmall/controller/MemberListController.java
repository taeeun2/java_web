package controller;

import java.util.Map;

import dao.MemberDAO;
import dao.MemberDAOImpl_ex;

@Component("/lecture/members/list.do")
public class MemberListController implements Controller, DataBinding{
	private MemberDAO memberDAO;

	public MemberListController setMemberDao(MemberDAO memberDao) {
	    this.memberDAO = memberDao;
	    return this;
	}

	@Override
	public String execute(Map<String,Object> model) throws Exception{
		System.out.println("MemberListController ½ÇÇà");
		model.put("members", new MemberDAOImpl_ex().selectList());
		return "/lecture/members/MemberList.jsp";
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
			"member", dto.Member_ex.class
		};
	}
}
