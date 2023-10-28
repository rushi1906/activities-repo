package com.loan.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loan.beans.Employee;
import com.loan.beans.LoanApplication;
import com.loan.exceptions.UserNotFoundException;
import com.loan.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	List<String> exceptionList = new ArrayList<String>();
	
	@PostMapping(path = "/login")
	public ResponseEntity<Object> login(@RequestParam String emailId, @RequestParam String password){
		Employee employee;
		try {
			employee = employeeService.empLogin(emailId, password);
			return ResponseEntity.status(200).body(employee);
		}catch(UserNotFoundException e) {
			exceptionList.add(e.getMessage());
			Map<String, String> errors = new HashMap<>();
			errors.put("error", e.getMessage());
			return ResponseEntity.status(404).body(errors);
		}
	}
	@PutMapping(path = "/update-status")
	public ResponseEntity<Object> updateLoanApp(@RequestParam String status,@RequestParam int customerId,@RequestParam int loanId){
		LoanApplication loanApplication = employeeService.updateLoanApp(status,customerId,loanId);
		return ResponseEntity.status(200).body(loanApplication);	
	}
	
	@GetMapping("/get-score")
	public ResponseEntity<Object> getCreditScore(@RequestParam String pan){
		int score= employeeService.getCreditScore(pan);
		return ResponseEntity.status(200).body(score);
		
	}

	@GetMapping("/get-apllications")
	public ResponseEntity<Object> getallApplications(){
		List<String> str =employeeService.getallApplications();
		return ResponseEntity.status(200).body(str);
		
	}
}
