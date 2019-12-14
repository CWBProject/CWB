package www.spring.com.party.mapper;

import java.util.List;

import www.spring.com.party.model.MemberVO;

public interface MemberMapper {
	public MemberVO read(String userId);
	public int insertMember(MemberVO memberVO);
	public List<MemberVO> getAllMember();
	public MemberVO getMember(String id);
	public int updateMember(MemberVO member);
	public int deleteMember(String id);
	public List<MemberVO> getMemberTwoLatest();
	public int deleteMemberByColl(List<String> listId);
}
