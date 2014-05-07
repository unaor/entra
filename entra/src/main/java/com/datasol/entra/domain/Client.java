package com.datasol.entra.domain;

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
public class Client extends User {
	
	private static final long serialVersionUID = -3757677440982682401L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="client_id")
	private Long clientId;
	@OneToOne(mappedBy="client", cascade=CascadeType.ALL)
	private User user;
	@Column(name="business_name")
	@NotNull
	@Size(min=5,max=25)
	private String businessName;
	@ManyToMany(fetch = FetchType.EAGER)
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
             fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<FeedBack> feedbacks;
	@Column(name="client_join_date") 
	@DateTimeFormat(pattern="dd/MM/YY")
	private Date affiliationDate;
	@Column(name="client_allowed_coupons")
	private Integer allowedCoupons;
	 @OneToMany(mappedBy="client",targetEntity=Coupon.class,
             fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Coupon> coupons;
	
	//TODO: add financialData object

}
