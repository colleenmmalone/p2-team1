package com.p2.model;

import java.util.Set;

import javax.persistence.*;
//one to many between logins and orders

@Entity
@Table(name="logins")
public class Logins {
	@Id
	@GeneratedValue
	@Column(name = "id")
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
	  @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "id", referencedColumnName = "customer")
	private Orders orders ;
	public Logins(int id, String firstName, String lastName, String email, String pswd, String status, Orders orders) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.pswd = pswd;
		this.status = status;
		this.orders= orders;
	}
	
	public Logins() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	

	@Override
	public String toString() {
		return "Logins [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", pswd=" + pswd + ", status=" + status + "]";
	}
	

}
