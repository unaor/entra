package com.datasol.entra.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author unaor
 *this class represent a paying user of the portal
 */
@Entity
@Table(name = "clients",schema="entra")

public class Client implements Serializable  {
	
	private static final long serialVersionUID = -3757677440982682401L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="client_id")
	private Long clientId;
	@Column(name="business_name")
	@NotNull
	@Size(min=5,max=25)
	private String businessName;
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "entra.tags_by_client", joinColumns ={
    @JoinColumn(name = "business_id") }, inverseJoinColumns = {@JoinColumn(name = "tag_id") })
	private Set<Tag> tags;
	@Column(name="business_street_address")
	@NotNull
	private String streetAddress;
	@Column(name="business_city_name")
	@NotNull
	private String city;
	@Column(name="business_province_name")
	@NotNull
	private String province;
	@Column(name="business_phone_number")
	@NotNull
	private String businessPhoneNumber;
	@Column(name="business_email")
	@NotNull
	@Email
	private String businessEmail;	
	@OneToMany(mappedBy="receiverOfFBClient",targetEntity=FeedBack.class,
             fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<FeedBack> receivedFeedbacks;	
	@Column(name="client_join_date") 
	@DateTimeFormat(pattern="dd/MM/YY")
	private Date affiliationDate;
	@Column(name="client_allowed_coupons")
	private Integer allowedCoupons;
	@OneToMany(mappedBy="client",targetEntity=Coupon.class,
             fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Coupon> coupons;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	 
	public Client(){}
	
	public Client(User user){
		this.user = user;
	}
	
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public Set<Tag> getTags() {
		return tags;
	}
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getBusinessPhoneNumber() {
		return businessPhoneNumber;
	}
	public void setBusinessPhoneNumber(String businessPhoneNumber) {
		this.businessPhoneNumber = businessPhoneNumber;
	}
	public String getBusinessEmail() {
		return businessEmail;
	}
	public void setBusinessEmail(String businessEmail) {
		this.businessEmail = businessEmail;
	}
	
	public Set<FeedBack> getReceivedFeedbacks() {
		return receivedFeedbacks;
	}

	public void setReceivedFeedbacks(Set<FeedBack> receivedFeedbacks) {
		this.receivedFeedbacks = receivedFeedbacks;
	}

	public Date getAffiliationDate() {
		return affiliationDate;
	}
	public void setAffiliationDate(Date affiliationDate) {
		this.affiliationDate = affiliationDate;
	}
	public Integer getAllowedCoupons() {
		return allowedCoupons;
	}
	public void setAllowedCoupons(Integer allowedCoupons) {
		this.allowedCoupons = allowedCoupons;
	}
	public Set<Coupon> getCoupons() {
		return coupons;
	}
	public void setCoupons(Set<Coupon> coupons) {
		this.coupons = coupons;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	//TODO: add financialData object
}
