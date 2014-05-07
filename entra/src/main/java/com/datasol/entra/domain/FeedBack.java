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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * 
 * The FeedBack objects related to the Client object, this stores the individual feedback a client has received
 */
@Entity
@Table(name = "feedbacks",schema="entra")
public class FeedBack implements Serializable {

	private static final long serialVersionUID = -2664053343647665858L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="feedback_id")
	private Long feedbackId;
	@ManyToOne
    @JoinColumn(name = "client_id",updatable=true, insertable=true)
	private Client client;
	@Column(name="feedback_text")
	@NotNull
	@Size(min=5,max=255)
	private String feedBackText;
	@Column(name="rating")
	@NotNull
	@Size(min=1,max=5)
	private Integer starRating;
	
	public FeedBack(){}

	public Long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

}
