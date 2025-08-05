package com.phonebook.model;

public class Contact {
	private final String name;
	private final long phoneNumber;
	private String email;

	public Contact(String name, long phoneNumber, String email) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Contact(String name, long phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		if (email == null || email.isEmpty())
			return("E-mail not registred.");
		return email;
	}
}
