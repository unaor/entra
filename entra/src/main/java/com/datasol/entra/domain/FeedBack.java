package com.datasol.entra.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * 
 * The FeedBack objects related to the Client object, this stores the individual feedback a client has received as well as the identity of its author
 */
@Entity
@Table(name = "feedbacks",schema="entra",uniqueConstraints = {@UniqueConstraint(columnNames={"user_id","client_id"})})
public class FeedBack implements Serializable {

	private static final long serialVersionUID = -2664053343647665858L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="feedback_id")
	private Long feedbackId;
	
	@ManyToOne
    @JoinColumn(name = "client_id",updatable=false, insertable=false,nullable=false)
	private Client receiverOfFBClient;
	
	@Column(name="feedback_text")
	@NotNull
	@Size(min=5,max=255)
	private String feedBackText;
	@Column(name="rating")
	@Min(1) @Max(5)
	private Integer starRating;
	@ManyToOne
    @JoinColumn(name = "user_id",updatable=false, insertable=false,nullable=false)
	private User authorOfFBUser;
	
	public FeedBack(){}

	public Long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}


	public String getFeedBackText() {
		return feedBackText;
	}

	public void setFeedBackText(String feedBackText) {
		this.feedBackText = feedBackText;
	}

	public Integer getStarRating() {
		return starRating;
	}

	public void setStarRating(Integer starRating) {
		this.starRating = starRating;
	}

	public Client getReceiverOfFBClient() {
		return receiverOfFBClient;
	}

	public void setReceiverOfFBClient(Client receiverOfFBClient) {
		this.receiverOfFBClient = receiverOfFBClient;
	}

	public User getAuthorOfFBUser() {
		return authorOfFBUser;
	}

	public void setAuthorOfFBUser(User authorOfFBUser) {
		this.authorOfFBUser = authorOfFBUser;
	}
}
