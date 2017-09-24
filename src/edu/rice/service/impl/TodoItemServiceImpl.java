package edu.rice.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.rice.mapper.TodoItemMapper;
import edu.rice.model.TodoItem;
import edu.rice.service.TodoItemService;

@Service
@Transactional
public class TodoItemServiceImpl implements TodoItemService {

	@Resource
	private TodoItemMapper todoItemMapper;
	
	@Override
	public TodoItem getTodoItem(String name, String email) {
		return todoItemMapper.getTodoItem(name, email);
	}

	@Override
	public void addTodoItem(TodoItem todoItem, String email) {
		todoItemMapper.addTodoItem(todoItem, email);
	}

	@Override
	public void updateTodoItem(TodoItem todoItem, String email) {
		todoItemMapper.updateTodoItem(todoItem, email);
	}

	@Override
	public void deleteTodoItem(String name, String email) {
		todoItemMapper.deleteTodoItem(name, email);
	}

	@Override
	public List<TodoItem> allTodoItems(String email) {
		return todoItemMapper.allTodoItems(email);
	}

}
