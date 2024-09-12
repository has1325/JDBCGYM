package space.jdbc.basic;

public class Memo3 {
	
	private long id;
	private String content;
	private long sal;
	private String dept;
	
	public Memo3() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getSal() {
		return sal;
	}

	public void setSal(long sal) {
		this.sal = sal;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Memo3 [id=" + id + ", content=" + content + ", sal=" + sal + ", dept=" + dept + ", getId()=" + getId()
				+ ", getContent()=" + getContent() + ", getSal()=" + getSal() + ", getDept()=" + getDept() + "]";
	}
	
	
}
