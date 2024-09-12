package ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Memberlist {
	private List<Member> list = new ArrayList<Member>();
	
	public Member login(Scanner scanner) {		
		while (true) {
			System.out.print("아이디를 입력해주세요: ");
			String id = scanner.nextLine();
			
			List<Member> selectMember = list.stream().filter(member -> member.getId().equals(id)).toList();
			if (selectMember.size() == 0) {
				System.out.println("존재하지 않는 아이디입니다.");
				return null;
			}
			
			System.out.print("비밀번호를 입력해주세요: ");
			String pw = scanner.nextLine();
			
			if (!selectMember.get(0).getPw().equals(pw)) {
				System.out.println("비밀번호가 맞지 않습니다.");
				return null;
			}

			System.out.println("로그인 완료!");
			return selectMember.get(0);
		}
	}
	
	public void regist(Scanner scanner) {
		System.out.print("아이디를 입력해주세요: ");
		String id = scanner.nextLine();
		
		System.out.print("비밀번호를 입력해주세요: ");
		String pw = scanner.nextLine();
		
		list.add(new Member(id, pw));
		System.out.println("등록 완료!");
	}
}
