package space.jdbc.Card;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import space.jdbc.member1.Customer1;
import space.jdbc.member1.CustomerDao;
import space.jdbc.member1.JdbcCustomerDao;

public class MainTest {

	public static void main(String[] args) {
		CardDao cardDao = new JdbcCardDao();
		
		CardApprovalDetailsDao cardapprovaldetailsDao = new JdbcCardApprovalDetailsDao();
		
		Card card = new Card();
		
		CardApprovalDetails cardapprovaldetails = new CardApprovalDetails();
		
		card.setCardNumber("54321");
		card.setAccession(Date.valueOf("2025-01-01"));
		
		cardDao.insert(card);
		
		cardapprovaldetails.setApprovalNumber("53264");
		cardapprovaldetails.setCompanyName("가나다라");
		cardapprovaldetails.setApprovalDate(Date.valueOf("2025-06-01"));
		cardapprovaldetails.setCardNumber("5243");
		
		cardapprovaldetailsDao.insert(cardapprovaldetails);
		
		List<Card> CardDaos = cardDao.findAll();
		
		Card card2 = new Card();
		card2.setCardNumber("4332");
		card2.setAccession(Date.valueOf("2025-01-01"));
		
		for (Card card3 : cardDao.findAll()) {
			System.out.println(card3);
		}

	}

}
