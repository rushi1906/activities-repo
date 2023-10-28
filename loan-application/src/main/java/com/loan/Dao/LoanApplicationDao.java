package com.loan.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.loan.beans.LoanApplication;

public interface LoanApplicationDao extends JpaRepository<LoanApplication, Integer> {

	@Query("Select c from LoanApplication c where c.customerId=?1 and c.loanId=?2")
	LoanApplication findByCustLoan(int customerId, int loanId);

}
