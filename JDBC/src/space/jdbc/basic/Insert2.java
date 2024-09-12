package space.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert2 {

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
		
		pStatement = connection.prepareStatement("INSERT INTO MEMO2 (CONTENT,SAL) VALUES (?,?)");
		
		//안녕하세요
		String input = "안녕하세요";
		long sal = 100;
		
		pStatement.setString(1, input);
		pStatement.setLong(2, sal);
		
		pStatement.executeUpdate();
		
		connection.close();
	}
}

