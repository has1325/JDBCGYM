package member;

public class Member {
	private int id;
	private int password;
	private String email;
	
	Member(){}
	
	Member(int id, int password, String email){
		this.id = id;
		this.password = password;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
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
		return "Member [id=" + id + ", password=" + password + ", email=" + email + ", getId()=" + getId()
				+ ", getPassword()=" + getPassword() + ", getEmail()=" + getEmail() + "]";
	}
	
	
}
