package com.datasol.entra.domain;
/*
 * this class represents the basic business unit of a coupon.
 */

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * @author unaor
 *
 */
@Entity
@Table(name = "coupons",schema="entra")
public class Coupon implements Serializable {

	private static final long serialVersionUID = 3852523804094046537L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="coupon_id")
	private Long couponId;
	@Column(name="coupon_title")
	@NotNull
	@Size(min=5,max=50)
	private String couponTitle;
	@Column(name="coupon_description")
	@NotNull
	private String couponDescription;
	@Column(name="coupon_value")
	@NotNull
	private Integer couponValue;
	@Column(name="coupon_creation_date")
	@DateTimeFormat(pattern="dd/MM/YY")
	private Date couponCreationDate;
	@Column(name="coupon_expiration_date")
	@DateTimeFormat(pattern="dd/MM/YY")
	private Date couponExpirationDate;
	@Column(name="coupon_location_href")
	private String couponPictureLocation;
	@Column(name="coupon_quantity")
	private Integer availableQuantity;
	@Column(name="is_coupon_active")
	private Boolean isActive;
	@ManyToOne
    @JoinColumn(name = "client_id",updatable=true, insertable=true)
	private Client client;
	
	//this attributes related to popularity settings of a coupon
	@Column(name="number_of_clicks")
	private Long numberOfClicks;
	@Column(name="sent_sms")
	private Long numberOfSms;
	@Column(name="sent_emails")
	private Long numberOfEmailReferels;
	@Column(name="number_of_tweets")
	private Long numberOfTweets;
	@Column(name="number_of_likes")
	private Long numberOfLikes;
	
	public Coupon (){}

	public Long getCouponId() {
		return couponId;
	}

	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}

	public String getCouponTitle() {
		return couponTitle;
	}

	public void setCouponTitle(String couponTitle) {
		this.couponTitle = couponTitle;
	}

	public String getCouponDescription() {
		return couponDescription;
	}

	public void setCouponDescription(String couponDescription) {
		this.couponDescription = couponDescription;
	}

	public Integer getCouponValue() {
		return couponValue;
	}

	public void setCouponValue(Integer couponValue) {
		this.couponValue = couponValue;
	}

	public Date getCouponExpirationDate() {
		return couponExpirationDate;
	}

	public void setCouponExpirationDate(Date couponExpirationDate) {
		this.couponExpirationDate = couponExpirationDate;
	}

	public String getCouponPictureLocation() {
		return couponPictureLocation;
	}

	public void setCouponPictureLocation(String couponPictureLocation) {
		this.couponPictureLocation = couponPictureLocation;
	}

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCouponCreationDate() {
		return couponCreationDate;
	}

	public void setCouponCreationDate(Date couponCreationDate) {
		this.couponCreationDate = couponCreationDate;
	}

	public Long getNumberOfClicks() {
		return numberOfClicks;
	}

	public void setNumberOfClicks(Long numberOfClicks) {
		this.numberOfClicks = numberOfClicks;
	}

	public Long getNumberOfSms() {
		return numberOfSms;
	}

	public void setNumberOfSms(Long numberOfSms) {
		this.numberOfSms = numberOfSms;
	}

	public Long getNumberOfEmailReferels() {
		return numberOfEmailReferels;
	}

	public void setNumberOfEmailReferels(Long numberOfEmailReferels) {
		this.numberOfEmailReferels = numberOfEmailReferels;
	}

	public Long getNumberOfTweets() {
		return numberOfTweets;
	}

	public void setNumberOfTweets(Long numberOfTweets) {
		this.numberOfTweets = numberOfTweets;
	}

	public Long getNumberOfLikes() {
		return numberOfLikes;
	}

	public void setNumberOfLikes(Long numberOfLikes) {
		this.numberOfLikes = numberOfLikes;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
