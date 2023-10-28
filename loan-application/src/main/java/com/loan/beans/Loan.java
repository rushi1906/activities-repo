package com.loan.beans;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private int loanId;

    @Column(name = "loan_type")
    private String loanType;

	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Loan(int loanId, String loanType) {
		super();
		this.loanId = loanId;
		this.loanType = loanType;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", loanType=" + loanType + "]";
	}

    // Constructors, getters, and setters
    
}
