package com.loan.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.loan.beans.Customer;

@Repository 
public interface CustomerDao  extends JpaRepository<Customer, Integer>{

	@Query("select e from Customer e where e.emailId =?1")
	Customer findByEmailId(String emailId);
	
	

}
