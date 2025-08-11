package com.phonebook;

import java.util.Scanner;

import com.phonebook.cli.Menu;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

        new Menu(scan, 50).MainMenu();
    }
}
