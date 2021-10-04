package controller;

import java.util.Map;

import dao.MemberDAO;
import dao.MemberDAOImpl_ex;
import dto.Member_ex;
@Component("/lecture/members/delete.do")
public class MemberDeleteController implements Controller, DataBinding{
	private MemberDAO memberDAO;

	public MemberDeleteController setMemberDao(MemberDAO memberDao) {
	    this.memberDAO = memberDao;
	    return this;
	}

	@Override
	public String execute(Map<String,Object> model) throws Exception{
		
		memberDAO.delete(Integer.parseInt(model.get("no").toString()));
		return "redirect:list.do";
		
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"no", Integer.class
			};
	}
}
