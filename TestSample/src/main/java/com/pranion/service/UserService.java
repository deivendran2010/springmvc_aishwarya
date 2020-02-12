package com.pranion.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pranion.dto.UserDTO;
import com.pranion.model.User;

@Service
public interface UserService {
	
	public UserDTO getUserById(int id);

	public List<UserDTO> getUserList();

	public Map<String, User> getUserMap();

	public void addNewUser(UserDTO userDto);

	public void updateUser(UserDTO userDto);

	public void deleteUser(int id_Del);

}
