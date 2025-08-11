package com.phonebook.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

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
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, "An error interrupted the thread", e);
		}
	}
}
