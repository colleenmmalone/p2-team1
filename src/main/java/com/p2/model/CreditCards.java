package com.p2.model;

import javax.persistence.*;

@Entity
@Table
public class CreditCards {
	@Id
	private int cardID;
	private long cardNum;
	private int holderID, cvc;
	private String holderName, expDate;
	
	public CreditCards(int cardID, long cardNum, int holderID, int cvc, String holderName, String expDate) {
		super();
		this.cardID = cardID;
		this.cardNum = cardNum;
		this.holderID = holderID;
		this.cvc = cvc;
		this.holderName = holderName;
		this.expDate = expDate;
	}
	
	public CreditCards() {
		super();
	}

	public int getCardID() {
		return cardID;
	}

	public void setCardID(int cardID) {
		this.cardID = cardID;
	}

	public long getCardNum() {
		return cardNum;
	}

	public void setCardNum(long cardNum) {
		this.cardNum = cardNum;
	}

	public int getHolderID() {
		return holderID;
	}

	public void setHolderID(int holderID) {
		this.holderID = holderID;
	}

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "CreditCards [cardID=" + cardID + ", cardNum=" + cardNum + ", holderID=" + holderID + ", cvc=" + cvc
				+ ", holderName=" + holderName + ", expDate=" + expDate + "]";
	}
	
	

}
