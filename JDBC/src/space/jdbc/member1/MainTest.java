package space.jdbc.member1;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		
		CustomerDao customerDao = new JdbcCustomerDao();
		
		Customer1 customer = new Customer1();
		
		customer.setId("VC");
		customer.setPassword("6248");
		
		customerDao.insert(customer);
		
		List<Customer1> customers = customerDao.findAll();
		
		Customer1 customer1 = new Customer1();
		customer1.setId("A");
		customer1.setPassword("1111");
		customer1.setRegdate(Date.valueOf("2025-01-01"));
		customer1.setUpdatedate(Timestamp.valueOf("2025-01-01 20:15:22.078"));
		
		Customer1 customer3 = new Customer1();
		customer3.setPassword("4796");
		customer3.setRegdate(Date.valueOf("2025-04-06"));
		customer3.setUpdatedate(Timestamp.valueOf("2025-04-06 20:15:22.078"));
		customer3.setId("A");
		
		customerDao.update(customer3);
		
		for (Customer1 customer2 : customerDao.findAll()) {
			System.out.println(customer2);
		}
		
	}

}
