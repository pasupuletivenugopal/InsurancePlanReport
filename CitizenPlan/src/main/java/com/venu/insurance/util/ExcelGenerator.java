package com.venu.insurance.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.venu.insurance.model.CitizenPlans;
import com.venu.insurance.repo.CitizenPlansRepo;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class ExcelGenerator {
	
	@Autowired
	private CitizenPlansRepo citizenPlansRepo;
	public void geratorExcel(HttpServletResponse response,File f) throws IOException{

		
		//HSSFWorkbook this will work for xls format
		//Workbook workBook = new HSSFWorkbook();
		Workbook workBook =new  XSSFWorkbook();
		Sheet sheet = workBook.createSheet("plan-data");
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Citizen Name");
		headerRow.createCell(2).setCellValue("Plan Name");
		headerRow.createCell(3).setCellValue("Plan Status");
		headerRow.createCell(4).setCellValue("Plan End Date");
		headerRow.createCell(5).setCellValue("Plan Start Date");
		headerRow.createCell(6).setCellValue("Benefit amt");
		
		Integer dataRowIndex = 1;
		List<CitizenPlans> bo = citizenPlansRepo.findAll();
		for(CitizenPlans plan :bo) {
			Row dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(plan.getCitizenId());
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(2).setCellValue(plan.getCitizenPlan());
			dataRow.createCell(3).setCellValue(plan.getCitizenSratus());
			dataRow.createCell(4).setCellValue(plan.getPlanStartDate());
			dataRow.createCell(5).setCellValue(plan.getPlanEndDate());
			if(plan.getBenifitAmt() != null) {
			dataRow.createCell(6).setCellValue(plan.getBenifitAmt());
			}else {
				dataRow.createCell(6).setCellValue("N/A");
			}
			dataRowIndex ++;
			
		}
		
		FileOutputStream fos = new FileOutputStream(new File("plans.xls"));
		workBook.write(fos);
		fos.close();
		
	ServletOutputStream outputStream =	response.getOutputStream();
	workBook.write(outputStream);
	workBook.close();
	
	
		
	
	}

}
