package com.coderscampus;

import java.util.Scanner;

public class UserLoginApplication {
	
    static int i;

	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		Boolean isMatch = null;
		int attempts = 0;
		UserService userService = new UserService();
		
		while(attempts < 5) {
			System.out.println("Username: ");
			String username = scanner.nextLine();
			System.out.println("Password: ");
			String password = scanner.nextLine();
			UserPojo[] users = userService.readData();
			isMatch = validateUsers(users, new UserPojo(username, password, null));
			
			if(attempts == 4 && !isMatch) {
				System.out.println("Too many login attempts, you are locked out.");
				break;
			}
			if(isMatch) {
				System.out.println("Welcome: " + users[i].getName());
				break;
			} else {
				System.out.println("Invalid login attempt.");
			}
			attempts++;
		}
		scanner.close();
	}
	
	public static Boolean validateUsers(UserPojo[] users, UserPojo myUser) {
		int index=0;
		for(UserPojo user : users) {
			if(user.getUsername().equalsIgnoreCase(myUser.getUsername()) && user.getPassword().equals(myUser.getPassword())) {
				i = index;
				return true;
			}
			index++;
		}
		return false;
	}
}
 









