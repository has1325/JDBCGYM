package space.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Member2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "a12345";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
		
		pStatement = connection.prepareStatement("UPDATE MEMBER SET ID = ? WHERE ID = ?");
		
		Long id = 456L;
		Long id1 = 123L;
		
		pStatement.setLong(1, id);
		pStatement.setLong(2, id1);
		
		pStatement.executeUpdate();
		
		connection.close();

	}

}
