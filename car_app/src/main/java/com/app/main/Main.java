package com.app.main;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.exception.BusinessException;
import com.app.model.Car;
import com.app.model.Loan;
import com.app.model.Offer;
import com.app.model.Payment;
import com.app.model.User;
import com.app.service.CustomerService;
import com.app.service.EmployeeService;
import com.app.service.UserService;
import com.app.service.impl.CustomerServiceImpl;
import com.app.service.impl.EmployeeServiceImpl;
import com.app.service.impl.UserServiceImpl;

public class Main {
	
	
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		
		UserService userService = new UserServiceImpl();
		EmployeeService employeeServiceImpl = new EmployeeServiceImpl();
		CustomerService customerServiceImpl = new CustomerServiceImpl();
		
		//setting up scanner
		Scanner scanner = new Scanner(System.in);
		
		//instantiating class variables
		String firstName = "";
		String lastName = "";
		String email = "";
		String password = "";
		int userId = 0;
		String type = "";
		String make = "";
		String model = "";
		int carId = 0;
		int offerId = 0;
		int employeeMenu = 0;
		int customerMenu = 0;
		float amount = 0;
		User user = null;

		
		System.out.println("Welcome to the Car App.");
		
		//instantiate variable for menu options
		int menu1 = 0;
		
		
		//set up do while loop for menu 1
		do {
			System.out.println("1) Log In");
			System.out.println("2) Register for a new account.");

			//asking user for information
			try {
				menu1 = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
			}
			
			switch(menu1) {
			case 1: System.out.println("Log In");
				
				while(user == null) {
						System.out.println("Please enter your email address.");
						email = scanner.nextLine();
						
					
						System.out.println("Please enter your password.");
						password = scanner.nextLine();
					
						try {
							user = userService.logIn(email, password);
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
						System.out.println("Employee Menu");
						System.out.println("1)View cars");
						System.out.println("2)Add a car");
						System.out.println("3)Remove a car");
						System.out.println("4)View offers");
						System.out.println("5)Accept an offer");
						System.out.println("6)Reject an offer");
						System.out.println("7)View payments");
						System.out.println("8)Exit");
						
						try {
						employeeMenu = scanner.nextInt();
						scanner.nextLine();
						}catch(NumberFormatException e) {		
						}
						
						switch (employeeMenu) {
						
						case 1: System.out.println("View cars");
								//code to service
							try {
								List<Car> carList = employeeServiceImpl.viewCars();
								for(Car cars : carList) {
									System.out.println(cars);
								}
							} catch (BusinessException e) {
								e.printStackTrace();
							}
						break;
						case 2: System.out.println("Add a car");
								while(make.length() == 0) {
								System.out.println("What is the make?");
								make = scanner.nextLine();
										
								}
								while(model.length() == 0) {
								System.out.println("What is the model?");
								model = scanner.nextLine();	
								}
								
								//code to service
								try {
									Car car = employeeServiceImpl.addCar(make, model);
								} catch (BusinessException e) {
									e.printStackTrace();
								}
								
						
						break;
						case 3: System.out.println("Remove a car");
								carId = 0;
								while(carId == 0) {
								System.out.println("Please enter car Id");
								carId = scanner.nextInt();
								//code to service
								try {
									employeeServiceImpl.removeCar(carId);
								} catch (BusinessException e) {
									e.printStackTrace();
								}	
								}
						
						break;
						case 4: System.out.println("View offers");
								//code to service
							try {
								List<Offer> offerList = employeeServiceImpl.viewOffers();
								for(Offer offers : offerList) {
									System.out.println(offers);
								}
							} catch (BusinessException e) {
								e.printStackTrace();
							}
						
						break;
						case 5: System.out.println("Accept an offer");
								//resetting offerId back to 0 in case it was already assigned a value
								offerId = 0;
								while(offerId <= 0) {
								System.out.println("Please enter the offer Id");
								offerId = scanner.nextInt();
								//code to service
								try {
									employeeServiceImpl.acceptOffer(offerId);
								} catch (BusinessException e) {
									e.printStackTrace();
								}
								}
						
						break;
						case 6: System.out.println("Reject an offer");
								//reseting offerId back to 0 in case it was already assigned a value
								offerId = 0;
								while(offerId <= 0) {
								System.out.println("Please enter the offer Id");
								offerId = scanner.nextInt();
								//code to service
								try {
									employeeServiceImpl.rejectOffer(offerId);
								} catch (BusinessException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								}
						
						break;
						case 7: System.out.println("View payments");
								//code to service
							try {
								List<Loan> loanList = employeeServiceImpl.viewPayments();
								for(Loan loan : loanList) {
									System.out.println(loanList);
								}
							} catch (BusinessException e) {
								e.printStackTrace();
							}
						
						break;
						case 8: System.out.println("Exit");
							user = null;
							password = null;
						break;
						default: System.out.println("Please choose a valid option");
						
						}
					}while(employeeMenu != 8);
					
				}if(type.equals("customer")) {
				
					do {
						System.out.println("Customer Menu");
						System.out.println("1)View open cars");
						System.out.println("2)Make an offer");
						System.out.println("3)View owned cars");
						System.out.println("4)View remaining payments");
						System.out.println("5)Make a payment");
						System.out.println("6)Exit");
						
						
						try {
						customerMenu = scanner.nextInt();
						}catch(NumberFormatException e) {
							System.out.println("Please enter a valid number.");
						}
						
						switch(customerMenu) {
						
						case 1: System.out.println("View open cars");
						//code to service
							try {
								List<Car> carList = customerServiceImpl.viewOpenCars();
								for(Car car : carList) {
									System.out.println(car);
								}
							} catch (BusinessException e) {
								e.printStackTrace();
							}
						
						break;
						case 2: System.out.println("Make an offer");

						//making carId equal to zero in case it was used before
						carId = 0;

						while(carId <= 0) {
							//userId was already found so no need to get it again
							
							System.out.println("Please enter the car ID");
							carId = scanner.nextInt();
							
							System.out.println("Please enter an amount");
							amount = scanner.nextFloat();
							//code to service
							try {
								int makeOffer = customerServiceImpl.makeOffer(userId, carId, amount);
							} catch (BusinessException e) {
								e.printStackTrace();
							}
						}
							
						break;
						case 3: System.out.println("View owned cars");
						//already found userid so no need to get it again
						//code to service
							try {
								List<Car> carList = customerServiceImpl.viewOwnedCars(userId);
								for(Car car : carList) {
									System.out.println(car);
								}
							} catch (BusinessException e) {
								e.printStackTrace();
							}
						
						break;
						case 4: System.out.println("View remaining payments");
						//code to service
							try {
								List<Loan> loanList = customerServiceImpl.viewRemainingPayments(userId);
								for(Loan loan : loanList) {
									System.out.println(loan);
								}
							} catch (BusinessException e) {
								e.printStackTrace();
							}
							
						break;
						case 5: System.out.println("Make a payment");
								System.out.println("Please choose a car to make a payment on.");
								carId = scanner.nextInt();
								int makePayment = customerServiceImpl.makePayment(userId, carId);
						
						break;
						case 6: System.out.println("Exit");
						user = null;
						password = null;
						
						break;
						default: System.out.println("Please enter a valid option");
						}
					}while(customerMenu != 6);
			
					}
			break;
			case 2: System.out.println("Create a new account.");
					firstName = "";
					lastName = "";
					email = "";
					password = "";
					
						while(firstName == "") {
							System.out.println("Please enter your first name.");
							firstName = scanner.nextLine();
							
						}
					
						while(lastName == "") {
							System.out.println("Please enter your last name.");
							lastName = scanner.nextLine();
						}
					
						while(email == "") {
							System.out.println("Please enter your email address.");
							email = scanner.nextLine();
						}
					
						while(password == "") {
							System.out.println("Please enter a new password.");
							password = scanner.nextLine();
						}
						
						try {
							User newUser = userService.createAccount(firstName, lastName, email, password);
						} catch (BusinessException e) {
							e.printStackTrace();
						}
					
			break;
			default:System.out.println("Invalid option");
			break;
			}
	
		}while(menu1 != 3);
		scanner.close();
}
}