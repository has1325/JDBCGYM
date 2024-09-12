package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FindById {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "a12345";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
		
		
		pStatement = connection.prepareStatement("SELECT * FROM MEMBER WHERE ID = ?");
		
		pStatement.setInt(1, 2);
		
		ResultSet rs = pStatement.executeQuery();
		
		Member member = null;
		
		if(rs.next()) {
			member = new Member();
			
			member.setId(rs.getInt("id"));
			member.setPassword(rs.getInt("password"));
			member.setEmail(rs.getString("email"));
			
			
		}
		System.out.println(member);
		
		connection.close();

	}

}
