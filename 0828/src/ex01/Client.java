package ex01;

import java.util.Scanner;

public class Client {
	private Scanner scanner = new Scanner(System.in);
	private Memberlist memberList = new Memberlist();
	private Member loginMember;
	
	Client() {
		System.out.println();
	}
	
	public void connect() {
		while (true) {
			System.out.println("""
					
				
				                                 1. 로그인     2. 회원 가입     3. 종료
				
				""");
			
			try {
				int num = Integer.parseInt(scanner.nextLine());
				if (num == 1) {
					this.loginMember = memberList.login(scanner);
					if (this.loginMember == null)
						continue ;
					else
						this.selectFunc();
				}
				else if (num == 2)
					memberList.regist(scanner);
				else if (num == 3) {
					System.out.println("안녕히 가세요 ");
					scanner.close();
					return;
				}
				else
					throw new Exception();
			} catch (Exception e) {				
				System.out.println(" 1에서 3 중에서 입력해주세요.");
			}
		}	
	}
	
	public void selectFunc() {
		while (true) {
			System.out.println("""
					
				              1. 책 보기   2. 책 추가   3. 책 삭제   4. 가격 수정   5. 책 추천   6. 로그아웃
				
				""");
			
			try {
				int num = Integer.parseInt(scanner.nextLine());
				switch (num) {
				case 1 :
					this.read();
					break;
				case 2 :
					this.create();
					break;
				case 3 :
					this.delete();
					break;
				case 4 :
					this.update();
					break;
				case 5 :
					this.recommend();
					break;
				case 6 :
					System.out.println("로그아웃합니다.");
					return;
				default :
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("🚨 1에서 6 사이의 숫자를 입력해주세요.");
			}
		}
	}
	
	private void read() {
		while (true) {
			System.out.println("""
				
				                   1. 소설   2. it   3. 일본어   4. 중국어   5. 교과서   6. 돌아가기
				
				""");
			
			try {
				int category = Integer.parseInt(scanner.nextLine());
				if (category == 6)
					return;
				if (category < 1 || category > 5)
					throw new Exception();
				else
					loginMember.getmenulist().read(category);
			} catch (Exception e) {
				System.out.println(" 1에서 6 사이의 숫자를 입력해주세요.");
			}
		}
	}
	
	private void create() {
		while (true) {
			System.out.println("""
				
				                     1. 소설   2. it   3. 일본어   4. 중국어   5. 교과서   6. 돌아가기
				
				""");
			
			try {
				int category = Integer.parseInt(scanner.nextLine());
				if (category == 6)
					return;
				if (category < 1 || category > 5)
					throw new Exception();
				else {
					System.out.print("책 이름 입력 : ");
					String name = scanner.nextLine();
					while (true) {
						System.out.print("책 가격 입력 : ");
						try {
							int price = Integer.parseInt(scanner.nextLine());
							if (price < 0)
								throw new Exception();
							loginMember.getmenulist().create(category, name, price);
							break;
						} catch (Exception e) {
							System.out.println(" 올바른 값을 입력해주세요.");
						}
					}
				}
			} catch (Exception e) {
				System.out.println(" 1에서 6 사이의 숫자를 입력해주세요.");
			}
		}
	}
	
	private void delete() {
		while (true) {
			System.out.println("""
				
				                           1. 소설   2. it   3. 일본어   4. 중국어   5. 교과서   6. 돌아가기
				
				""");
			
			try {
				int category = Integer.parseInt(scanner.nextLine());
				if (category == 6)
					return;
				if (category < 1 || category > 5)
					throw new Exception();
				else {
					System.out.println("삭제할 책의 번호를 입력해주세요.");
					while (true) {
						loginMember.getmenulist().read(category);
						try {
							int num = Integer.parseInt(scanner.nextLine());
							if (loginMember.getmenulist().getCategorySize(category) < num || num <= 0)
								throw new Exception();
							loginMember.getmenulist().delete(category, num - 1);
							break;
						} catch (Exception e) {
							System.out.println("올바른 값을 입력해주세요.");
						}
					}
				}
			} catch (Exception e) {
				System.out.println("1에서 6 사이의 숫자를 입력해주세요.");
			}
		}
	}
	
	private void update() {
		while (true) {
			System.out.println("""
				
				                           1. 소설   2. it   3. 일본어   4. 중국어   5. 교과서   6. 돌아가기
				
				""");
			
			try {
				int category = Integer.parseInt(scanner.nextLine());
				if (category == 6)
					return;
				if (category < 1 || category > 5)
					throw new Exception();
				else {
					System.out.println("수정할 책의 번호를 입력해주세요.");
					while (true) {
						loginMember.getmenulist().read(category);
						try {
							int num = Integer.parseInt(scanner.nextLine());
							if (loginMember.getmenulist().getCategorySize(category) < num || num <= 0)
								throw new Exception();
							while (true) {
								System.out.print("수정할 가격 입력 : ");
								try {
									int price = Integer.parseInt(scanner.nextLine());
									if (price < 0)
										throw new Exception();
									loginMember.getmenulist().update(category, price, num - 1);
									break;
								} catch (Exception e) {
									System.out.println("올바른 값을 입력해주세요.");
								}
							}
							break;
						} catch (Exception e) {
							System.out.println("올바른 값을 입력해주세요.");
						}
					}
				}
			} catch (Exception e) {
				System.out.println("1에서 6 사이의 숫자를 입력해주세요.");
			}
		}
	}
	
	private void recommend() {
		while (true) {
			System.out.println("""
				
				                        1. 소설   2. it   3. 일본어   4. 중국어   5. 교과서   6. 돌아가기
				
				""");
			
			try {
				int category = Integer.parseInt(scanner.nextLine());
				if (category == 6)
					return;
				if (category < 1 || category > 5)
					throw new Exception();
				else
					loginMember.getmenulist().recommend(category);
			} catch (Exception e) {
				System.out.println("1에서 6 사이의 숫자를 입력해주세요.");
			}
		}
	}
}
