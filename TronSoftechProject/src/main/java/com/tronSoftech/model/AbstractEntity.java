package com.tronSoftech.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity {

	private LocalDate createdOn;

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}
	
}
