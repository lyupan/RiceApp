package edu.rice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.rice.bean.ResultBean;
import edu.rice.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@RequestMapping(value="/enroll/{termCode}/{crn}", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<?> enrollCourse(String email, @PathVariable String termCode, @PathVariable String crn) {
		if (userService.addCourse(email, termCode, crn) )
			return ResultBean.success();
		return ResultBean.failure("1002");
	}
	
	@RequestMapping(value="/courses", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<?> myCourses(String email) {
		System.out.println("my courses" + email);
		if (email == null)
			return ResultBean.failure("");
		return ResultBean.success(userService.allCourses(email));
	}
	
}
