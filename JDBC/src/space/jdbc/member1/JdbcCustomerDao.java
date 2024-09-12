package space.jdbc.member1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.Member;
import space.jdbc.memo.DataSource;

public class JdbcCustomerDao implements CustomerDao {

	@Override
	public boolean insert(Customer1 customer) {
		boolean result = false;
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement 
					= connection.prepareStatement("INSERT INTO CUSTOMER1 (ID, PASSWORD, REGDATE, UPDATEDATE)"
							+ " VALUES (?, ?, SYSDATE, SYSTIMESTAMP)")) {
			
			pStatement.setString(1, customer.getId());
			pStatement.setString(2, customer.getPassword());
			
			int rows = pStatement.executeUpdate();
			
			if(rows > 0) {
				result = true;
			}
			
		}	catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Customer1> findAll() {
		List<Customer1> customers = new ArrayList<Customer1>();
		
		try (Connection connection = DataSource.getDataSource();
		PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM CUSTOMER1 ORDER BY ID DESC FETCH FIRST 2 ROWS ONLY");
		ResultSet rs = pStatement.executeQuery()) {
		
		while(rs.next()) {
			Customer1 customer = new Customer1(
					rs.getString("id"),
					rs.getString("password"),
					rs.getDate("regdate"),
					rs.getTimestamp("updatedate"));
			
			customers.add(customer);
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public Customer1 findById(String id) {
		Customer1 customer  = null;
		
		try (Connection connection = DataSource.getDataSource();
		PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM CUSTOMER1 WHERE ID = ?")
		) {
		
		pStatement.setInt(1, 1);	
		ResultSet rs = pStatement.executeQuery();
		
		if(rs.next()) {
			customer = new Customer1();
				
			customer.setId(rs.getString("id"));
			customer.setPassword(rs.getString("password"));
			customer.setRegdate(rs.getDate("regdate"));
			customer.setUpdatedate(rs.getTimestamp("updatedate"));
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public boolean update(Customer1 customer1) {
		boolean result = false;
		
		try(Connection conn = DataSource.getDataSource();
			PreparedStatement pStatement
			= conn.prepareStatement("UPDATE CUSTOMER1 SET PASSWORD = ? , REGDATE = ?, UPDATEDATE = ? WHERE ID = ?")){
		
			pStatement.setString(1, customer1.getPassword());
			pStatement.setDate(2, customer1.getRegdate());
			pStatement.setTimestamp(3, customer1.getUpdatedate());
			pStatement.setString(4, customer1.getId());
				
			int affectedRows = pStatement.executeUpdate();
				
			if(affectedRows > 0) {
				result = true;
			}
			
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return result;
}
	@Override
	public boolean deleteById(String id) {
		boolean result = false;
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement
					= connection.prepareStatement("DELETE FROM CUSTOMER1 WHERE id = ?")){
			
			pStatement.setString(1, id);
			
			int rows = pStatement.executeUpdate();
			
			if(rows>0) {
				result = true;
			}
	}catch(Exception e) {
		e.printStackTrace();
	}
		return result;
	}
	
}
