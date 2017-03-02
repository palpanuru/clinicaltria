package com.jersey.series.spring.hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLINICAL_TRIAL")
public class ClinicalTrial {

	// member variables
	@Id 
	@GeneratedValue
	@Column(name = "NCT_ID")
	private int nctId;

	@Column(name= "OFFICIAL_TITLE")
	private String officialtitle;

	@Column(name= "PHASE")
	private String phase;

	@Column(name= "primary_completion_date")
	private Date primaryCompletionDate;

	public int getNctId() {
		return nctId;
	}

	public void setNctId(int nctId) {
		this.nctId = nctId;
	}

	public String getOfficialtitle() {
		return officialtitle;
	}

	public void setOfficialtitle(String officialtitle) {
		this.officialtitle = officialtitle;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public Date getPrimaryCompletionDate() {
		return primaryCompletionDate;
	}

	public void setPrimaryCompletionDate(Date primaryCompletionDate) {
		this.primaryCompletionDate = primaryCompletionDate;
	}

	// getters & setters

}