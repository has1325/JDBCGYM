package member;

import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		//JdbcMemoDao 클래스의 insert 메소드 호출
		//스캐너를...컨텐츠 입력하세요
		//사용자가 안녕하세요 입력했어
		
		Member member = new Member();
		member.setId(2);
		member.setPassword(5432);
		member.setEmail("asd@bbb.ccc");

		MemberDao memberDao = new JdbcMemberDao();
		memberDao.insert(member);
		
		List<Member> members = memberDao.findAll();
		for (Member member2 : members) {
			System.out.println(member2);
		}
		
		Member member1 = memberDao.findById(22);
		System.out.println(member1);
		

	}

}
