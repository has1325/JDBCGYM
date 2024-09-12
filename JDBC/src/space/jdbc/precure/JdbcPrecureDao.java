package space.jdbc.precure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcPrecureDao implements PrecureDao {

	@Override
	public boolean insert(Precure precure) {
		boolean result = false;
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement 
					= connection.prepareStatement("INSERT INTO PRECURE (ID,NAME,AGE,COLOR,TYPE,BIRTH,ITEM,COMMENTS)"
							+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
			
			pStatement.setInt(1, precure.getId());
			pStatement.setString(2, precure.getName());
			pStatement.setInt(3, precure.getAge());
			pStatement.setString(4, precure.getColor());
			pStatement.setString(5, precure.getType());
			pStatement.setDate(6, precure.getBirth());
			pStatement.setString(7, precure.getItem());
			pStatement.setString(8, precure.getComments());
			
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
	public List<Precure> findAll() {
		List<Precure> precure = new ArrayList<Precure>();
		
		try (Connection connection = DataSource.getDataSource();
		PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM PRECURE ORDER BY ID DESC FETCH FIRST 2 ROWS ONLY");
		ResultSet rs = pStatement.executeQuery()) {
		
		while(rs.next()) {
			Precure precure2 = new Precure(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getInt("age"),
					rs.getString("color"),
					rs.getString("type"),
					rs.getDate("birth"),
					rs.getString("item"),
					rs.getString("comments")
					);
			
			precure.add(precure2);
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return precure;
	}

	@Override
	public Precure findById(int id) {
		Precure precure  = null;
		
		try (Connection connection = DataSource.getDataSource();
		PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM PRECURE WHERE ID = ?")
		) {
		
		pStatement.setInt(1, id);
		ResultSet rs = pStatement.executeQuery();
		
		if(rs.next()) {
			precure = new Precure();
				
			precure.setId(rs.getInt("id"));
			precure.setName(rs.getString("name"));
			precure.setAge(rs.getInt("age"));
			precure.setColor(rs.getString("color"));
			precure.setType(rs.getString("type"));
			precure.setBirth(rs.getDate("birth"));
			precure.setItem(rs.getString("item"));
			precure.setComments(rs.getString("comments"));
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return precure;
	}

	@Override
	public boolean update(Precure precure) {
		boolean result = false;
		
		try(Connection conn = DataSource.getDataSource();
			PreparedStatement pStatement
			= conn.prepareStatement("UPDATE PRECURE SET ID = ? , ITEM = ? WHERE NAME = ?")){
		
			pStatement.setInt(1, precure.getId());
			pStatement.setString(2, precure.getItem());
			pStatement.setString(3, precure.getName());
			
			int affectedRows = pStatement.executeUpdate();
				
			if(affectedRows > 0) {
				result = true;
			}
			
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return result;
	}

	@Override
	public boolean deleteById(int id) {
		boolean result = false;

		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement
					= connection.prepareStatement("DELETE FROM PRECURE WHERE ID = ?")){
			
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
