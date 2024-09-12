package space.jdbc.memo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteById {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "a12345";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
		
		//update
		
		
		pStatement = connection.prepareStatement("DELETE FROM MEMO WHERE id = ?");
		
		Long id = 25L;
		
		pStatement.setLong(1, id);
		
		pStatement.executeUpdate();
		
		connection.close();

	}

}
