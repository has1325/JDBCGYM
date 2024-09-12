package space.jdbc.basic;

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
		
		
		pStatement = connection.prepareStatement("SELECT * FROM MEMO ORDER BY ID DESC");
		
		ResultSet rs = pStatement.executeQuery();
		
		List<Memo> memos = new ArrayList<Memo>();
		
		while(rs.next()) {
			Memo memo = new Memo();
			
			memo.setId(rs.getLong("id"));
			memo.setContent(rs.getString("content"));
			
			memos.add(memo);
		}
		
		connection.close();

	}

}
