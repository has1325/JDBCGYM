package ex01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book implements Comparable<Book> {
	private String name;
	private int price;
	private int category;

	Book(int category, String name, int price) {
		this.category = category;
		this.name = name;
		this.price = price;
	}

	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCategory() {
		return category;
	}

	public String getStringCategory() {
		switch (category) {
			case 1:
				return "교과서";
			case 2:
				return "IT";
			case 3:
				return "소설";
			case 4:
				return "외국어";
			default:
				return "카테고리 없음";
		}
	}

	public void setCategory(int category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return " " + this.name + "  " + this.price;
	}

	// Comparable 인터페이스 구현
	@Override
	public int compareTo(Book other) {
		return this.name.compareTo(other.name);
	}

	public static void main(String[] args) {
		List<Book> bookList = new ArrayList<>();

		bookList.add(new Book(1, "Java Programming", 30000));
		bookList.add(new Book(3, "The Great Gatsby", 15000));
		bookList.add(new Book(2, "Introduction to Algorithms", 40000));
		bookList.add(new Book(4, "English Grammar in Use", 25000));

		// 리스트 정렬
		Collections.sort(bookList);

		// 정렬된 리스트 출력
		for (Book book : bookList) {
			System.out.println(book);
		}
	}
}
