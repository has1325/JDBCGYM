package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcMemberDao implements MemberDao {

	@Override
	public boolean insert(Member member) {
		boolean result = false;
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement 
					= connection.prepareStatement("INSERT INTO MEMBER (ID, PASSWORD, EMAIL) VALUES (?,?,?)")){
			
			pStatement.setInt(1, member.getId());
			pStatement.setInt(2, member.getPassword());
			pStatement.setString(3, member.getEmail());
			
			
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
	public List<Member> findAll() {
		List<Member> members = new ArrayList<Member>();
		
		try (Connection connection = DataSource.getDataSource();
		PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM MEMBER ORDER BY ID DESC");
		ResultSet rs = pStatement.executeQuery()) {
		
		while(rs.next()) {
				Member member = new Member();
				
				member.setId(rs.getInt("id"));
				member.setPassword(rs.getInt("password"));
				member.setEmail(rs.getString("email"));
				
				members.add(member);
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return members;
	}

	@Override
	public Member findById(int id) {
		Member member = null;
		
		try (Connection connection = DataSource.getDataSource();
		PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM MEMBER WHERE ID = ?")
		) {
		
		pStatement.setInt(1, 1);	
		ResultSet rs = pStatement.executeQuery();
		
		if(rs.next()) {
			member = new Member();
				
			member.setId(rs.getInt("id"));
			member.setPassword(rs.getInt("password"));
			member.setEmail(rs.getString("email"));
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public boolean update(Member member) {
		boolean result = false;
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement
					= connection.prepareStatement("UPDATE MEMBER SET content = ? WHERE id = ?")){
			
			pStatement.setString(1, member.getEmail());
			pStatement.setInt(2, member.getId());
			
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
	public boolean deleteById(int id) {
		boolean result = false;
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement
					= connection.prepareStatement("DELETE FROM MEMBER WHERE id = ?")){
			
			pStatement.setInt(1, id);
			
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
