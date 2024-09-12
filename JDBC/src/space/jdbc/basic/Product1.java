package space.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Product1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "a12345";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
		
		pStatement = connection.prepareStatement("UPDATE PRODUCT SET ID = ? WHERE NAME = ?");
		
		String name = "asd";
		Long id = 679L;
		
		pStatement.setLong(1, id);
		pStatement.setString(2, name);
		
		pStatement.executeUpdate();
		
		connection.close();

	}

}
