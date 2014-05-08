package com.datasol.entra.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@AttributeOverrides({
    @AttributeOverride(name="firstName", column=@Column(name="FIRST_NAME")),
    @AttributeOverride(name="lastName", column=@Column(name="LAST_NAME")),
    @AttributeOverride(name="email", column=@Column(name="email"))
})
public class Client extends User {
	
	private static final long serialVersionUID = -3757677440982682401L;
	
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
	 @OneToMany(mappedBy="client",targetEntity=FeedBack.class,
             fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<FeedBack> feedbacks;
	@Column(name="client_join_date") 
	@DateTimeFormat(pattern="dd/MM/YY")
	private Date affiliationDate;
	@Column(name="client_allowed_coupons")
	private Integer allowedCoupons;
	 @OneToMany(mappedBy="client",targetEntity=Coupon.class,
             fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Coupon> coupons;
	 
	public Client(){}
	
	public Client(User user){
		setEmail(user.getEmail());
		setFirstName(user.getFirstName());
		setLastName(user.getLastName());
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
	public Set<FeedBack> getFeedbacks() {
		return feedbacks;
	}
	public void setFeedbacks(Set<FeedBack> feedbacks) {
		this.feedbacks = feedbacks;
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
	
	//TODO: add financialData object
}
