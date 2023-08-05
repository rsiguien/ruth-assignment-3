package com.coderscampus;

import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		Boolean isMatch = false;
		int attempts = 0;
		
		while(attempts < 5) {
			System.out.println("Username: ");
			String username = scanner.nextLine();
			System.out.println("Password: ");
			String password = scanner.nextLine();
			
			UserPOJO userInfo = new UserPOJO(username, password);
			isMatch = userInfo.userService();
			
			if(attempts == 4) {
				System.out.println("Too many failed login attempts, you are now locked out.");
				break;
			}
			if(isMatch) {
				System.out.println("Welcome: " + userInfo.getName());
				break;	
			} else {
				System.out.println("Invalid login, please try again.");
			}
			attempts++;
		}
		scanner.close();
	}
}
 









