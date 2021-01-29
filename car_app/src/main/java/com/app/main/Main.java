package com.app.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class Main {
	
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String firstName = null;
		String lastName = null;
		String email = null;
		String password = null;
		
		log.info("Welcome to the Car App.");
		
		int menu1 = 0;
		
		do {
			log.info("1) Log In");
			log.info("2) Register for a new account.");
			
			try {
				menu1 = scanner.nextInt();
				scanner.nextLine();
			}catch(NumberFormatException e) {
			}
			
			switch(menu1) {
			case 1: log.info("Log In");
				while(email.length() <= 0) {
					log.info("Please enter your email address.");
					email = scanner.nextLine();
				}
				while(email.length() <= 0) {
					log.info("Please enter your password.");
					password = scanner.nextLine();
				}
				
			
			break;
			case 2: log.info("Create a new account.");
					
						while(firstName.length() <= 0) {
							log.info("Please enter your first name.");
							firstName = scanner.nextLine();
							
						}
					
						while(lastName.length() <= 0) {
							log.info("Please enter your last name.");
							lastName = scanner.nextLine();
						}
					
						while(email == null) {
							log.info("Please enter your email address.");
							email = scanner.nextLine();
						}
					
						while(password == null) {
							log.info("Please enter a new password.");
							password = scanner.nextLine();
						}
					
			break;
			default:log.info("Invalid option");
			}
			
			
			
			
				
		}while(menu1 != 3);
}
}