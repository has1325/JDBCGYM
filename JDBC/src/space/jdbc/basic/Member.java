package space.jdbc.basic;

public class Member {

	private long id;
	private long password;
	private String email;
	
	public Member() {}
	
	public Member(long id, long password, String email) {
		this.id = id;
		this.password = password;
		this.email = email;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPassword() {
		return password;
	}
	public void setPassword(long password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MemberMemo [id=" + id + ", password=" + password + ", email=" + email + ", getId()=" + getId()
				+ ", getPassword()=" + getPassword() + ", getEmail()=" + getEmail() + "]";
	}
	
	

}
