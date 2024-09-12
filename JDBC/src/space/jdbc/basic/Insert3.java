package space.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "a12345";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
		System.out.println(connection);
		
		pStatement = connection.prepareStatement("INSERT INTO MEMO3 (CONTENT,SAL,DEPT) VALUES (?,?,?)");
		
		String input = "안녕히가세요";
		long sal = 100;
		String dept = "부서";
		
		pStatement.setString(1, input);
		pStatement.setLong(2, sal);
		pStatement.setString(3, dept);
		
		pStatement.executeUpdate();
		
		connection.close();
	}
}
