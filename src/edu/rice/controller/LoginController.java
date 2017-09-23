package edu.rice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.rice.bean.ResultBean;
import edu.rice.model.User;
import edu.rice.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	public UserService userService;
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<User> login(String email, String password) {
		User u = userService.login(email, password);
		if (u == null)
			return ResultBean.failure("1001");
		return ResultBean.success(u);
	}
}
