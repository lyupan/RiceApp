package edu.rice.mapper;

import java.util.List;

import edu.rice.model.TodoItem;

public interface TodoItemMapper {

	public TodoItem getTodoItem(String name, String email);
	
	public void addTodoItem(TodoItem todoItem, String email);
	
	public void updateTodoItem(TodoItem todoItem, String email);
	
	public void deleteTodoItem(String name, String email);
	
	public List<TodoItem> allTodoItems(String email);
}
