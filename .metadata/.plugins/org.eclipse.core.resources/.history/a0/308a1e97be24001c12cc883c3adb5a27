package controller;

import java.util.Map;

import dao.MemberDAO;
import dao.MemberDAOImpl_ex;

public class MemberListController implements Controller{
	private MemberDAO memberDAO;

	public MemberListController setMemberDao(MemberDAO memberDao) {
	    this.memberDAO = memberDao;
	    return this;
	}

	@Override
	public String execute(Map<String,Object> model) throws Exception{
		model.put("members", new MemberDAOImpl_ex().selectList());
		return "/lecture/members/MemberList.jsp";
	}
}
