package com.jersey.series.spring.hibernate.service;

import java.util.List;

import in.schema.cdm.ctrial.ClinicalTrialListType;
import in.schema.cdm.ctrial.ClinicalTrialType;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jersey.series.spring.hibernate.dao.ClinicalTrialDAO;
import com.jersey.series.spring.hibernate.model.ClinicalTrial;;

@Component
@Path("/ClinicalTrialservice")
public class ClinicalTrialServiceImpl implements IClinicalTrialService {

	@Autowired
	private ClinicalTrialDAO ClinicalTrialDAO;

	// Basic CRUD operations for ClinicalTrial Service

	// http://localhost:8080/Jersey-Spring-Hibernate/rest/ClinicalTrialservice/addClinicalTrial
	@POST
	@Path("addClinicalTrial")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	public String createOrSaveClinicalTrialInfo(ClinicalTrialType ClinicalTrialType) {

		// unwrap ClinicalTrialType and set in Model object ClinicalTrial
		ClinicalTrial newClinicalTrial = new ClinicalTrial();
		newClinicalTrial.setNctId(ClinicalTrialType.getNctId());
		newClinicalTrial.setOfficialtitle(ClinicalTrialType.getOfficialTitle());
		newClinicalTrial.setPhase(ClinicalTrialType.getPhase());
		newClinicalTrial.setPrimaryCompletionDate(ClinicalTrialType.getPrimarycompletiondate());
		return ClinicalTrialDAO.insertNewClinicalTrialInfo(newClinicalTrial);
	}

	// http://localhost:8080/Jersey-Spring-Hibernate/rest/ClinicalTrialservice/getClinicalTrial/1
	@GET
	@Path("getClinicalTrial/{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ClinicalTrialType getClinicalTrialInfo(@PathParam("id") int ClinicalTrialId) {

		// retrieve ClinicalTrial information based on the id supplied in the formal argument
		ClinicalTrial getClinicalTrial = ClinicalTrialDAO.getClinicalTrialInfo(ClinicalTrialId);

		ClinicalTrialType ClinicalTrialType = new ClinicalTrialType();
		ClinicalTrialType.setNctId(getClinicalTrial.getNctId());
		ClinicalTrialType.setOfficialTitle(getClinicalTrial.getOfficialtitle());
		ClinicalTrialType.setPhase(getClinicalTrial.getPhase());
		ClinicalTrialType.setPrimarycompletiondate(getClinicalTrial.getPrimaryCompletionDate());
		return ClinicalTrialType;
	}

	// http://localhost:8080/Jersey-Spring-Hibernate/rest/ClinicalTrialservice/updateClinicalTrial
	@PUT
	@Path("updateClinicalTrial")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	public String updateClinicalTrialInfo(ClinicalTrialType ClinicalTrialType) {

		// unwrap ClinicalTrialType and set in Model object ClinicalTrial
		ClinicalTrial modifyClinicalTrial = new ClinicalTrial();
		modifyClinicalTrial.setNctId(ClinicalTrialType.getNctId());
		modifyClinicalTrial.setOfficialtitle(ClinicalTrialType.getOfficialTitle());
		modifyClinicalTrial.setPhase(ClinicalTrialType.getPhase());
		modifyClinicalTrial.setPrimaryCompletionDate(ClinicalTrialType.getPrimarycompletiondate());
		
		// update ClinicalTrial info & return SUCCESS message
		return ClinicalTrialDAO.updateClinicalTrialInfo(modifyClinicalTrial);
	}

	// http://localhost:8080/Jersey-Spring-Hibernate/rest/ClinicalTrialservice/deleteClinicalTrial/5
	@DELETE
	@Path("deleteClinicalTrial/{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	public String deleteClinicalTrialInfo(@PathParam("id") int ClinicalTrialId) {

		// delete ClinicalTrial info & return SUCCESS message
		ClinicalTrial removeClinicalTrial = new ClinicalTrial();
		removeClinicalTrial.setNctId(ClinicalTrialId);
		return ClinicalTrialDAO.removeClinicalTrialInfo(removeClinicalTrial);
	}

	// http://localhost:8080/Jersey-Spring-Hibernate/rest/ClinicalTrialservice/getallClinicalTrial
	@GET
	@Path("getallClinicalTrial")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ClinicalTrialListType getAllClinicalTrialInfo() {

		List<ClinicalTrial> lstClinicalTrial = ClinicalTrialDAO.getAllClinicalTrialInfo();

		// create a object of type ClinicalTrialListType which takes ClinicalTrial objects in its list
		ClinicalTrialListType ClinicalTrialListType = new ClinicalTrialListType();

		for(ClinicalTrial ClinicalTrial : lstClinicalTrial){
			ClinicalTrialType ClinicalTrialType = new ClinicalTrialType();
			ClinicalTrialType.setNctId(ClinicalTrial.getNctId());
			ClinicalTrialType.setOfficialTitle(ClinicalTrial.getOfficialtitle());
			ClinicalTrialType.setPhase(ClinicalTrial.getPhase());
			ClinicalTrialType.setPrimarycompletiondate(ClinicalTrial.getPrimaryCompletionDate());
			ClinicalTrialListType.getClinicalTrialType().add(ClinicalTrialType); // add to ClinicalTrialListType
		}
		return ClinicalTrialListType;
	}
}