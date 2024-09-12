package space.jdbc.memo;

import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		//JdbcMemoDao 클래스의 insert 메소드 호출
		//스캐너를...컨텐츠 입력하세요
		//사용자가 안녕하세요 입력했어
		
		Memo memo = new Memo();
		memo.setContent("반갑습니다");

		MemoDao memoDao = new JdbcMemoDao();
		memoDao.insert(memo);
		
		List<Memo> memos = memoDao.findAll();
		for (Memo memo2 : memos) {
			System.out.println(memo2);
		}
		
		Memo memo1 = memoDao.findById(22);
		System.out.println(memo1);
		

	}

}
