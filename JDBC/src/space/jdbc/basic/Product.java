package space.jdbc.basic;

public class Product {
	
	private long id;
	private String name;
	private long price;
	private String kind;
	
	public Product(){}
	
	public Product(long id, String name, long price, String kind) {
		this.id = id;
		this.kind = kind;
		this.name = name;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", kind=" + kind + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getPrice()=" + getPrice() + ", getKind()=" + getKind() + "]";
	}
	
	
}
