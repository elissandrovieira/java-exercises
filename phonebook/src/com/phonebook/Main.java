package com.phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.phonebook.cli.Menu;
import com.phonebook.service.ContactService;
import com.phonebook.utils.Utils;
import com.phonebook.model.Contact;
import com.phonebook.utils.Validation;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//        boolean isOk = false;
//		String name = "";
//
//		Utils.clearConsole();
//        while (!isOk) {
//            System.out.println("--- Phonebook ---");
//            System.out.println("Write the contact name:");
//            name = scan.nextLine();
//            if (name.isEmpty()) {
//				Utils.clearConsole();
//				System.out.println("Name is empty!");
//				Utils.Delay();
//			}
//            else
//                isOk = true;
//			Utils.clearConsole();
//        }
//
//        isOk = false;
//        String number = "";
//
//        while (!isOk) {
//            System.out.println("--- Phonebook ---");
//            System.out.println("Write the phone number:");
//            String numberStr = scan.nextLine();
//            number = Validation.phoneNumber(numberStr);
//            if (number == null) {
//				Utils.clearConsole();
//				System.out.println("Phone number is incorrect \nUse the pattern: (00) 00000-0000");
//				Utils.Delay();
//			}
//            else
//                isOk = true;
//            Utils.clearConsole();
//        }
//
//        isOk = false;
//		String email = "";
//
//        while (!isOk) {
//            System.out.println("--- Phonebook ---");
//            System.out.println("Write the E-mail adress:");
//            email = scan.nextLine();
//            if (!Validation.email(email)) {
//				Utils.clearConsole();
//				System.out.println(
//					"Invalid email.\nMake sure it includes \"@\" and a domain (e.g., example@domain.com)."
//				);
//				Utils.Delay();
//			}
//            else
//                isOk = true;
//            Utils.clearConsole();
//
//        }
//
//        Contact contact = new Contact(name, number, email);
//        ContactService.setContact(contact);
//
//        System.out.println("--- Phonebook ---");
//        System.out.println("Show contacts?(Y/N)");
//        String answer = scan.nextLine();
//
//        if (answer.equals("Y")) {
//            List<Contact> allContacts = ContactService.getAllContacts();
//            System.out.println(allContacts.get(3));
//            for (Contact item : allContacts) {
//                System.out.printf("Name: %s\n", item.getName());
//                System.out.printf("Number: %s\n", item.getPhoneNumber());
//                if (item.getEmail() != null || !(item.getEmail().isEmpty()))
//                   System.out.printf("Name: %s\n\n\n", item.getEmail());
//            }
//        }
        new Menu(scan).MainMenu();
    }
}
