package com.datasol.entra.domain;
/*		
 * the class represents a normal user that navigates into the portal
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
@Entity
@Table(name = "users",schema="entra")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User implements Serializable{


	private static final long serialVersionUID = 7168990382927442812L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="first_name")
	@NotNull
	@Size(min=2,max=20)
	private String firstName;
	
	@Column(name="last_name")
	@NotNull
	@Size(min=2,max=20)
	private String lastName;
	
	@Column(name="email",unique=true)
	@NotNull
	@Email
	private String email;
	
	public User() {}
	
	public User(String firstName ,String lastName,String email){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
}
