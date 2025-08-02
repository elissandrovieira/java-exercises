package com.phonebook;

import java.util.Scanner;
import com.phonebook.utils.Utils;
import com.phonebook.model.Contact;

public class Main {
	public static void main(String[] args) {
		System.out.println("--- Phonebook ---");
		System.out.println("Write the contact name:");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		Utils.clearConsole();
		
		System.out.println("--- Phonebook ---");
		System.out.println("Write the phone number:");
		int number = Integer.parseInt(scan.nextLine());
		Utils.clearConsole();

		System.out.println("--- Phonebook ---");
                System.out.println("Write the E-mail adress:");
                String email = scan.nextLine();
                Utils.clearConsole();

		Contact contact = new Contact(name, number, email);

		System.out.println("--- Phonebook ---");
		System.out.println(String.format("Name: %s\nPhone number: %d\nE-mail: %s", name, number, email));
	}
}
