package ex01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class BookList {
   
   private List<Book> list = new ArrayList<>();
   
   BookList() {
		list.add(new Book(1, "일본어 기초", 8000));
		list.add(new Book(1, "중국어 기초", 15000));
		list.add(new Book(1, "영어 문법 기초", 12000));
		list.add(new Book(2, "일본어 중급", 18000));
		list.add(new Book(2, "중국어 중급", 8000));
		list.add(new Book(2, "영어 문법 중급", 17500));
		list.add(new Book(3, "프랑스어 기초", 7000));
		list.add(new Book(3, "독일어 기초", 13000));
		list.add(new Book(3, "스페인어 기초", 9000));
		list.add(new Book(4, "프랑스어 중급", 6000));
		list.add(new Book(4, "독일어 중급", 30000));
		list.add(new Book(4, "스페인어 중급", 20000));
   }
   
   public void sortBooksAscending1() {
	      Collections.sort(list);
	      System.out.println("책 리스트가 이름 순서로 오름차순 정렬되었습니다.");
	   }

	   // 내림차순 정렬 메서드
	   public void sortBooksDescending1() {
	      Collections.sort(list, Comparator.reverseOrder());
	      System.out.println("책 리스트가 이름 순서로 내림차순 정렬되었습니다.");
	   }

	   // 리스트를 출력하는 메서드
	   public void printList1() {
	      for (Book book : list) {
	         System.out.println(book);
	      }
	   }
   
   public static void main(String[] args) {
	      BookList bookList = new BookList();

	      // 오름차순 정렬
	      bookList.sortBooksAscending1();
	      bookList.printList1();

	      System.out.println();

	      // 내림차순 정렬
	      bookList.sortBooksDescending1();
	      bookList.printList1();
   }
   
   public void create(int category, String name, int price) {
	  List<Book> selectList = list.stream()
			   						.filter(menu -> menu.getName().equals(name)).toList();
	  
	  if (selectList.size() > 0) {
		  System.out.println("이미 존재하는 책입니다.");
		  return;
	  }
	  
	  Book newMenu = new Book(category, name, price);
      list.add(newMenu);
      System.out.println("추가 완료 [ " + newMenu + " ]");
   } 
   
   public void read(int category) {
	  if (category == 5) {
		  for (int i = 0; i < list.size(); i++)
			  System.out.println((i + 1) + ": " + list.get(i) + " " + list.get(i).getStringCategory());
	  } else {
		  AtomicInteger index = new AtomicInteger();
		  
		  list.stream()
		  .filter(menu -> menu.getCategory() == category)
		  .forEach(menu -> System.out.println((index.getAndIncrement() + 1) + ": " + menu));		  
	  }
   } 
   
   public void update(int category, int price, int menuNo) {      
      List<Book> selectList = list.stream()
						          	.filter(menu -> menu.getCategory() == category).toList();
      
      if (menuNo >= selectList.size() || menuNo < 0) {
    	  System.out.println("잘못된 책 번호입니다.");
    	  return;
      }
      
      Book selectMenu = selectList.get(menuNo);
      selectMenu.setPrice(price);
      System.out.println("수정 완료 [ " + selectMenu + " ]");
   }
   
   public void delete(int category, int menuNo) {
      List<Book> selectList = list.stream()
    		  						.filter(menu -> menu.getCategory() == category).toList();
      
      if (menuNo >= selectList.size() || menuNo < 0) {
    	  System.out.println("잘못된 책 번호입니다.");
    	  return;
      }
      
      list.remove(selectList.get(menuNo));
      System.out.println("삭제 완료");
   }
   
   public void recommend(int category) {
	   Random random = new Random();
	   
	   System.out.println("오늘 당신의 추천 책은...");
	   if (category == 5)
		   System.out.println(list.get(random.nextInt(list.size())));    
	   else {
		  List<Book> selectList = list.stream()
				  		              .filter( menu -> menu.getCategory() == category )
				  			          .toList();
		  
		  if (selectList.isEmpty()) {
			  System.out.println("추천할 책이 없습니다.");
			  return;
		  }
		  
		  System.out.println(selectList.get(random.nextInt(selectList.size())));
	  }
   }
   
   public long getCategorySize(int category) {
	   return list.stream()
				   .filter(menu -> menu.getCategory() == category)
				   .count();
   }
}
