/**
 * 
 */
package com.pranion.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pranion.dao.UserDAO;
import com.pranion.dto.UserDTO;
import com.pranion.model.User;

/**
 * @author aishwarya
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private User user;
	
	@Autowired
	private UserDAO userDao;

	@Override
	public UserDTO getUserById(int id) {
		
		LOGGER.info("Start UserServiceImpl - getUserById-id",id);
		
		UserDTO userDto = new UserDTO();
		User user = userDao.getUserById(id);
		
		if(Objects.nonNull(user)) {
			BeanUtils.copyProperties(user, userDto);
		}
		
		LOGGER.info("End UserServiceImpl - getUserById");
		return userDto;
	}
	
	@Override
	public List<UserDTO> getUserList() {
		
		LOGGER.info("Start UserServiceImpl - getUserList");
		
		List<UserDTO> userDtoList = new ArrayList<UserDTO>();
		
		List<User> userList = userDao.getUserList();
		if(userList.isEmpty()) { 
			LOGGER.info("UserServiceImpl  - userList is Empty");
		} else {
			for(User user : userList) {
				if(Objects.nonNull(user)) {
					UserDTO userDto = new UserDTO();
					BeanUtils.copyProperties(user, userDto);
					userDtoList.add(userDto);
				}
			}
		}
		
		LOGGER.info("End UserServiceImpl - getUserList");
		return userDtoList;
	
	}
	
	@Override
	public void addNewUser(UserDTO userDto) {
		
	}
	
	
	@Override
	public void updateUser(UserDTO userDto) {
		
		LOGGER.info("Start UserServiceImpl - updateUser");
		
		//Check if the given user exists
		if(Objects.nonNull(userDto) && !StringUtils.isEmpty(userDto.getId())) {
			User user = userDao.getUserById(Integer.parseInt(userDto.getId()));
			if(Objects.nonNull(user)) {
				BeanUtils.copyProperties(userDto, user);
				userDao.updateUser(user);
			} else {
				LOGGER.error("The user does not exist to update");
			}
		}
		
		LOGGER.info("End UserServiceImpl - updateUser");
	
	}
	
	@Override
	public void deleteUser(int id_Del) {

		LOGGER.info("Start UserServiceImpl - deleteUser-id", id_Del);

		// Check if the given user exists
		if (!StringUtils.isEmpty(id_Del)) {
			User user = userDao.getUserById(id_Del);
			if (Objects.nonNull(user)) {
				userDao.deleteUser(id_Del);
			} else {
				LOGGER.error("The user does not exist to delete");
			}
		}

		LOGGER.info("End UserServiceImpl - getUserById");

	}
	
	
	@Override
	public Map<String, User> getUserMap() {
		
		Map<String,User> userMap = new HashMap<String, User>();
		
		User user1 = new User();
		user1.setId("1");
		user1.setName("C");
		user1.setAge("25");
		
		userMap.put(user1.getId(), user1);
		
		User user2 = new User();
		user2.setId("2");
		user2.setName("D");
		user2.setAge("26");
		
		userMap.put(user2.getId(), user2);
		
		return userMap;
	}


	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the userDao
	 */
	public UserDAO getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	

	
}
