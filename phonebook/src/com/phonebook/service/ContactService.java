package com.phonebook.service;

import com.phonebook.model.Contact;
import com.phonebook.utils.CsvUtils;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private static final String path = "resources/contacts.csv";

    public static void setContact(Contact contact) {
        String name = contact.getName();
        String number = contact.getPhoneNumber();
        String email = (contact.getEmail() == null) ? "" : contact.getEmail();

        CsvUtils.WriteCsv(String.format("%s,%s,%s", name, number, email), path);
    }

    public static List<Contact> getAllContacts() {
        List<Contact> contacts= new ArrayList<Contact>();

        for (String item : CsvUtils.ReadCsv(path).split("\n")) {
            Contact contact = new Contact(item.split(","));
            contacts.add(contact);
        }

        return contacts;
    }
}
