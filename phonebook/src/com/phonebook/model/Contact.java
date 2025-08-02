package com.phonebook.model;

public class Contact {
	private String name;
	private int phoneNumber;
	private String email;

	public Contact(String name, int phoneNumber, String email) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Contact(String name, int phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		if (email == null || email.isEmpty())
			return("E-mail not registred.");
		return email;
	}
}
