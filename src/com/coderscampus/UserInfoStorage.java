package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;

public class UserInfoStorage {
	String username;
	String password;
	String name;
	
	UserInfoStorage (String username, String password){
		this.username = username;
		this.password = password;
	}
	
	public Boolean validateUser() throws Exception {
		BufferedReader fileReader = null;
		Boolean flag = false;
		try { 
			fileReader = new BufferedReader(new FileReader("data.txt"));
			String line = "";
			while ((line = fileReader.readLine()) != null) {
				String[] stringArray = line.split(",");
				String username = stringArray[0];
				String password = stringArray[1];
		
				if(username.equalsIgnoreCase(this.username) && password.equals(this.password)) {
					flag = true;
					this.name = stringArray[2];
					break;
				}	
			}
			
		} catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		finally {
			fileReader.close();
		}
		return flag;
	}
	public String getName() {
		return name;
	}
}
