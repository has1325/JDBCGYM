package space.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction {

	public static void main(String[] args) throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "a12345";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
		
		boolean exceptionYN = false;
		
		connection.setAutoCommit(false);
		
		pStatement = connection.prepareStatement("update emp set sal = sal * 1.1 where deptno = 10");
		pStatement.executeUpdate();
		
		pStatement = connection.prepareStatement("update emp set sal = sal * 1.2 where deptno = 20");
		pStatement.executeUpdate();
		
		if(exceptionYN) {
			throw new Exception("강제 예외 발생!");
		}
		
		pStatement = connection.prepareStatement("update emp set sal = sal * 1.3 where deptno = 30");
		pStatement.executeUpdate();
		
		connection.commit();
		
		connection.close();

	} catch(Exception e) {
		e.printStackTrace();
		try {
			connection.rollback();
			System.out.println("롤백 되었습니다.");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
