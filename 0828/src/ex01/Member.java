package ex01;

public class Member {
	private String id;
	private String pw;
	private BookList menulist;
	
	Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
		this.menulist = new BookList();
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}

	public BookList getmenulist() {
		return menulist;
	}

	public void setMenuList(BookList menuList, BookList menulist) {
		this.menulist = menulist;
	}
}

