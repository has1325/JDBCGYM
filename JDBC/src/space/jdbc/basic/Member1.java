package space.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Member1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "a12345";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
		
		pStatement = connection.prepareStatement("DELETE FROM MEMBER WHERE ID = ?");
		
		Long id = 123L;
		
		pStatement.setLong(1, id);
		
		pStatement.executeUpdate();
		
		connection.close();

	}

}
