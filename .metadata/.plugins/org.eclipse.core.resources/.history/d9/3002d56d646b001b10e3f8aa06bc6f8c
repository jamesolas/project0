package com.app.model;

public class Loan {
	
	private int loanId;
	private float purchasePrice;
	private float interest;
	private int userId;
	private int carId;
	private int paymentsRemaining;
	private float paymentAmount;
	
	public Loan() {
		super();
	}
	
	

	public Loan(int loanId, float purchasePrice, float interest, int userId, int carId, int paymentsRemaining,
			float paymentAmount) {
		super();
		this.loanId = loanId;
		this.purchasePrice = purchasePrice;
		this.interest = interest;
		this.userId = userId;
		this.carId = carId;
		this.paymentsRemaining = paymentsRemaining;
		this.paymentAmount = paymentAmount;
	}



	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public float getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(float purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public float getInterest() {
		return interest;
	}

	public void setInterest(float interest) {
		this.interest = interest;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public int getPaymentsRemaining() {
		return paymentsRemaining;
	}

	public void setPaymentsRemaining(int paymentsRemaining) {
		this.paymentsRemaining = paymentsRemaining;
	}

	public float getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + carId;
		result = prime * result + Float.floatToIntBits(interest);
		result = prime * result + loanId;
		result = prime * result + Float.floatToIntBits(paymentAmount);
		result = prime * result + paymentsRemaining;
		result = prime * result + Float.floatToIntBits(purchasePrice);
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		if (carId != other.carId)
			return false;
		if (Float.floatToIntBits(interest) != Float.floatToIntBits(other.interest))
			return false;
		if (loanId != other.loanId)
			return false;
		if (Float.floatToIntBits(paymentAmount) != Float.floatToIntBits(other.paymentAmount))
			return false;
		if (paymentsRemaining != other.paymentsRemaining)
			return false;
		if (Float.floatToIntBits(purchasePrice) != Float.floatToIntBits(other.purchasePrice))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", purchasePrice=" + purchasePrice + ", interest=" + interest + ", userId="
				+ userId + ", carId=" + carId + ", paymentsRemaining=" + paymentsRemaining + ", paymentAmount="
				+ paymentAmount + "]";
	}
	
	
		}
