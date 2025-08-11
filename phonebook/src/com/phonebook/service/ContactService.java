package com.phonebook.service;

import com.phonebook.model.Contact;
import com.phonebook.utils.CsvUtils;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private static final String path = "resources/contacts.csv";

    public enum InfoType {
        NAME,
        NUMBER,
        EMAIL
    }
    public static void setContact(Contact contact) {
        String name = contact.getName();
        String number = contact.getPhoneNumber();
        String email = (contact.getEmail() == null) ? "" : contact.getEmail();

        CsvUtils.WriteCsv(String.format("%s,%s,%s", name, number, email), path, true);
    }

    public static List<Contact> getAllContacts() {
        List<Contact> contacts= new ArrayList<>();

        for (String item : CsvUtils.ReadCsv(path).split("\n")) {
            Contact contact = new Contact(item.split(","));
            contacts.add(contact);
        }

        return contacts;
    }

    public static List<Contact> getContacts(String info, InfoType infoType) {
        List<Contact> contacts = getAllContacts();
        List<Contact> filteredContacts = new ArrayList<>();

        for (Contact item : contacts) {
            switch (infoType) {
                case InfoType.NAME:
                    if (item.getName().equalsIgnoreCase(info)) {
                        filteredContacts.add(item);
                    }
                    break;

                case InfoType.NUMBER:
                    if (item.getPhoneNumber().equalsIgnoreCase(info))
                        filteredContacts.add(item);
                    break;

                case InfoType.EMAIL:
                    if (item.getEmail().equalsIgnoreCase(info))
                        filteredContacts.add(item);
                    break;
            }
        }

        return filteredContacts;
    }

    public static void UpdateContact(Contact contact, InfoType type) {
        List<Contact> contacts = getAllContacts();

        int i = 0;
        for (Contact item : contacts) {
            switch (type) {
                case InfoType.NAME:
                    if (item.getPhoneNumber().equalsIgnoreCase(contact.getPhoneNumber())
                    && item.getEmail().equalsIgnoreCase(item.getEmail()))
                        item.setName(contact.getName());
                    break;

                case InfoType.NUMBER:
                    if (item.getName().equalsIgnoreCase(contact.getName())
                            && item.getEmail().equalsIgnoreCase(item.getEmail()))
                        item.setPhoneNumber(contact.getPhoneNumber());
                    break;

                case InfoType.EMAIL:
                    if (item.getPhoneNumber().equalsIgnoreCase(contact.getPhoneNumber())
                            && item.getName().equalsIgnoreCase(item.getName()))
                        item.setEmail(contact.getEmail());
                    break;
            }

            boolean append = i != 0;

            CsvUtils.WriteCsv(
                    String.format(
                            "%s,%s,%s",
                            item.getName(),
                            item.getPhoneNumber(),
                            item.getEmail()
                    ),
                    path, append);
            i++;
        }

    }

    public static void DeleteContact(Contact contact) {
        List<Contact> contacts = getAllContacts();

        int i = 0;
       for (Contact item :contacts) {
           if (!item.getName().equalsIgnoreCase(contact.getName())
                   && !item.getPhoneNumber().equalsIgnoreCase(contact.getPhoneNumber())
                   && !item.getEmail().equalsIgnoreCase(contact.getEmail())
           ) {
               boolean append = i != 0;
               CsvUtils.WriteCsv(
                       String.format(
                               "%s,%s,%s",
                               item.getName(),
                               item.getPhoneNumber(),
                               item.getEmail()
                       ),
                       path, append);
           }
           i++;
       }
    }
}
