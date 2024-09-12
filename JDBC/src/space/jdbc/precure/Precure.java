package space.jdbc.precure;

import java.sql.Date;

public class Precure {
	private int id;
	private String name;
	private int age;
	private String color;
	private String type;
	private Date birth;
	private String item;
	private String comments;
	
	Precure(){}
	
	public Precure(int id,String name,int age,String color,String type,Date birth,String item,String comments) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.color = color;
		this.type = type;
		this.birth = birth;
		this.item = item;
		this.comments = comments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Precure [id=" + id + ", name=" + name + ", age=" + age + ", color=" + color + ", type=" + type
				+ ", birth=" + birth + ", item=" + item + ", comments=" + comments + "]";
	}
	
}
