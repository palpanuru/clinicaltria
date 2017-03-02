package com.jersey.series.spring.hibernate.service;

import in.schema.cdm.ctrial.ClinicalTrialListType;
import in.schema.cdm.ctrial.ClinicalTrialType;

public interface IClinicalTrialService {

	// Basic CRUD operations for ClinicalTrial Service

	public String createOrSaveClinicalTrialInfo(ClinicalTrialType ClinicalTrialType);
	public ClinicalTrialType getClinicalTrialInfo(int ClinicalTrialId);
	public String updateClinicalTrialInfo(ClinicalTrialType ClinicalTrialType);
	public String deleteClinicalTrialInfo(int ClinicalTrialId);
	public ClinicalTrialListType getAllClinicalTrialInfo();
}