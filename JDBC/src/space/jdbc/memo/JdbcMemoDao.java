package space.jdbc.memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcMemoDao implements MemoDao {

	@Override
	public boolean insert(Memo memo) {
		boolean result = false;
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement 
					= connection.prepareStatement("INSERT INTO MEMO (CONTENT) VALUES (?)")){
			
			pStatement.setString(1, memo.getContent());
			
			int rows = pStatement.executeUpdate();
			
			if(rows > 0) {
				result = true;
			}
			
		}	catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Memo> findAll() {
		List<Memo> memos = new ArrayList<Memo>();
		
		try (Connection connection = DataSource.getDataSource();
		PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM MEMO ORDER BY ID DESC");
		ResultSet rs = pStatement.executeQuery()) {
		
		while(rs.next()) {
				Memo memo = new Memo();
				
				memo.setId(rs.getLong("id"));
				memo.setContent(rs.getString("content"));
				
				memos.add(memo);
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return memos;
	}

	@Override
	public Memo findById(long id) {
		Memo memo = null;
		
		try (Connection connection = DataSource.getDataSource();
		PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM MEMO WHERE ID = ?")
		) {
		
		pStatement.setLong(1, 1L);	
		ResultSet rs = pStatement.executeQuery();
		
		if(rs.next()) {
				memo = new Memo();
				
				memo.setId(rs.getLong("id"));
				memo.setContent(rs.getString("content"));
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return memo;
	}

	@Override
	public boolean update(Memo memo) {
		boolean result = false;
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement
					= connection.prepareStatement("UPDATE MEMO SET content = ? WHERE id = ?")){
			
			pStatement.setString(1, memo.getContent());
			pStatement.setLong(2, memo.getId());
			
			int rows = pStatement.executeUpdate();
			
			if(rows>0) {
				result = true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteById(long id) {
		boolean result = false;
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement
					= connection.prepareStatement("DELETE FROM MEMO WHERE id = ?")){
			
			pStatement.setLong(1, id);
			
			int rows = pStatement.executeUpdate();
			
			if(rows>0) {
				result = true;
			}
	}catch(Exception e) {
		e.printStackTrace();
	}
		return result;
	}
}
