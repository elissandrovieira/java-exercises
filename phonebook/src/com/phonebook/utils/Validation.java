package com.phonebook.utils;

public class Validation {
    public static long phoneNumber(String strNum){

        if (strNum.matches("\\(?\\d{2}\\)?\\s?\\d{4,5}-?\\d{4}")) {
            strNum = strNum.replaceAll("\\D", "");
            if (strNum.length() == 10 || strNum.length() == 11)
                return (Long.parseLong(strNum));
        }
        return -1;
    }

    public static boolean email(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+[a-zA-Z]{2,}");
    }
}
