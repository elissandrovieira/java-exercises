package com.phonebook;

import java.util.Scanner;
import com.phonebook.utils.Utils;
import com.phonebook.model.Contact;
import com.phonebook.utils.Validation;

public class Main {
	public static void main(String[] args) {
        boolean isOk = false;
		Scanner scan = new Scanner(System.in);
		String name = "";

		Utils.clearConsole();
        while (!isOk) {
            System.out.println("--- Phonebook ---");
            System.out.println("Write the contact name:");
            name = scan.nextLine();
            if (name.isEmpty()) {
				Utils.clearConsole();
				System.out.println("Name is empty!");
				Utils.Delay();
			}
            else
                isOk = true;
			Utils.clearConsole();
        }

        isOk = false;
        long number = 0;

        while (!isOk) {
            System.out.println("--- Phonebook ---");
            System.out.println("Write the phone number:");
            String numberStr = scan.nextLine();
            number = Validation.phoneNumber(numberStr);
            if (number == -1) {
				Utils.clearConsole();
				System.out.println("Phone number is incorrect \nUse the pattern: (00) 00000-0000");
				Utils.Delay();
			}
            else
                isOk = true;
            Utils.clearConsole();
        }

        isOk = false;
		String email = "";

        while (!isOk) {
            System.out.println("--- Phonebook ---");
            System.out.println("Write the E-mail adress:");
            email = scan.nextLine();
            if (!Validation.email(email)) {
				Utils.clearConsole();
				System.out.println(
					"Invalid email.\nMake sure it includes \"@\" and a domain (e.g., example@domain.com)."
				);
				Utils.Delay();
			}
            else
                isOk = true;
            Utils.clearConsole();

        }

        Contact contact = new Contact(name, number, email);

        System.out.println("--- Phonebook ---");
        System.out.printf("Name: %s\nPhone number: %d\nE-mail: %s%n", contact.getName(), contact.getPhoneNumber(), contact.getEmail());
    }
}
