package space.jdbc.Card;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import space.jdbc.member1.Customer1;
import space.jdbc.memo.DataSource;

public class JdbcCardDao implements CardDao {

	@Override
	public boolean insert(Card card) {
		boolean result = false;
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement 
					= connection.prepareStatement("INSERT INTO CARD (CARDNUMBER, ACCESSION)"
							+ " VALUES (?, ?)")) {
			
			pStatement.setString(1, card.getCardNumber());
			pStatement.setDate(2, card.getAccession());
			
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
	public List<Card> findAll() {
		List<Card> cards = new ArrayList<Card>();
		
		try (Connection connection = DataSource.getDataSource();
		PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM CARD ORDER BY ID DESC FETCH FIRST 2 ROWS ONLY");
		ResultSet rs = pStatement.executeQuery()) {
		
		while(rs.next()) {
			Card card = new Card(
					rs.getString("cardnumber"),
					rs.getDate("accession"));
			cards.add(card);
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cards;
	}

	@Override
	public Card findById(String id) {
		Card card  = null;
		
		try (Connection connection = DataSource.getDataSource();
		PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM CARD WHERE CARDNUMBER = ?")
		) {
		
		pStatement.setString(1, "4352");	
		ResultSet rs = pStatement.executeQuery();
		
		if(rs.next()) {
			card = new Card();
				
			card.setCardNumber(rs.getString("cardnumber"));
			card.setAccession(rs.getDate("Accession"));
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return card;
	}

	@Override
	public boolean update(Card card) {
		boolean result = false;
		
		try(Connection conn = DataSource.getDataSource();
			PreparedStatement pStatement
			= conn.prepareStatement("UPDATE CARD SET ACCESSION = ? WHERE CARDNUMBER = ?")){
		
			pStatement.setString(1, card.getCardNumber());
			pStatement.setDate(2, card.getAccession());
				
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
	public boolean deleteById(String CardNumber) {
		boolean result = false;
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement
					= connection.prepareStatement("DELETE FROM CARD WHERE cardnumber = ?")){
			
			pStatement.setString(1, "5234");
			
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
