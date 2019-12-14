package www.spring.com.party.model;

public class AuthVO {
	private String id;
	private String authority;
	
	public AuthVO() {}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	@Override
	public String toString() {
		return "AuthVO [id=" + id + ", authority=" + authority + "]";
	}
	
	
}
