package edu.rice.service;

import edu.rice.model.TodoItem;

public interface TodoItemService {

	public TodoItem getTodoItem(String name);
	
	public void addTodoItem(TodoItem todoItem);
	
	public void updateTodoItem(TodoItem todoItem);
	
	public void deleteTodoItem(String name);
}
