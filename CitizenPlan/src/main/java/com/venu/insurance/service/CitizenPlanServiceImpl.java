package com.venu.insurance.service;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.venu.insurance.dto.SearchDto;
import com.venu.insurance.model.CitizenPlans;
import com.venu.insurance.repo.CitizenPlansRepo;
import com.venu.insurance.util.EmailUtility;
import com.venu.insurance.util.ExcelGenerator;
import com.venu.insurance.util.PdfGenerator;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CitizenPlanServiceImpl implements CitizenPlanService{
	
	@Autowired
	private CitizenPlansRepo citizenPlansRepo;
	
	@Autowired
	private ExcelGenerator excelGenerator;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private EmailUtility emailUtility;

	@Override
	public List<String> getAllPlans() throws Exception {
	 List<String> bo = citizenPlansRepo.getAllPlanNames();
	 return bo;
	}

	@Override
	public List<String> getAllPlansStatus() throws Exception {
		 List<String> bo = citizenPlansRepo.getAllPlanStatus();
		 return bo;
	}
	
	@Override
	public List<CitizenPlans> getAllData() throws Exception {
		 List<CitizenPlans> bo = citizenPlansRepo.findAll();
		 return bo;
	}

	@Override
	public List<CitizenPlans> handleSearch(SearchDto searchDto) throws Exception {
		 List<CitizenPlans> bo= new ArrayList<CitizenPlans>();
		 CitizenPlans entity = new CitizenPlans();
		 if(searchDto.getPlanNAme() != null && !searchDto.getPlanNAme().isEmpty()) {
			 entity.setCitizenPlan(searchDto.getPlanNAme());
		 }
		 if(searchDto.getPlanStatus() != null && !searchDto.getPlanStatus().isEmpty()) {
			 entity.setCitizenSratus(searchDto.getPlanStatus());
		 }
		 if(searchDto.getGender() != null && !searchDto.getGender().isEmpty()) {
			 entity.setGender(searchDto.getGender());
		 }
		 if(searchDto.getStartDate() != null && !searchDto.getStartDate().isEmpty()) {
			 String sDate = searchDto.getStartDate();
			 DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy");
			 Date date = formatter.parse(sDate);
			 entity.setPlanStartDate(date);
		 }
		 if(searchDto.getEndDate() != null && !searchDto.getEndDate().isEmpty()) {
			 String eDate = searchDto.getEndDate();
			 DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy");
			 Date date = formatter.parse(eDate);
			 entity.setPlanEndDate(date);
		 }
		
			bo = citizenPlansRepo.findAll(Example.of(entity)); 
		 
		 return bo;
	}
	
	@Override
	public boolean exportExacel(HttpServletResponse response) throws Exception{
		File f = new File("plans.xls");
		excelGenerator.geratorExcel(response,f);
		String subject ="Test MAil Subject";
		String body = "<h1>Test Mail Body</h1>";
		String to = "venupasupuleti555@gmail.com";
		
		emailUtility.sendMail(subject, body, to,f);
		f.delete();
		return true;
	}

	@Override
	public void exportPdf(HttpServletResponse response) throws Exception {
		File f = new File("plans.pdf");
		pdfGenerator.pdfExport(response,f);
		String subject ="Test MAil Subject";
		String body = "<h1>Test Mail Body</h1>";
		String to = "venupasupuleti555@gmail.com";
		emailUtility.sendMail(subject, body, to,f);
		f.delete();
		
		
	}

	
	
	
	
	

}
