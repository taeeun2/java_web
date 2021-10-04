package memberex;

import java.util.List;

import dto.Member_ex;

public interface MemberDAO_ex {
	List<Member_ex> selectList() throws Exception;
	int insert(Member_ex member) throws Exception;
	int delete(int no)throws Exception;
	Member_ex selectOne(int no) throws Exception;
	int update(Member_ex member)throws Exception;
	Member_ex exist(String email, String password)throws Exception;
}
