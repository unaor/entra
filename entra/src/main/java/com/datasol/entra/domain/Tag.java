package com.datasol.entra.domain;

/**
 * a simple class to represents the business tags
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tags",schema="entra")
public class Tag implements Serializable {


	private static final long serialVersionUID = -3344840646968922944L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="tag_id")
	private Integer tagId;
	@Column(name="tag_description")
	private String tagDescription;
	
	public Tag(){}

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public String getTagDescription() {
		return tagDescription;
	}

	public void setTagDescription(String tagDescription) {
		this.tagDescription = tagDescription;
	}

}
