package com.p2.model;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="logins")
public class Logins {
	public Logins(String string, String string2, String string3, String string4, String string5) {
		// TODO Auto-generated constructor stub
	}
	public Logins(int i, String string, String string2, String string3, String string4, String string5) {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue
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
	

}
