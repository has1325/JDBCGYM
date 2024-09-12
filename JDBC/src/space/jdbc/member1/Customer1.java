package space.jdbc.member1;

import java.sql.Timestamp;
import java.sql.Date;

public class Customer1 {
	
	private String id;
	private String password;
	private Date regdate;//가입일
	private Timestamp updatedate;//수정일시
	
	Customer1(){}
	
	public Customer1(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	
	public Customer1(String id, String password, Date regdate, Timestamp updatedate) {
		super();
		this.id = id;
		this.password = password;
		this.regdate = regdate;
		this.updatedate = updatedate;
	}

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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Timestamp getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", password=" + password + ", getId()=" + getId() + ", getPassword()="
				+ getPassword() + "]";
	}
	
	
}
