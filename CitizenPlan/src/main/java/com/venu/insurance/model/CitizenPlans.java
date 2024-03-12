package com.venu.insurance.model;

import java.util.Date;

import javax.annotation.processing.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Table(name ="CITIZEN_PLANS_INFO")
@Entity
@AllArgsConstructor
@Getter
@Setter
public class CitizenPlans {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long citizenId;
	
	private String citizenName;
	
	private String citizenPlan;
	private String citizenSratus;
	private String terminationReason;
	private String denaidReason;
	private Double benifitAmt;
	private String gender;
	private Date planStartDate;
	private Date planEndDate;
	private Date terminatedDate;
	
	public CitizenPlans() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CitizenPlans(Long citizenId, String citizenName, String citizenPlan, String citizenSratus,
			String terminationReason, String denaidReason, Double benifitAmt, String gender, Date planStartDate,
			Date planEndDate,Date terminatedDate) {
		super();
		this.citizenId = citizenId;
		this.citizenName = citizenName;
		this.citizenPlan = citizenPlan;
		this.citizenSratus = citizenSratus;
		this.terminationReason = terminationReason;
		this.denaidReason = denaidReason;
		this.benifitAmt = benifitAmt;
		this.gender = gender;
		this.planStartDate = planStartDate;
		this.planEndDate = planEndDate;
		this.terminatedDate= terminatedDate;
	}
	public Long getCitizenId() {
		return citizenId;
	}
	public void setCitizenId(Long citizenId) {
		this.citizenId = citizenId;
	}
	public String getCitizenName() {
		return citizenName;
	}
	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}
	public String getCitizenPlan() {
		return citizenPlan;
	}
	public void setCitizenPlan(String citizenPlan) {
		this.citizenPlan = citizenPlan;
	}
	public String getCitizenSratus() {
		return citizenSratus;
	}
	public void setCitizenSratus(String citizenSratus) {
		this.citizenSratus = citizenSratus;
	}
	public String getTerminationReason() {
		return terminationReason;
	}
	public void setTerminationReason(String terminationReason) {
		this.terminationReason = terminationReason;
	}
	public String getDenaidReason() {
		return denaidReason;
	}
	public void setDenaidReason(String denaidReason) {
		this.denaidReason = denaidReason;
	}
	public Double getBenifitAmt() {
		return benifitAmt;
	}
	public void setBenifitAmt(Double benifitAmt) {
		this.benifitAmt = benifitAmt;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getPlanStartDate() {
		return planStartDate;
	}
	public void setPlanStartDate(Date planStartDate) {
		this.planStartDate = planStartDate;
	}
	public Date getPlanEndDate() {
		return planEndDate;
	}
	public void setPlanEndDate(Date planEndDate) {
		this.planEndDate = planEndDate;
	}
	public Date getTerminatedDate() {
		return terminatedDate;
	}
	public void setTerminatedDate(Date terminatedDate) {
		this.terminatedDate = terminatedDate;
	}
	
	
	
	
	
	
	

}
