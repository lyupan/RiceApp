package edu.rice.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.rice.mapper.TodoCategoryMapper;
import edu.rice.model.TodoCategory;
import edu.rice.service.TodoCategoryService;

@Service
@Transactional
public class TodoCategoryServiceImpl implements TodoCategoryService {

	private TodoCategoryMapper todoCategoryMapper;
	
	@Override
	public TodoCategory getTodoCategory(String category) {
		return null;
	}

	@Override
	public void updateTodoCategory(TodoCategory todoCategory) {
		
	}

	@Override
	public void deleteTodoCategory(String category) {
		
	}

	@Override
	public void addTodoCategory(TodoCategory todoCategory) {
		
	}

}
