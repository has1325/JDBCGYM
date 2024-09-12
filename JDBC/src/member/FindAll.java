package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FindAll {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "a12345";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
		
		
		pStatement = connection.prepareStatement("SELECT * FROM MEMBER ORDER BY ID DESC");
		
		ResultSet rs = pStatement.executeQuery();
		
		List<Member> members = new ArrayList<Member>();
		
		while(rs.next()) {
			Member member = new Member();
			
			member.setId(rs.getInt("id"));
			member.setPassword(rs.getInt("password"));
			member.setEmail(rs.getString("email"));
			
			members.add(member);
		}
		
		for (Member member : members) {
			System.out.println(member);
		}
		
		connection.close();

	}

}
