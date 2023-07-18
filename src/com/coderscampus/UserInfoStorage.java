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
				//System.out.println(line);
				String[] strArr = line.split(",");
				String username = strArr[0];
				String password = strArr[1];
		
				
				if(username.equalsIgnoreCase(this.username) && password.equals(this.password)) {
					flag = true;
					this.name = strArr[2];
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
