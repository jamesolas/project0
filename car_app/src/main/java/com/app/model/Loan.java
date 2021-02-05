package com.app.model;

public class Loan {
	
	private int loanId;
	private float purchasePrice;
	private float principal;
	private float interest;
	private int userId;
	private String firstName;
	private String lastName;
	private int carId;
	private String make;
	private String model;
	private int paymentsRemaining;
	private float paymentAmount;
	
	public Loan() {
		super();
	}

	public Loan(int loanId, float purchasePrice, float principal, float interest, int userId, String firstName,
			String lastName, int carId, String make, String model, int paymentsRemaining, float paymentAmount) {
		super();
		this.loanId = loanId;
		this.purchasePrice = purchasePrice;
		this.principal = principal;
		this.interest = interest;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.carId = carId;
		this.make = make;
		this.model = model;
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

	public float getPrincipal() {
		return principal;
	}

	public void setPrincipal(float principal) {
		this.principal = principal;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
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
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + Float.floatToIntBits(interest);
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + loanId;
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + Float.floatToIntBits(paymentAmount);
		result = prime * result + paymentsRemaining;
		result = prime * result + Float.floatToIntBits(principal);
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
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (Float.floatToIntBits(interest) != Float.floatToIntBits(other.interest))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (loanId != other.loanId)
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (Float.floatToIntBits(paymentAmount) != Float.floatToIntBits(other.paymentAmount))
			return false;
		if (paymentsRemaining != other.paymentsRemaining)
			return false;
		if (Float.floatToIntBits(principal) != Float.floatToIntBits(other.principal))
			return false;
		if (Float.floatToIntBits(purchasePrice) != Float.floatToIntBits(other.purchasePrice))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", purchasePrice=" + purchasePrice + ", principal=" + principal
				+ ", interest=" + interest + ", userId=" + userId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", carId=" + carId + ", make=" + make + ", model=" + model + ", paymentsRemaining="
				+ paymentsRemaining + ", paymentAmount=" + paymentAmount + "]";
	}

	
	
		}
