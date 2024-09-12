package space.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Product0 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "a12345";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
		
		pStatement = connection.prepareStatement("INSERT INTO PRODUCT(ID,NAME,PRICE,KIND) VALUES(?,?,?,?)");
		
		Long id = 321L;
		String name = "asd";
		Long price = 998L;
		String kind = "zxc";
		
		pStatement.setLong(1, id);
		pStatement.setString(2, name);
		pStatement.setLong(3, price);
		pStatement.setString(4, kind);
		
		pStatement.executeUpdate();
		
		connection.close();
	}
}
