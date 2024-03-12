package com.venu.insurance.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.venu.insurance.model.CitizenPlans;
import com.venu.insurance.repo.CitizenPlansRepo;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerator {
	@Autowired
	private CitizenPlansRepo citizenPlansRepo;
	
	public void pdfExport(HttpServletResponse response,File f) throws DocumentException, IOException {

		// Creating the Object of Document
				Document document = new Document(PageSize.A4);
				
				// Getting instance of PdfWriter
				PdfWriter.getInstance(document, response.getOutputStream());
				PdfWriter.getInstance(document, new FileOutputStream(f));
				
				// Opening the created document to modify it
				document.open();

				// Creating font
				// Setting font style and size
				Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
				Paragraph paragraph = new Paragraph("List Of Students", fontTiltle);
				document.add(paragraph);
				
				// Creating a table of 3 columns
				PdfPTable table = new PdfPTable(6);
				// Setting width of table, its columns and spacing
				table.addCell("Id");
				table.addCell("Citizen Name");
				table.addCell("Plan Name");
				table.addCell("Plan Status");
				table.addCell("Plan End Date");
				table.addCell("Plan Start Date");
				table.addCell("Benefit amt");
				
				List<CitizenPlans> bo = citizenPlansRepo.findAll();
				for(CitizenPlans plan: bo) {
					table.addCell(plan.getCitizenId().toString());
					table.addCell(plan.getCitizenName());
					table.addCell(plan.getCitizenPlan());
					table.addCell(plan.getCitizenSratus());
					table.addCell(plan.getPlanStartDate()+ "");
					table.addCell(plan.getPlanEndDate() + "");
					table.addCell(plan.getBenifitAmt()+ "");
				}

				document.add(table);
				document.close();

				
				
				
		
	
		
	}
	

}
