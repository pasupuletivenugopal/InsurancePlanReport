package com.venu.insurance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.venu.insurance.model.CitizenPlans;
@Repository
public interface CitizenPlansRepo extends JpaRepository<CitizenPlans, Long> {
	
	@Query("select distinct(citizenPlan) from CitizenPlans")
	public List<String> getAllPlanNames();
	
	@Query("select distinct(citizenSratus) from CitizenPlans")
	public List<String> getAllPlanStatus();
	
	
	public List<CitizenPlans> findAll();

}
