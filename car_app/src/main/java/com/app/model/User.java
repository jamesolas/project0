package com.app.model;

public class User {
	private int customerid;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String type;
	
	
	public User() {
		super();
	}

	

	public User(String email, String password, String type) {
		super();
		this.email = email;
		this.password = password;
		this.type = type;
	}



	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}



	public User(int customerid, String firstname, String lastname, String email, String password, String type) {
		super();
		this.customerid = customerid;
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
		this.password = password;
		this.type = type;
	}
	
	


	public User(String firstname, String lastname, String email, String password, String type) {
		super();
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
		this.password = password;
		this.type = type;
	}


	public User(String firstname, String lastname, String email, String password) {
		super();
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
		this.password = password;
	}


	public User(int customerid, String email, String password, String type) {
		super();
		this.customerid = customerid;
		this.email = email;
		this.password = password;
		this.type = type;
	}


	public int getCustomerid() {
		return customerid;
	}


	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastname) {
		this.lastName = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerid;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		User other = (User) obj;
		if (customerid != other.customerid)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [customerid=" + customerid + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", type=" + type + "]";
	}

	

}
