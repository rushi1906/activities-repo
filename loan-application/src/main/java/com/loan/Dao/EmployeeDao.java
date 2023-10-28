package com.loan.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loan.beans.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	Employee findByEmailId(String emailId);

}
