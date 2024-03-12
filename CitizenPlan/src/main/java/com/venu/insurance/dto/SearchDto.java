package com.venu.insurance.dto;

public class SearchDto {
	
	private String planNAme;
	private String planStatus;
	private String gender;
	
	private String startDate;
	private String endDate;
	public String getPlanNAme() {
		return planNAme;
	}
	public void setPlanNAme(String planNAme) {
		this.planNAme = planNAme;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	

}
