package com.venu.insurance.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.venu.insurance.dto.SearchDto;
import com.venu.insurance.model.CitizenPlans;
import com.venu.insurance.service.CitizenPlanService;

import jakarta.servlet.http.HttpServletResponse;
@RequestMapping
public class CitizenPlancontroller {
	
	CitizenPlanService citizenPlanService;
	
	@GetMapping("/getAllPlans")
	public ResponseEntity<?> getAllPlans() throws Exception{
		
		List<String> list = citizenPlanService.getAllPlans();
		if(list != null) {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	public ResponseEntity<?> getAllPlansStatus() throws Exception{
		
		List<String> list = citizenPlanService.getAllPlansStatus();
		if(list != null) {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
		}
		
	}

	
public ResponseEntity<?> getAllData() throws Exception{
		
		List<CitizenPlans> list = citizenPlanService.getAllData();
		if(list != null) {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
		}
		
	}

@PostMapping("/handleSearch")
public ResponseEntity<?> handleSearch(@RequestBody SearchDto searchDto) throws Exception{
	List<CitizenPlans> list = citizenPlanService.handleSearch(searchDto);
	if(list != null) {
		return new ResponseEntity<>(list,HttpStatus.OK);
	}else {
		return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
	}
}
//download excel file
@GetMapping("/excel")
public void excelExport(HttpServletResponse response) throws Exception {
	response.setContentType("application/octet-stream");
	response.setHeader("Content-Disposition", "attachment;filename=plans.xls");
	citizenPlanService.exportExacel(response);
	
}

@GetMapping("/pdf")
public void pdfExport(HttpServletResponse response) throws Exception {
	response.setContentType("application/pdf");
	response.setHeader("Content-Disposition", "attachment;filename=plans.pdf");
	citizenPlanService.exportPdf(response);
	
}
}
