package com.phonebook.utils;

public class Utils {
	public final static void clearConsole()
	{
    		try
    		{
        		final String os = System.getProperty("os.name");
        
        		if (os.contains("Windows"))
        		{
            			Runtime.getRuntime().exec("cls");
        		}
        		else
        		{
            			Runtime.getRuntime().exec("clear");
        		}
    		}
    		catch (final Exception e)
    		{
        		System.out.println("Error, couldn't clear the screen: " + e.getMessage());
    		}
	}
}
