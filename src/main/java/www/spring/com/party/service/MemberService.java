package www.spring.com.party.service;

import java.util.List;

import www.spring.com.party.model.MemberVO;

public interface MemberService {
	public List<MemberVO> getAllMember();
	public MemberVO getMember(String uid);
	public int insertMember(MemberVO memberVO);
	public int updateMember(MemberVO memberVO);
	public int deleteMember(String uid);
	public int deleteMemberByColl(List<String> listId);
}
