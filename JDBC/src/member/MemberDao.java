package member;

import java.util.List;

public interface MemberDao {
	boolean insert(Member member);
	
	List<Member> findAll();
	
	Member findById(int id);
	
	boolean update(Member Member);
	
	boolean deleteById(int id);
}
