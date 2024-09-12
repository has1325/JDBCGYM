package space.jdbc.Card;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import space.jdbc.memo.DataSource;

public class JdbcCardApprovalDetailsDao implements CardApprovalDetailsDao {

	@Override
	public boolean insert(CardApprovalDetails cardapprovaldetails) {
		boolean result = false;
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement 
					= connection.prepareStatement("INSERT INTO CARDAPPROVALDETAILS (APPROVALNUMBER,COMPANYNAME,APPROVALDATE,CARDNUMBER)"
							+ "VALUES (?, ?, ?, ?)")) {
			
			pStatement.setString(1, cardapprovaldetails.getApprovalNumber());
			pStatement.setString(2, cardapprovaldetails.getCompanyName());
			pStatement.setDate(3, cardapprovaldetails.getApprovalDate());
			pStatement.setString(4, cardapprovaldetails.getCardNumber());
			
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
	public List<CardApprovalDetailsDao> findAll() {
		List<CardApprovalDetails> cardapprovaldetail2 = new ArrayList<CardApprovalDetails>();
		
		try (Connection connection = DataSource.getDataSource();
		PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM CARDAPPROVALDETAILS ORDER BY ID DESC FETCH FIRST 2 ROWS ONLY");
		ResultSet rs = pStatement.executeQuery()) {
		
		while(rs.next()) {
			CardApprovalDetails cardapprovaldetail = new CardApprovalDetails(
					rs.getString("approvalnumber"),
					rs.getString("companyname"),
					rs.getDate("approvaldate"),
					rs.getString("cardnumber"));
			
			cardapprovaldetail2.add(cardapprovaldetail);
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cardapprovaldetail2;
	}

	@Override
	public Card findById(String ApprovalNumber) {
		Card card  = null;
		
		try (Connection connection = DataSource.getDataSource();
		PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM CARDAPPROVALDETAILS WHERE CARDNUMBER = ?")
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
	public boolean update(CardApprovalDetails cardapprovaldetails) {
		boolean result = false;
		
		try(Connection conn = DataSource.getDataSource();
			PreparedStatement pStatement
			= conn.prepareStatement("UPDATE CARDAPPROVALDETAILS SET APPROVALNUMBER = ? WHERE CARDNUMBER = ?")){
		
			pStatement.setString(1, cardapprovaldetails.getApprovalNumber());
			pStatement.setString(2, cardapprovaldetails.getCardNumber());
				
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
	public boolean deleteById(String ApprovalNumber) {
		boolean result = false;

		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement
					= connection.prepareStatement("DELETE FROM CARDAPPROVALDETAILS WHERE cardnumber = ?")){
			
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
