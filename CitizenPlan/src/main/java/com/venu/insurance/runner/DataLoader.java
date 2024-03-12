package com.venu.insurance.runner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.venu.insurance.model.CitizenPlans;
import com.venu.insurance.repo.CitizenPlansRepo;
@Component
public class DataLoader implements ApplicationRunner{
	
	@Autowired
	CitizenPlansRepo citizenPlansRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//cash plan data
		CitizenPlans cl = new CitizenPlans();
		cl.setCitizenName("john");
		cl.setGender("male");
		cl.setCitizenPlan("cash");
		cl.setCitizenSratus("approved");
		cl.setPlanStartDate(new Date());
		cl.setPlanEndDate(new Date());
		cl.setBenifitAmt(5000.00);
		
			CitizenPlans c2 = new CitizenPlans();
		c2.setCitizenName("smith");
		c2.setGender("male");
		c2.setCitizenPlan("cash");
		c2.setCitizenSratus("Denied");
		c2.setDenaidReason("due to rent");
		
		CitizenPlans c3 = new CitizenPlans();
		c3.setCitizenName("venu");
		c3.setGender("male");
		c3.setCitizenPlan("cash");
		c3.setCitizenSratus("Termaniated");
		c3.setTerminationReason("he got job");
		c3.setPlanStartDate(new Date());
		c3.setPlanEndDate(new Date());
		c3.setBenifitAmt(5000.00);
		//food
		CitizenPlans c4 = new CitizenPlans();
		c4.setCitizenName("sai");
		c4.setGender("male");
		c4.setCitizenPlan("food");
		c4.setCitizenSratus("approved");
		c4.setPlanStartDate(new Date());
		c4.setPlanEndDate(new Date());
		c4.setBenifitAmt(5000.00);
		
			CitizenPlans c5 = new CitizenPlans();
		c5.setCitizenName("reka");
		c5.setGender("female");
		c5.setCitizenPlan("food");
		c5.setCitizenSratus("Denied");
		c5.setDenaidReason("due to rent");
		
		//medical
		CitizenPlans c6 = new CitizenPlans();
		c6.setCitizenName("suresh");
		c6.setGender("male");
		c6.setCitizenPlan("medical");
		c6.setCitizenSratus("approved");
		c6.setPlanStartDate(new Date());
		c6.setPlanEndDate(new Date());
		c6.setBenifitAmt(5000.00);
		
			CitizenPlans c7 = new CitizenPlans();
		c7.setCitizenName("bot");
		c7.setGender("female");
		c7.setCitizenPlan("medical");
		c7.setCitizenSratus("Denied");
		c7.setDenaidReason("due to rent");
		
		List<CitizenPlans> list = Arrays.asList(cl,c2,c3,c4,c5,c6,c7);
		citizenPlansRepo.saveAll(list);
	}

}
