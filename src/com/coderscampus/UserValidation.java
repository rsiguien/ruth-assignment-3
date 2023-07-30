package com.coderscampus;
import java.util.Scanner;

public class UserValidation {

	public static void main(String[] args) throws Exception{
		Boolean isMatch = false;
		Scanner scanner = new Scanner(System.in);
		int attempts = 0;
		
		while(attempts < 5) {
			System.out.println("Username: ");
			String username = scanner.nextLine();
			System.out.println("Password: ");
			String password = scanner.nextLine();
		
			UserInfoStorage userInfo = new UserInfoStorage(username, password);
			isMatch = userInfo.validateUser();
		
			if(attempts == 4) {
			break;
			}
		
			if(isMatch) {
				System.out.println("User accepted");
				System.out.println("Welcome " + userInfo.getName());
				break;
			} else {
				System.out.println("Invalid login, please try again.");
			}
		attempts++;
		}
		
		if(attempts == 4) {
			System.out.println("Too many failed login attempts, you are now locked out.");
		}
		scanner.close();
	}

}
