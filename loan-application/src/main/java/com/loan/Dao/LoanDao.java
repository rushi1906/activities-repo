package com.loan.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loan.beans.Loan;

public interface LoanDao extends JpaRepository<Loan, Integer>{

}
