package com.loan.service;

import java.util.List;

import com.loan.beans.Employee;
import com.loan.beans.LoanApplication;
import com.loan.exceptions.UserNotFoundException;

public interface EmployeeService {
	
	Employee empLogin(String emailId, String password) throws UserNotFoundException;
	
	LoanApplication updateLoanApp( String status, int customerId, int loanId);

	int getCreditScore(String pan);

	List<String> getallApplications();	

}
