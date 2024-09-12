package space.jdbc.member1;

import java.util.List;

public interface CustomerDao {
	
	boolean insert(Customer1 customer);
	List<Customer1> findAll();
	Customer1 findById(String id);
	
	boolean update(Customer1 customer);
	boolean deleteById(String id);
}
