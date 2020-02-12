package com.pranion.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pranion.model.User;

@Repository
public interface UserDAO {
	
	public User getUserById(int id);

	public List<User> getUserList();

	public void addNewUser(User user);

	public void updateUser(User user);

	public void deleteUser(int id_Del);

}
