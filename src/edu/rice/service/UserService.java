package edu.rice.service;

import edu.rice.model.User;

public interface UserService {
	/**
     * Validate the login operation using given email and password. If the validation fails, 
     * returns null; otherwise returns the User object specified by the email.
	 * @param email
	 * @param password
	 * @return
	 */
	User login(String email, String password);

}
