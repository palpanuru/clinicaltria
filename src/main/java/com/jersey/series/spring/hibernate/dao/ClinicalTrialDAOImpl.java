package com.jersey.series.spring.hibernate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jersey.series.spring.hibernate.model.ClinicalTrial;

@Repository("ClinicalTrialDAO")
public class ClinicalTrialDAOImpl implements ClinicalTrialDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public String insertNewClinicalTrialInfo(ClinicalTrial ClinicalTrial) {

		// inserts into database & return ClinicalTrialId (primary_key)
		int ClinicalTrialId = (Integer) sessionFactory.getCurrentSession().save(ClinicalTrial);
		return "ClinicalTrial information saved successfully with ClinicalTrial_ID " + ClinicalTrialId;
	}

	@Override
	@Transactional
	public ClinicalTrial getClinicalTrialInfo(int ClinicalTrialId) {

		// retrieve ClinicalTrial object based on the id supplied in the formal argument
		ClinicalTrial ClinicalTrial = (ClinicalTrial) sessionFactory.getCurrentSession().get(ClinicalTrial.class, ClinicalTrialId);
		return ClinicalTrial;
	}

	@Override
	@Transactional
	public String updateClinicalTrialInfo(ClinicalTrial updateClinicalTrial) {

		// update database with ClinicalTrial information and return success msg
		sessionFactory.getCurrentSession().update(updateClinicalTrial);
		return "ClinicalTrial information updated successfully";
	}

	@Override
	@Transactional
	public String removeClinicalTrialInfo(ClinicalTrial removeClinicalTrial) {

		// delete ClinicalTrial information and return success msg
		sessionFactory.getCurrentSession().delete(removeClinicalTrial);
		return "ClinicalTrial information with ClinicalTrial_ID " + removeClinicalTrial.getNctId() +  " deleted successfully";
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<ClinicalTrial> getAllClinicalTrialInfo() {

		// get all ClinicalTrials info from database
		List<ClinicalTrial> lstClinicalTrial = sessionFactory.getCurrentSession().createCriteria(ClinicalTrial.class).list();
		return lstClinicalTrial;
	}
}