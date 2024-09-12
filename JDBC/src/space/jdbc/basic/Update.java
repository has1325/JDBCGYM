package space.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "a12345";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
		
		//update
		
		
		pStatement = connection.prepareStatement("UPDATE MEMO SET content = ? WHERE id = ?");
		
		String content = "안녕히가세요";
		Long id = 3L;
		
		pStatement.setString(1, content);
		pStatement.setLong(2, id);
		
		pStatement.executeUpdate();
		
		connection.close();
	}
}
