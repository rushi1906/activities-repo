package com.loan.beans;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "credit_score")
public class CreditScore {
    @Id
    @Column(name = "pan")
    private String pan;

    @Column(name = "score")
    private int score;

	public CreditScore() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreditScore(String pan, int score) {
		super();
		this.pan = pan;
		this.score = score;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "CreditScore [pan=" + pan + ", score=" + score + "]";
	}

    // Constructors, getters, and setters
    
    
}
