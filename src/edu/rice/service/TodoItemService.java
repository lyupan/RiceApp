package edu.rice.service;

import java.util.List;
import java.util.Map;

import edu.rice.model.TodoItem;

public interface TodoItemService {

	public TodoItem getTodoItem(String name, String email);
	
	public void addTodoItem(Map<String, String> map);
	
	public void updateTodoItem(Map<String, String> map);
	
	public void deleteTodoItem(String name, String email);
	
	public List<TodoItem> allTodoItems(String email);
}
