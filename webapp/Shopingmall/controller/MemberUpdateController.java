package controller;

import java.util.Map;

import dao.MemberDAO;
import dto.Member_ex;
@Component("/lecture/members/update.do")
public class MemberUpdateController implements Controller, DataBinding{
	private MemberDAO memberDAO;

	public MemberUpdateController setMemberDao(MemberDAO memberDao) {
	    this.memberDAO = memberDao;
	    return this;
	}
	@Override
	public String execute(Map<String,Object> model) throws Exception{
		Member_ex member = (Member_ex)model.get("member");
		if(member!=null && member.getEmail()!=null) {
			memberDAO.update(member);
			return "redirect:list.do";
		}else {
			model.put("member", memberDAO.selectOne(Integer.parseInt(model.get("no").toString())));
			return "/lecture/members/MemberUpdate.jsp";
		}
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"member", dto.Member_ex.class,
				"no", Integer.class
			};
	}
}