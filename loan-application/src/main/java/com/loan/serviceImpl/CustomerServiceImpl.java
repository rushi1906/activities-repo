package com.loan.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.Dao.CustomerDao;
import com.loan.Dao.LoanApplicationDao;
import com.loan.Dao.LoanDao;
import com.loan.beans.Customer;
import com.loan.beans.Loan;
import com.loan.beans.LoanApplication;
import com.loan.exceptions.UserNotFoundException;
import com.loan.service.CustomerService;

import jakarta.transaction.Transactional;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private LoanDao loanDao;
	
	
	@Autowired
	private LoanApplicationDao loanApplicationDao;
//	private LaonAppDao loanAppDao;
//	
//	Customer customer = new Customer();

	@Override
	@Transactional
	public Customer registerCustomer(Customer customer) {		
		return customerDao.save(customer);
	}

	@Override
	public Customer login(String emailId, String password)  throws UserNotFoundException{
		Customer cust = customerDao.findByEmailId(emailId);
		
		if(cust != null && cust.getPassword().equals(password)) {
			return cust;
		}
		throw new UserNotFoundException("Unautorize User");
	}

	@Override
	public List<Loan> getAvailableLoans() {
		
		 return loanDao.findAll();	        
	}

	@Override
	public LoanApplication applyLoan(int loanId, int customerId) {
		LoanApplication loanApplication = new LoanApplication();
		loanApplication.setCustomerId(customerId);
		loanApplication.setLoanId(loanId);
		loanApplication.setStatus("Pending");
		return loanApplicationDao.save(loanApplication);
	}

	@Override
	public String loanStatus(int applicationId) {
		return loanApplicationDao.findById(applicationId).get().getStatus();
	}

	

	


		
		 
}
