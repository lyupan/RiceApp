package edu.rice.mapper;

import java.util.Map;

import edu.rice.model.User;

public interface UserMapper {
	
	User login(Map<String, Object> map);

}
