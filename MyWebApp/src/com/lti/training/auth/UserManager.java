package com.lti.training.auth;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
	
		private List<User> users;

		public UserManager() {
			
			users=new ArrayList<User>();
			users.add(new User("majrul","123",true));
			users.add(new User("dinesh","456",true));
			users.add(new User("gaurav","789",true));
		}
		
		public boolean isValid(String username,String password) {
			boolean ch=false;															//Initialization
			for(User u : users) {															//Iterating the users
				if(u.isActive() == true) {  												// If the status is active then this block will be implemented
					if(username.equals(u.getUsername()) && password.equals(u.getPassword())) {
						ch=true;
						break;   																	//to prevent any further checking with data
					}
					else {
						ch=false;
					}
				}	
			} 
			return ch;
			
			/*ALTERNATIVE APPROACH
			 *  for(User user : users)
			 * 		if(user.getUsername().equals(username))
			 * 			if(user.getPassword().equals(password))
			 * 				if(user.isActive())
			 * 					return true;
			 * 		return false;
			 */
		}
		
}
