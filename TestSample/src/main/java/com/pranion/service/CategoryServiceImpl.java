package com.pranion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.pranion.dto.CategoryDTO;
import com.pranion.dto.UserDTO;
import com.pranion.model.Category;
import com.pranion.model.User;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	

	@Override
	public List<CategoryDTO> getCategoryList() {

		LOGGER.info("Start CategoryServiceImpl - getCategoryList");

		List<CategoryDTO> categoryDtoList = new ArrayList<CategoryDTO>();

		/*List<Category> userList = userDao.getUserList();
		if (userList.isEmpty()) {
			LOGGER.info("UserServiceImpl  - userList is Empty");
		} else {
			for (User user : userList) {
				if (Objects.nonNull(user)) {
					UserDTO userDto = new UserDTO();
					BeanUtils.copyProperties(user, userDto);
					userDtoList.add(userDto);
				}
			}
		}*/

		LOGGER.info("End CategoryServiceImpl - getCategoryList");
		return categoryDtoList;
	}

}
