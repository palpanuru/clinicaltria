package com.jersey.series.spring.hibernate.dao;

import java.util.List;

import com.jersey.series.spring.hibernate.model.ClinicalTrial;

public interface ClinicalTrialDAO {

	public String insertNewClinicalTrialInfo(ClinicalTrial addClinicalTrial);
	public ClinicalTrial getClinicalTrialInfo(int clinicalTrialId);
	public String updateClinicalTrialInfo(ClinicalTrial updateClinicalTrial);
	public String removeClinicalTrialInfo(ClinicalTrial removeClinicalTrial);
	public List<ClinicalTrial> getAllClinicalTrialInfo();
}