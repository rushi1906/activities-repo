package com.loan.service;

import java.util.List;

import com.loan.beans.Customer;
import com.loan.beans.Loan;
import com.loan.beans.LoanApplication;
import com.loan.exceptions.UserNotFoundException;

public interface CustomerService {
	
	Customer registerCustomer(Customer customer);
	
	Customer login(String emailId, String password) throws UserNotFoundException;
	
	List<Loan> getAvailableLoans();
	
	LoanApplication applyLoan(int loanId, int customerId);
	
	String loanStatus(int applicationId);
	


}

  