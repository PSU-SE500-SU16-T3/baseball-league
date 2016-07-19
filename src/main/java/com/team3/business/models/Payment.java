package com.team3.business.models;

import java.util.Calendar;

public class Payment {
	private int paymentID;
	private int paymentType;
	private String nameOnCard;
	private String cardNumber;
	private Calendar expDate;
	private String cvvCode;
	private int personID;
	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	public int getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(int i) {
		this.paymentType = i;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String string) {
		this.cardNumber = string;
	}
	public Calendar getExpDate() {
		return expDate;
	}
	public void setExpDate(Calendar string) {
		this.expDate = string;
	}
	public String getCvvCode() {
		return cvvCode;
	}
	public void setCvvCode(String cvvCode) {
		this.cvvCode = cvvCode;
	}
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
}
