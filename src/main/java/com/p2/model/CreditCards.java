package com.p2.model;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table
public class CreditCards {
	@Id 
	private int cardID;
	private long cardNum;
	private int holderID, cvc;
	private String holderName, expDate;

}
