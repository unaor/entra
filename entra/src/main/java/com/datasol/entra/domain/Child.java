package com.datasol.entra.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="childs")
@DiscriminatorValue("childs")
@PrimaryKeyJoinColumn(name="father_id")
public class Child extends Father {
	
	@Column(name="age")
	public Long age;

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

}
