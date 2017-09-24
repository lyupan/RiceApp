package edu.rice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.rice.bean.ResultBean;
import edu.rice.model.TodoItem;
import edu.rice.service.TodoItemService;

@Controller
public class TodoItemController {

	@Autowired
	private TodoItemService todoItemService;
	
	@RequestMapping(value="/todoitems", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean<List<TodoItem>> allTodoItems() {
//		return todoItemService.
		return null;
	}
}
