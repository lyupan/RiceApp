package edu.rice.service;

import edu.rice.model.TodoCategory;

public interface TodoCategoryService {
	
	public TodoCategory getTodoCategory(String category);
	
	public void updateTodoCategory(TodoCategory todoCategory);
	
	public void deleteTodoCategory(String category);
	
	public void addTodoCategory(TodoCategory todoCategory);
}
