package edu.rice.mapper;

import java.util.List;
import java.util.Map;

import edu.rice.model.TodoItem;

public interface TodoItemMapper {

	public TodoItem getTodoItem(Map<String, String> map);
	
	public void addTodoItem(Map<String, String> map);
	
	public void updateTodoItem(Map<String, String> map);
	
	public void deleteTodoItem(Map<String, String> map);
	
	public List<TodoItem> allTodoItems(String email);
}
