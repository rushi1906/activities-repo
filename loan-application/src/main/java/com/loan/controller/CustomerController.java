package com.loan.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loan.beans.Customer;
import com.loan.beans.Loan;
import com.loan.beans.LoanApplication;
import com.loan.exceptions.UserNotFoundException;
import com.loan.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	List<String> exceptionList = new ArrayList<String>();
	
	@PostMapping(path = "/register")
	public ResponseEntity<Object> registerCustomer(@RequestBody Customer customer) {
		Customer cust = customerService.registerCustomer(customer);
		return ResponseEntity.status(200).body(cust);
		
	}
	
	
	@PostMapping(path = "/login")
	public ResponseEntity<Object> login(@RequestParam String emailId, @RequestParam String password){
		Customer cust;
		try {
			cust = customerService.login(emailId, password);
			return ResponseEntity.status(200).body(cust);
		}catch(UserNotFoundException e) {
			exceptionList.add(e.getMessage());
			Map<String, String> errors = new HashMap<>();
			errors.put("error", e.getMessage());
			return ResponseEntity.status(404).body(errors);
		}
	}
	
	@GetMapping("/view-Loan")
	public ResponseEntity<Object> getAvailableLoans(){
		List<Loan> cust = customerService.getAvailableLoans();
		return ResponseEntity.status(200).body(cust);
	}
	
	@PostMapping("/apply-loan")
	public ResponseEntity<Object> applyLaon(@RequestParam int loanId, @RequestParam int customerId){
		LoanApplication loanApplication = customerService.applyLoan(loanId, customerId);
		return ResponseEntity.status(200).body(loanApplication);
		
	}
	
	@GetMapping("/loanStatus")
	public ResponseEntity<Object> loanStatus(@RequestParam int applicationId){
		String status = customerService.loanStatus(applicationId);
		return ResponseEntity.status(200).body(status);
		
	}
	
	
	

}
