package com.datasol.entra.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="fathers")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("fathers")
public class Father {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "father_id")
	private Long fatherId;
	
	@Column(name="name")
	private String name;
	
	public Father(){}

	public Long getFatherId() {
		return fatherId;
	}

	public void setFatherId(Long fatherId) {
		this.fatherId = fatherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
