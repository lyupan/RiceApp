package edu.rice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.rice.bean.ResultBean;
import edu.rice.model.TodoCategory;
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
	public ResultBean<?> addTodoItem(Map<String, String> map) {
		if (map.get("email") == null || map.get("name") == null || map.get("category") == null)
			return ResultBean.failure("1003");
		TodoItem todoItem = new TodoItem();
		todoItem.setName(map.get("name"));
		todoItem.setBeginTime(map.get("beginTime"));
		todoItem.setEndTime(map.get("endTime"));
		todoItem.setDate(map.get("date"));
		TodoCategory todoCategory = new TodoCategory();
		todoCategory.setCategory(map.get("category"));
		todoItemService.addTodoItem(todoItem, map.get("email"));
		return ResultBean.success();
	}
	
	@RequestMapping(value="/{name}", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<TodoItem> getTodoItem(@PathVariable String name, String email) {
		return ResultBean.success(todoItemService.getTodoItem(name, email));
	}
	
	@RequestMapping(value="/{name}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResultBean<?> deleteTodoItem(@PathVariable String name, String email) {
		todoItemService.deleteTodoItem(name, email);
		return ResultBean.success();
	}
	
	@RequestMapping(value="/{name}", method = RequestMethod.PUT)
	@ResponseBody
	public ResultBean<?> updateTodoItem(TodoItem todoItem, String email) {
		todoItemService.updateTodoItem(todoItem, email);
		return ResultBean.success();
	}
}
