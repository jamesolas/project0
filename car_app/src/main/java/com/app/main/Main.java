package com.app.main;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.exception.BusinessException;
import com.app.model.Car;
import com.app.model.User;
import com.app.service.UserService;
import com.app.service.impl.EmployeeServiceImpl;
import com.app.service.impl.UserServiceImpl;

public class Main {
	
	
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		
		UserService userService = new UserServiceImpl();
		EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
		
		//setting up scanner
		Scanner scanner = new Scanner(System.in);
		
		//instantiating class variables
		String firstName = "";
		String lastName = "";
		String email = "";
		String password = "";
		int userId = 0;
		User userLogin = null;
		String type = "";
		String make = "";
		String model = "";
		int carId = 0;
		int offerId = 0;
		int employeeMenu = 0;
		int customerMenu = 0;

		
		log.info("Welcome to the Car App.");
		
		//instantiate variable for menu options
		int menu1 = 0;
		
		
		//set up do while loop for menu 1
		do {
			log.info("1) Log In");
			log.info("2) Register for a new account.");

			//asking user for information
			try {
				menu1 = scanner.nextInt();
				scanner.nextLine();
			}catch(NumberFormatException e) {
			}
			
			switch(menu1) {
			case 1: log.info("Log In");
			
					while(userLogin == null) {
				
						log.info("Please enter your email address.");
						email = scanner.nextLine();
						
					
						log.info("Please enter your password.");
						password = scanner.nextLine();
					
						try {
							userLogin = userService.logIn(email, password);
							} catch (BusinessException e1) {
								e1.printStackTrace();
							}
					}
					
					try {
						type = userService.findType(email);
					} catch (BusinessException e1) {
						e1.printStackTrace();
					}
				
					try {
					userId = userService.findUserId(email);
					} catch (BusinessException e1) {
					e1.printStackTrace();
					}
				
				
				if(type.equals("employee")) {
					
					do {
						log.info("Employee Menu");
						log.info("1)View cars");
						log.info("2)Add a car");
						log.info("3)Remove a car");
						log.info("4)View offers");
						log.info("5)Accept an offer");
						log.info("6)Reject an offer");
						log.info("7)View payments");
						log.info("8)Exit");
						
						try {
						employeeMenu = scanner.nextInt();
						scanner.nextLine();
						}catch(NumberFormatException e) {		
						}
						
						switch (employeeMenu) {
						
						case 1: log.info("View cars");
								//code to service
							try {
								List<Car> carList = employeeServiceImpl.viewCars();
								for(Car cars : carList) {
									log.info(cars);
								}
							} catch (BusinessException e) {
								e.printStackTrace();
							}
						break;
						case 2: log.info("Add a car");
								while(make.length() <= 0) {
								log.info("What is the make?");
								make = scanner.nextLine();
								//code to service
								
								}
								while(model.length() <= 0) {
								log.info("What is the model?");
								model = scanner.nextLine();
								//code to service
								
								}
						
						break;
						case 3: log.info("Remove a car");
								while(carId <= 0) {
								log.info("Please enter car Id");
								carId = scanner.nextInt();
								//code to service
									
								}
						
						break;
						case 4: log.info("View offers");
								//code to service
						
						break;
						case 5: log.info("Accept an offer");
								//reseting offerId back to 0 in case it was already assigned a value
								offerId = 0;
								while(offerId <= 0) {
								log.info("Please enter the offer Id");
								offerId = scanner.nextInt();
								//code to service
								
								}
						
						break;
						case 6: log.info("Reject an offer");
								//reseting offerId back to 0 in case it was already assigned a value
								offerId = 0;
								while(offerId <= 0) {
								log.info("Please enter the offer Id");
								offerId = scanner.nextInt();
								//code to service
								
								}
						
						break;
						case 7: log.info("View payments");
								//code to service
						
						break;
						case 8: log.info("Exit");
						
						break;
						default: log.info("Please choose a valid option");
						
						}
					}while(employeeMenu != 8);
					
				}if(type.equals("customer")) {
				
					do {
						log.info("Customer Menu");
						log.info("1)View open cars");
						log.info("2)Make an offer");
						log.info("3)View owned cars");
						log.info("4)View remaining payments");
						log.info("5)Exit");
						
						try {
						customerMenu = scanner.nextInt();
						}catch(NumberFormatException e) {
							log.info("Please enter a valid number.");
						}
						
						switch(customerMenu) {
						
						case 1: log.info("View open cars");
						//code to service
						
						break;
						case 2: log.info("Make an offer");

						//making carId equal to zero in case it was used before
						carId = 0;

						while(carId <= 0) {
							log.info("Please enter the car ID");
							carId = scanner.nextInt();
							
							log.info("Please enter an amount");
							int amount = scanner.nextInt();
							//code to service
						}
							
						break;
						case 3: log.info("View owned cars");
						//code to service
						
						break;
						case 4: log.info("View remaining payments");
						//code to service
						
						
						break;
						case 5: log.info("Exit");
						
						break;
						default: log.info("Please enter a valid option");
						}
					}while(customerMenu != 5);
			
					}
			break;
			case 2: log.info("Create a new account.");
					
						while(firstName.length() <= 0 || firstName == null) {
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
						
						try {
							User newUser = userService.createAccount(firstName, lastName, email, password);
						} catch (BusinessException e) {
							e.printStackTrace();
						}
					
			break;
			default:log.info("Invalid option");
			}
			
			
			
			
				
		}while(menu1 != 3);
}
}