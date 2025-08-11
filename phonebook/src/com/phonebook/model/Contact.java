package com.phonebook.model;

public class Contact {
	private String name;
	private String phoneNumber;
	private String email;

	public Contact(String name, String phoneNumber, String email) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Contact(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = "";
	}

	public Contact(String[] contactStr) {
		this.name = contactStr[0];
		this.phoneNumber = contactStr[1];
		this.email = (contactStr[2] == null) ? "" : contactStr[2];
	}

	public void setName (String name) { this.name = name; }
	public void setPhoneNumber (String phoneNumber) { this.phoneNumber = phoneNumber; }
	public void setEmail (String email) { this.email = email; }

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		if (email == null || email.isEmpty())
			return("E-mail not registered.");
		return email;
	}
}
