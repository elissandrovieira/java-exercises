package com.phonebook.utils;

public class Utils {
	public static void clearConsole() {
    		try {
        		if (System.getProperty("os.name").contains("Windows"))
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        		else
					new ProcessBuilder("clear").inheritIO().start().waitFor();
    		}
    		catch (final Exception e)
    		{
        		System.out.println("Error, couldn't clear the screen: " + e.getMessage());
    		}
	}

	public static void Delay() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
