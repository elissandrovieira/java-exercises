package com.phonebook.utils;

import com.phonebook.service.ContactService;

public class Validation {
    public static String phoneNumber(String strNum){

        if (strNum.matches("\\(?\\d{2}\\)?\\s?\\d{4,5}-?\\d{4}")) {
            strNum = strNum.replaceAll("\\D", "");
            if (strNum.length() == 10 || strNum.length() == 11)
                return strNum;
        }
        return null;
    }

    public static boolean email(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+[a-zA-Z]{2,}");
    }

    public static String InfoValidation(String info, ContactService.InfoType type) {
        String validInfo  = null;

        switch (type) {
            case ContactService.InfoType.NAME:
                if (info != null || !(info.isEmpty()))
                    validInfo = info;
                break;

            case ContactService.InfoType.NUMBER:
                validInfo = phoneNumber(info);
                break;

            case ContactService.InfoType.EMAIL:
                if (email(info))
                    validInfo =  info;
                break;
        }
        return validInfo;
    }
}
