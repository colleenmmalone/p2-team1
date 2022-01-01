package com.p2.model;

import java.util.Set;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table
public class Logins {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String  email;
	@Column
	private String pswd;
	@Column
	private String status;
	//status is either EMPLOYEE or CUSTOMER
	
	private Set<Orders> orders;

@ToString.Exclude
private Set<Orders> myOrders;

	public Logins(int id, String firstName, String lastName, String email, String pswd, String status) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.pswd = pswd;
		this.status = status;
	}
	
	public Logins(String firstName, String lastName, String email, String pswd, String status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.pswd = pswd;
		this.status = status;
	}
	

}
