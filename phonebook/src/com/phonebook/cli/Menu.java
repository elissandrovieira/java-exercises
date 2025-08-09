package com.phonebook.cli;

import com.phonebook.model.Contact;
import com.phonebook.utils.Utils;

import java.util.Scanner;

public class Menu {
    public static Scanner scan;

    public Menu(Scanner scan) {
        this.scan = scan;
    }

    public static void AllContacts() {
        Utils.clearConsole();
        System.out.println("All contacts");
    }

    public static void SearchContact() {
        Utils.clearConsole();
        System.out.println("Search contact");
    }

    public static void AddContact() {
        Utils.clearConsole();
        System.out.println("Add contact");
    }

    public static void EditContact() {
        Utils.clearConsole();
        System.out.println("Edit contact");
    }

    public static void DeleteContact() {
        Utils.clearConsole();
        System.out.println("Delete contact");
    }

    public static void MainMenu() {
      boolean isValid = false;

      while (!isValid) {
          Utils.clearConsole();
          System.out.println(
                  "╔═══════════════════════════════╗\n" +
                  "║           PHONEBOOK           ║\n" +
                  "╠═══════════════════════════════╣\n" +
                  "║  1. View all contacts         ║\n" +
                  "║  2. Search contact            ║\n" +
                  "║  3. Add new contact           ║\n" +
                  "║  4. Edit contact              ║\n" +
                  "║  5. Delete contact            ║\n" +
                  "║  0. Exit                      ║\n" +
                  "╚═══════════════════════════════╝"
          );

          String input = scan.nextLine();
          switch (input) {
              case "1":
                  AllContacts();
                  isValid = true;
                  isValid = true;
                  break;
              case "2":
                  SearchContact();
                  isValid = true;
                  break;
              case "3":
                  AddContact();
                  isValid = true;
                  break;
              case "4":
                  EditContact();
                  isValid = true;
                  break;
              case "5":
                  DeleteContact();
              case "0":
                  isValid = true;
                  break;
              default:
                  Utils.clearConsole();
                  System.out.println("Type a valid option");
                  Utils.Delay();
                  break;
          }
      }
    }

}
