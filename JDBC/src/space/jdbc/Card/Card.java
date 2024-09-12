package space.jdbc.Card;

import java.sql.Date;

public class Card {

	private String CardNumber;
	private Date Accession;
	
	Card(){}
	
	public Card(String CardNumber, Date Accession) {
		super();
		this.CardNumber = CardNumber;
		this.Accession = Accession;
	}
	
	public Card(String CardNumber, Date Accession,String ApprovalNumber) {
		super();
		this.CardNumber = CardNumber;
		this.Accession = Accession;
	}

	public String getCardNumber() {
		return CardNumber;
	}

	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}

	public Date getAccession() {
		return Accession;
	}

	public void setAccession(Date accession) {
		Accession = accession;
	}

	@Override
	public String toString() {
		return "Card [CardNumber=" + CardNumber + ", Accession=" + Accession + ", getCardNumber()=" + getCardNumber()
				+ ", getAccession()=" + getAccession() + "]";
	}
	
	
}
