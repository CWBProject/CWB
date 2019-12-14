package www.spring.com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import www.spring.com.party.mapper.MemberMapper;
import www.spring.com.party.model.MemberVO;
import www.spring.com.security.domain.CustomUser;

public class CustomUserDetailService implements UserDetailsService {

	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		System.out.println("load user by name: " + userName);
		
		MemberVO vo = memberMapper.read(userName);
		System.out.println("쿼리 매퍼: " + vo);
		
		return vo == null ? null : new CustomUser(vo);
	}

}
