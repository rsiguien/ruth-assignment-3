package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileService {

	public UserPojo[] readData() throws Exception {
		BufferedReader fileReader = null;
		UserPojo[] users = new UserPojo[4];
		try { 
			fileReader = new BufferedReader(new FileReader("data.txt"));
			String line = "";
			int i = 0;
			while ((line = fileReader.readLine()) != null) {
				String[] stringArray = line.split(",");
				String username = stringArray[0];
				String password = stringArray[1];
				String name = stringArray[2];
		
				UserPojo user = new UserPojo(username, password, name);
				users[i] = user;
				i++;
			}
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		finally {
			fileReader.close();
		}
		return users;
	}
}
