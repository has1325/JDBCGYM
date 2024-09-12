package space.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Member0 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "a12345";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
		
		pStatement = connection.prepareStatement("INSERT INTO MEMBER(ID,PASSWORD,EMAIL) VALUES(?,?,?)");
		
		Long id = 123L;
		Long password1 = 54321L;
		String email = "aaa@bbb.ccc";
		
		Long id1 = 555L;
		Long password2 = 34562L;
		String email1 = "khg@uyty.ccc";
		
		Long id2 = 999L;
		Long password3 = 23786L;
		String email2 = "mfj@trey.ccc";
		
		pStatement.setLong(1, id);
		pStatement.setLong(2, password1);
		pStatement.setString(3, email);
		
		pStatement.setLong(1, id1);
		pStatement.setLong(2, password2);
		pStatement.setString(3, email1);
		
		pStatement.setLong(1, id2);
		pStatement.setLong(2, password3);
		pStatement.setString(3, email2);
		
		pStatement.executeUpdate();
		
		connection.close();

	}

}
