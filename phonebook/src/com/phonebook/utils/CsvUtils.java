package com.phonebook.utils;

import com.phonebook.model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CsvUtils {

    public static void WriteCsv(String str, String path) {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(path, true))) {
            buffer.write(str);
            buffer.newLine();
        } catch (IOException e) {
            Logger.getLogger(CsvUtils.class.getName()).log(Level.SEVERE, "An IO error occurred", e);
        }
    }

    public static String ReadCsv(String path) {
        StringBuilder contacts = new StringBuilder();

        try (BufferedReader buffer = new BufferedReader(new FileReader(path))) {
            String tempStr;

            while ((tempStr = buffer.readLine()) != null)
                contacts.append(tempStr + "\n");

        } catch (IOException e) {
            Logger.getLogger(CsvUtils.class.getName()).log(Level.SEVERE, "An IO error occurred", e);
        }

        return contacts.toString();
    }
}
