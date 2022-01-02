package com.p2.driver.creditcards;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name="creditcards")
public class CreditCards {
	@Id
	@GeneratedValue
	@Column(name="cardid")
	private int cardID;
	@Column(name="cardnum")
	private long cardNum;
	@Column(name="holderid")
	private int holderID;
	@Column(name="cvc")
	private int cvc;
	@Column(name="holdername")
	private String holderName;
	@Column(name="expdate")
	private String expDate;
	//status is either EMPLOYEE or CUSTOMER

}
