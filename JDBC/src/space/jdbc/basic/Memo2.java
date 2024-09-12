package space.jdbc.basic;

public class Memo2 {
	
	private long id;
	private String content;
	private long sal;
	
	public Memo2() {}
	
	public Memo2(long id, String content, long sal) {
		this.id = id;
		this.content = content;
		this.sal = sal;
	}
	
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

	@Override
	public String toString() {
		return "Memo [id=" + id + ", content=" + content + ", sal=" + sal + ", getId()=" + getId() + ", getContent()="
				+ getContent() + ", getSal()=" + getSal() + "]";
	}

	

	
	
	
}

