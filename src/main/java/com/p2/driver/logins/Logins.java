package com.p2.driver.logins;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.p2.driver.orders.Orders;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name="logins")
public class Logins {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String  email;
	@Column(name="pswd")
	private String pswd;
	@Column(name="status")
	private String status;
	//status is either EMPLOYEE or CUSTOMER
	@ToString.Exclude
	@OneToMany(mappedBy="customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Orders> orders;
	
	
	public Logins(String firstName, String lastName, String email, String pswd, String status, Set<Orders> orders) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.pswd = pswd;
		this.status = status;
		this.orders = orders;
	}
	
	public Logins(String email, String pswd) {
		super();

		this.email = email;
		this.pswd = pswd;

	}

}