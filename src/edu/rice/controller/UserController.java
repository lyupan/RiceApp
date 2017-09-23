package edu.rice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.rice.bean.ResultBean;
import edu.rice.model.Course;
import edu.rice.service.CourseService;
import edu.rice.service.UserService;
import edu.rice.util.Http;

@Controller
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@Autowired
	public CourseService courseService;
	
	@RequestMapping(value="/sync", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean<?> syncWithRice() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("term", "201810");
		map.put("subj", "COMP");
		List<Course> courses = Http.Singleton.getCousrses(map);
		System.out.println("Delete all courses, records " + courseService.deleteCourses());
		
		System.out.println("add courses " + courses.size());
		courseService.addCourses(courses);
		return ResultBean.success();
	}
	
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
