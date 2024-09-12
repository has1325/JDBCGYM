package space.jdbc.Card;

import java.sql.Date;

public class CardApprovalDetails {
	
	private String ApprovalNumber;
	private String CompanyName;
	private Date ApprovalDate;
	private String CardNumber;
	
	CardApprovalDetails(){}
	
	public CardApprovalDetails(String ApprovalNumber,String CompanyName,Date ApprovalDate,String CardNumber) {
		this.ApprovalNumber = ApprovalNumber;
		this.CompanyName = CompanyName;
		this.ApprovalDate = ApprovalDate;
		this.CardNumber = CardNumber;
	}

	public String getApprovalNumber() {
		return ApprovalNumber;
	}

	public void setApprovalNumber(String approvalNumber) {
		ApprovalNumber = approvalNumber;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public Date getApprovalDate() {
		return ApprovalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		ApprovalDate = approvalDate;
	}

	public String getCardNumber() {
		return CardNumber;
	}

	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}

	@Override
	public String toString() {
		return "CardApprovalDetails [ApprovalNumber=" + ApprovalNumber + ", CompanyName=" + CompanyName
				+ ", ApprovalDate=" + ApprovalDate + ", CardNumber=" + CardNumber + ", getApprovalNumber()="
				+ getApprovalNumber() + ", getCompanyName()=" + getCompanyName() + ", getApprovalDate()="
				+ getApprovalDate() + ", getCardNumber()=" + getCardNumber() + "]";
	}
	
	
}
