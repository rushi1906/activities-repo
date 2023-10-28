package com.loan.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loan.beans.CreditScore;

public interface CreditScoreDao extends JpaRepository<CreditScore, String> {

}
