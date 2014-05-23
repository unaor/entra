package com.datasol.entra.domain;

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
import javax.persistence.Table;


/*
 * 
 * this class handles the roles and permissions of the users, as required by spring-security
 */
@Entity
@Table(name = "authorities", schema = "entra")
public class Authority implements Serializable{
	
	
	private static final long serialVersionUID = -868596531052587133L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "authority_id")
	private Long authorityId;

	@OneToMany(mappedBy = "authority", targetEntity = User.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<User> users;
	
	@Column(name="authority")
	private String authorityName;
	
	public Authority(){}

	public Long getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(Long authorityId) {
		this.authorityId = authorityId;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	
}
