package ch01.sec08;

public class SmartTelevision implements RemoteControl, Searchable {
	
	public void turnOn() {
		System.out.println("TV를 켭니다.");
		
	}

	public void turnOff() {
		System.out.println("TV를 끕니다.");
		
	}
	
	public void search(String url) {
		System.out.println(url + "을 검색합니다.");
		
	}
	
}
