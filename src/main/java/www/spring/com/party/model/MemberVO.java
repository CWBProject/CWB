package www.spring.com.party.model;

import java.util.Date;
import java.util.List;

public class MemberVO {
	private String id;
	private String password;
	private int height;
	private float grade;
	private String address;
	private String nickname;
	private String position;
	private String gender;
	private Date regdate;
	private Date updatedate;
	
	private List<AuthVO> authList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public List<AuthVO> getAuthList() {
		return authList;
	}

	public void setAuthList(List<AuthVO> authList) {
		this.authList = authList;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", height=" + height + ", grade=" + grade
				+ ", address=" + address + ", nickname=" + nickname + ", position=" + position + ", gender=" + gender
				+ ", regdate=" + regdate + ", updatedate=" + updatedate + ", authList=" + authList + "]";
	}
	
	
	
	
	
}
