package edu.rice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.rice.bean.ResultBean;
import edu.rice.model.TodoItem;
import edu.rice.service.TodoItemService;

@Controller
public class TodoItemController {

	@Autowired
	private TodoItemService todoItemService;
	
	@RequestMapping(value="/todoitems", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<List<TodoItem>> allTodoItems(String email) {
		return ResultBean.success(todoItemService.allTodoItems(email));
	}
	
	@RequestMapping(value="/todoitem", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<?> addTodoItem(@RequestParam Map<String, String> map) {
		System.out.println(map.get("email"));
		System.out.println(map.get("category"));
		if (map.get("email") == null || map.get("name") == null || map.get("date") == null || map.get("category") == null)
			return ResultBean.failure("1003");
		todoItemService.addTodoItem(map);
		return ResultBean.success();
	}
	
	@RequestMapping(value="/todoitem/{name}", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<TodoItem> getTodoItem(@PathVariable String name, String email) {
		if (name == null || email == null)
			return ResultBean.failure("1003");
		return ResultBean.success(todoItemService.getTodoItem(name, email));
	}
	
	@RequestMapping(value="/todoitem/{name}/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<?> deleteTodoItem(@PathVariable String name, String email) {
		if (name == null || email == null)
			return ResultBean.failure("1003");
		todoItemService.deleteTodoItem(name, email);
		return ResultBean.success();
	}
	
	@RequestMapping(value="/todoitem/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<?> updateTodoItem(@RequestParam Map<String, String> map) {
		if (map.get("email") == null || map.get("name") == null || map.get("category") == null)
			return ResultBean.failure("1003");
		todoItemService.updateTodoItem(map);
		return ResultBean.success();
	}
}
