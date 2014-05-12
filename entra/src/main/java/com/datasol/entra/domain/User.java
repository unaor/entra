package com.datasol.entra.domain;

/*		
 * the class represents a normal user that navigates into the portal
 */
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "users", schema = "entra")
public class User implements Serializable {

	private static final long serialVersionUID = 7168990382927442812L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "first_name")
	@NotNull
	@Size(min = 2, max = 20)
	private String firstName;

	@Column(name = "last_name")
	@NotNull
	@Size(min = 2, max = 20)
	private String lastName;

	@Column(name = "email", unique = true)
	@NotNull
	@Email
	private String email;
	@OneToMany(mappedBy = "authorOfFBUser", targetEntity = FeedBack.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<FeedBack> placedFeedBacks;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Client client;

	public User() {
	}

	public User(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
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

	public Set<FeedBack> getPlacedFeedBacks() {
		return placedFeedBacks;
	}

	public void setPlacedFeedBacks(Set<FeedBack> placedFeedBacks) {
		this.placedFeedBacks = placedFeedBacks;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
