package com.loan.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loan.Dao.CreditScoreDao;
import com.loan.Dao.CustomerDao;
import com.loan.Dao.EmployeeDao;
import com.loan.Dao.LoanApplicationDao;
import com.loan.Dao.LoanDao;
import com.loan.beans.Customer;
import com.loan.beans.Employee;
import com.loan.beans.Loan;
import com.loan.beans.LoanApplication;
import com.loan.exceptions.UserNotFoundException;
import com.loan.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private LoanApplicationDao loanApplicationDao;
	
	@Autowired
	CreditScoreDao creditScoreDao;
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	LoanDao loanDao;

	@Override
	public Employee empLogin(String emailId, String password) throws UserNotFoundException {
		
		Employee employee = employeeDao.findByEmailId(emailId);
		
		if(employee != null && employee.getPassword().equals(password)) {
			return employee;
		}
		throw new UserNotFoundException("Unautorize Customer");
	}

	@Override
	public LoanApplication updateLoanApp(String status, int customerId, int loanId) {
		
		LoanApplication loanApplication=loanApplicationDao.findByCustLoan(customerId,loanId);
		loanApplication.setStatus(status);
		return loanApplicationDao.save(loanApplication);
	}

	@Override
	public int getCreditScore(String pan) {
		
		return creditScoreDao.findById(pan).get().getScore();
	}

	@Override
	public List<String> getallApplications() {
		ObjectMapper objectMapper = new ObjectMapper();
		List<String> list1 = new ArrayList<>();
		for(LoanApplication l :loanApplicationDao.findAll()) {
			
			Customer customer = customerDao.findById(l.getCustomerId()).get();
			Loan loan = loanDao.findById(l.getLoanId()).get();
			try {
			    // Convert the Employee entity to a JSON string
			    String json1 = objectMapper.writeValueAsString(customer);
			    String json2 = objectMapper.writeValueAsString(loan);
			    list1.add(json1);
			    list1.add(json2);
			} catch (Exception e) {
			    e.printStackTrace();
			}
			
		}
		return list1;
		
	}

}
