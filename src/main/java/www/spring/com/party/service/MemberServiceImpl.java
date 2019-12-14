package www.spring.com.party.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.spring.com.party.mapper.MemberMapper;
import www.spring.com.party.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper memberMapper;

	public List<MemberVO> getAllMember() {
		List<MemberVO> listAllMember = memberMapper.getAllMember();
		return listAllMember;
	}

	public MemberVO getMember(String uid) {
		return memberMapper.getMember(uid);
	}
	
	public int insertMember(MemberVO memberVO) {
		return memberMapper.insertMember(memberVO);
	}
	
	public int updateMember(MemberVO memberVO) {
		return memberMapper.updateMember(memberVO);
	}
	
	public int deleteMember(String id) {
		return memberMapper.deleteMember(id);
	}
	
	public int deleteMemberByColl(List<String> listId) {
		return memberMapper.deleteMemberByColl(listId);
	}
}
