package edu.rice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(String username, String password) {
		return username + " " + password;
	}
}
