package com.model;

public class User {
	
	private String firstName;
	private String lastName;
	private int contactNumber;
	private Login login;
	
	public User() {
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

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	

	public String getEmailId() {
		return login.getEmailId();
	}

	public void setEmailId(String emailId) {
		login.setEmailId(emailId);
	}

	public String getPassword() {
		return login.getPassword();
	}

	public void setPassword(String password) {
		login.setPassword(password);
	}

	
	
	
}
