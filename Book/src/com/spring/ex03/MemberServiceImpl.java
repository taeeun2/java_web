package com.spring.ex03;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memberDAO) {
		System.out.println("set MemberDAO");
		this.memberDAO = memberDAO;
	}

	@Override
	public void listMembers() {
		System.out.println("memberDAO.listMembers()");
		memberDAO.listMembers();
	}
}
