package www.spring.com.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import www.spring.com.party.model.MemberVO;


public class CustomUser extends User{

	private static final long serialVersionUID = 1L;
	
	private MemberVO member;
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public MemberVO getMember() {
		return member;
	}


	public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
	
	
	public CustomUser(MemberVO vo) {
		super(vo.getId(), vo.getPassword(), 
				vo.getAuthList().stream().map(authority -> new SimpleGrantedAuthority(authority.getAuthority())).collect(Collectors.toList()));
		this.member = vo;
		
	}
	
}
