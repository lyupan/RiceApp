package edu.rice.mapper;

import edu.rice.model.TodoItem;

public interface TodoItemMapper {

	public TodoItem getTodoItem(String name);
	
	public void addTodoItem(TodoItem todoItem);
	
	public void updateTodoItem(TodoItem todoItem);
	
	public void deleteTodoItem(String name);
	
}
