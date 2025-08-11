package com.phonebook.utils;

import java.util.List;

public class PrintUtils {

    private enum lineType {
        OPEN,
        CLOSE,
        MIDDLE,
        TITLE,
        CONTENT,
        EMPTY
    }

    private static int CheckSizeLine(String title, List<String> options, int sizeLine) {

        for (String item : options) {
                if (item.length() >= sizeLine)
                    sizeLine = item.length() + 2;
            }
                if (title.length() >= sizeLine)
                    sizeLine = title.length() + 2;
                return sizeLine;
        }
        private static void PrintLine(String content, lineType type, int sizeLine) {
            int freeSize = sizeLine - content.length();

            switch (type) {
                case OPEN:
                    System.out.print('╔');
                    for (int i = 0; i < sizeLine; i++)
                        System.out.print('═');
                System.out.println('╗');
                break;

            case CLOSE:
                System.out.print('╚');
                for (int i = 0; i < sizeLine; i++)
                    System.out.print('═');
                System.out.println('╝');
                break;

            case MIDDLE:
                System.out.print('╠');
                for (int i = 0; i < sizeLine; i++)
                    System.out.print('═');
                System.out.println('╣');
                break;

            case TITLE:
                System.out.print('║');
                for (int i = 0; i < (freeSize / 2); i++)
                    System.out.print(' ');
                System.out.print(content);
                for (int i = 0; i < ((freeSize / 2) + (freeSize % 2)); i++)
                    System.out.print(' ');
                System.out.println('║');
                break;

            case CONTENT:
                System.out.print("║ " + content);
                for (int i = 0; i < (freeSize - 1); i++)
                    System.out.print(' ');
                System.out.println('║');
                break;

            case EMPTY:
                System.out.print('║');
                for (int i = 0; i < sizeLine; i++)
                    System.out.print(' ');
                System.out.println('║');
        }
    }
    public static void PrintBox(String title, List<String> options, int sizeLine) {

        sizeLine = CheckSizeLine(title,options, sizeLine);
        PrintLine("", lineType.OPEN, sizeLine);
        PrintLine(title.toUpperCase(), lineType.TITLE, sizeLine);
        PrintLine("", lineType.MIDDLE, sizeLine);
        for (String item : options) {
            PrintLine(item, lineType.CONTENT, sizeLine);
        }
        PrintLine("", lineType.CLOSE, sizeLine);
    }
}
