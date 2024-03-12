package com.venu.insurance.service;

import java.util.List;

import com.venu.insurance.dto.SearchDto;
import com.venu.insurance.model.CitizenPlans;

import jakarta.servlet.http.HttpServletResponse;

public interface CitizenPlanService {

	List<String> getAllPlans() throws Exception;

	List<String> getAllPlansStatus()throws Exception;

	List<CitizenPlans> getAllData()throws Exception;

	List<CitizenPlans> handleSearch(SearchDto searchDto)throws Exception;
	
	public boolean exportExacel(HttpServletResponse response)throws Exception;

	void exportPdf(HttpServletResponse response)throws Exception;

}
