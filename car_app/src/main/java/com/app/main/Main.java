package com.app.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class Main {
	
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
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
			
			
			
			
			
			
				
		}while(menu1 != 3);
}
}