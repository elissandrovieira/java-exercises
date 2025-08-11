package com.phonebook.cli;

import com.phonebook.model.Contact;
import com.phonebook.service.ContactService;
import com.phonebook.utils.PrintUtils;
import com.phonebook.utils.Utils;
import com.phonebook.utils.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static Scanner scan;
    private static int sizeLine;


    public Menu(Scanner scan, int sizeLine) {
        this.scan = scan;
        this.sizeLine = sizeLine;
    }

    private static void InvalidOption(String title, List<String> textList) {
        title = title == null ? "Invalid option" : title;
        textList = textList == null ? List.of("Insert a valid option") : textList;
        Utils.clearConsole();
        PrintUtils.PrintBox(title, textList, sizeLine);
        Utils.Delay();
    }

    private static void ContactDetails(Contact contact) {
        while(true) {
            Utils.clearConsole();
            PrintUtils.PrintBox("Contact details", List.of(
                    "Name: " + contact.getName(),
                    "Phone Number: " + contact.getPhoneNumber(),
                    "E-mail: " + contact.getEmail(),
                    " ",
                    "0. Return"
            ), sizeLine);

            String input = scan.nextLine();
            if (input.chars().allMatch(Character::isDigit) && Integer.parseInt(input) == 0)
                break;
        }
    }

    private static void AllContacts(String title, List<Contact> contacts) {
        List<String> contactNames = new ArrayList<>();

        int i = 0;
        for (Contact contact : contacts)
            contactNames.add(String.format("%d. %s", ++i, contact.getName()));
        contactNames.add("0. Back to Main Menu");

        while (true) {
            Utils.clearConsole();
            PrintUtils.PrintBox(title, contactNames, sizeLine);
            int input = Integer.parseInt(scan.nextLine());
            if (input == 0)
                break;
            else if (input <= i) {
                ContactDetails(contacts.get(input - 1));
            } else
                InvalidOption(null, null);
        }
    }

    private static void SearchContact(String title) {
        boolean exitSearch = false;

        while (!exitSearch) {
            Utils.clearConsole();
            PrintUtils.PrintBox("Search Contact", List.of(
                    "Search by:",
                    " ",
                    "1. Name",
                    "2. Phone Number",
                    "3. Email",
                    "0. Back to Main Menu"
            ), sizeLine);
            String input = scan.nextLine();
            String info = null;

            List<Contact> contacts = new ArrayList<>();
            switch (input) {
                case "1":
                    Utils.clearConsole();
                    PrintUtils.PrintBox(title, List.of("Type here:"), sizeLine);
                    info = scan.nextLine();
                    contacts = ContactService.getContacts(info, ContactService.InfoType.NAME);
                    break;

                case "2":
                    Utils.clearConsole();
                    PrintUtils.PrintBox(title, List.of("Type here:"), sizeLine);
                    info = scan.nextLine();
                    contacts = ContactService.getContacts(info, ContactService.InfoType.NUMBER);
                    break;

                case "3":
                    Utils.clearConsole();
                    PrintUtils.PrintBox(title, List.of("Type here:"), sizeLine);
                    info = scan.nextLine();
                    contacts = ContactService.getContacts(info, ContactService.InfoType.EMAIL);
                    break;

                case "0":
                    exitSearch = true;
                    break;

                default:
                    InvalidOption(null, null);
                    break;
            }
            if (contacts.size() > 1)
                AllContacts("Select contact", contacts);
            else if (!(contacts.isEmpty()))
                ContactDetails(contacts.getFirst());
            else if (!(input.equals("0")))
                InvalidOption("Invalid contact", List.of("Insert a valid contact"));
        }
    }

    private static String AddField(String title, List<List<String>> textList, ContactService.InfoType type) {
        boolean fieldIsEntered = false;
        String validField = null;

        while(!fieldIsEntered) {
            Utils.clearConsole();
            PrintUtils.PrintBox(title, textList.getFirst(), sizeLine);
            String field = scan.nextLine();

            validField = Validation.InfoValidation(field, type);
            if (validField == null)
                InvalidOption(title, textList.get(1));
            else {
                String answer = null;
                while (answer == null) {
                    Utils.clearConsole();
                    PrintUtils.PrintBox(title, List.of(
                            "Confirm data inserted:",
                            validField, " ",
                            "1. Confirm",
                            "0. Cancel"
                    ), sizeLine);
                    answer = scan.nextLine();
                    switch (answer) {
                        case "1":
                            fieldIsEntered = true;
                            break;
                        case "0":
                            answer = null;
                            break;
                        default:
                            answer = null;
                            InvalidOption(title, null);
                            break;
                    }
                }
            }
        }
        return validField;
    }

    private static void AddContact(String title) {
        List<List<String>> nameList = List.of(
                List.of("Insert the contact Name:", " ", "0. Back to Main Menu"),
                List.of("Name is empty!", "Type a valid name")
        );
        String name = AddField(title, nameList, ContactService.InfoType.NAME);

        List<List<String>> numberList = List.of(
                List.of("Insert the contact Number:", " ", "0. Back to Main Menu"),
                List.of("Invalid number!", "Use the pattern: (00) 00000-0000")
        );
        String number = AddField(title, numberList, ContactService.InfoType.NUMBER);

        List<List<String>> emailList = List.of(
                List.of("Insert the contact E-mail:", " ", "0. Back to Main Menu"),
                List.of("Invalid email!", "Make sure it includes @",
                        "And a domain (e.g., example@domain.com)")
        );
        String email = AddField(title, emailList, ContactService.InfoType.EMAIL);

        ContactService.setContact(new Contact(name, number, email));

        Utils.clearConsole();
        PrintUtils.PrintBox(title, List.of("Contact Saved"), sizeLine);
        Utils.Delay();
    }

    private static void EditContact(String title) {
        Utils.clearConsole();
        System.out.println("Edit contact");
    }

    private static void DeleteContact() {
        Utils.clearConsole();
        System.out.println("Delete contact");
    }

    public static void MainMenu() {

        boolean exitProgram = false;

        while (!exitProgram) {
            Utils.clearConsole();
            PrintUtils.PrintBox("PHONEBOOK", List.of(
                    "1. View all contacts",
                    "2. Search contact",
                    "3. Add new contact",
                    "4. Edit contact",
                    "5. Delete contact",
                    "0. Exit"
            ), sizeLine);
            String input = scan.nextLine();

          switch (input) {
              case "1":
                  AllContacts("All contacts", ContactService.getAllContacts());
                  break;

              case "2":
                  SearchContact("Search Contact");
                  break;

              case "3":
                  AddContact("Add new contact");
                  break;

              case "4":
                  EditContact("Edit contact");
                  break;

              case "5":
                  DeleteContact();
                  break;

              case "0":
                  Utils.clearConsole();
                  exitProgram = true;
                  break;

              default:
                  InvalidOption(null, null);
          }
      }
    }

}
