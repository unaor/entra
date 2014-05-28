package com.datasol.entra.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

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
	@Size(min = 2, max = 20, message = "{user.validation.first.name.not.valid}")
	private String firstName;
	@Column(name = "last_name")
	@NotNull
	@Size(min = 2, max = 20)
	private String lastName;
	@Column(name = "username", unique = true)
	@NotNull
	@Email
	private String email;
	@Column(name = "enabled")
	private Boolean enabled;
	@Column(name = "password")
	@Size(min = 6, max = 20)
	private String password;
	@OneToMany(mappedBy = "authorOfFBUser", targetEntity = FeedBack.class, fetch = FetchType.LAZY, cascade = { javax.persistence.CascadeType.ALL })
	private Set<FeedBack> placedFeedBacks;
	@OneToOne(mappedBy = "user", cascade = { javax.persistence.CascadeType.ALL })
	private Client client;
	@DateTimeFormat(pattern = "dd/MM/YY")
	private Date registrationDate;
	@ManyToOne
	@JoinColumn(name = "authority_id", updatable = true, insertable = true, nullable = true)
	private Authority authority;
	@Transient
	private String passwordConfirmation;
	@Transient
	private Boolean acceptedTos;

	public User() {
	}

	public User(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<FeedBack> getPlacedFeedBacks() {
		return this.placedFeedBacks;
	}

	public void setPlacedFeedBacks(Set<FeedBack> placedFeedBacks) {
		this.placedFeedBacks = placedFeedBacks;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Authority getAuthority() {
		return this.authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public String getPasswordConfirmation() {
		return this.passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public Boolean getAcceptedTos() {
		return this.acceptedTos;
	}

	public void setAcceptedTos(Boolean acceptedTos) {
		this.acceptedTos = acceptedTos;
	}
}