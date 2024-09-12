package space.jdbc.Card;

import java.util.List;

public interface CardApprovalDetailsDao {

	boolean insert(CardApprovalDetails cardapprovaldetails);
	List<CardApprovalDetailsDao> findAll();
	Card findById(String ApprovalNumber);
	
	boolean update(CardApprovalDetails cardapprovaldetails);
	boolean deleteById(String ApprovalNumber);
}
