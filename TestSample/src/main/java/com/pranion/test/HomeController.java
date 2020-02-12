package com.pranion.test;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pranion.dto.CategoryDTO;
import com.pranion.dto.UserDTO;
import com.pranion.model.Subcategory;
import com.pranion.service.CategoryService;
import com.pranion.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
/*@Configuration
@ComponentScan("com.pranion.service")
@RequestMapping(value = "/")*/
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		model.addAttribute("name", "Tech");
		
		List<String> langList = new ArrayList<String>();
		langList.add("Java");
		langList.add("Php");
		langList.add("Python");
		langList.add("C");
		
		model.addAttribute("langList", langList);
		
		Map<String, String> skill = new HashMap<String, String>();
		skill.put("Hibernate", "Hibernate");
		skill.put("Spring", "Spring");
		skill.put("Struts", "Struts");
		skill.put("Groovy", "Groovy");
		skill.put("Grails", "Grails");
		
		model.addAttribute("javaSkillList", skill);

		//Retrieving User using Id
		int id =2;
		UserDTO user = userService.getUserById(id);		
		model.addAttribute("users", user);	

		//Adding new user
		/*UserDTO userDto = new UserDTO();
		userDto.setId("3");
		userDto.setName("Mark");
		userDto.setAge("30");
		
		userService.addNewUser(userDto);*/
		
		//Updating user details with Id
		/*UserDTO userDto = new UserDTO();
		userDto.setId("3");
		userDto.setName("Mark Smith");
		userDto.setAge("28");
		
		userService.updateUser(userDto);*/
		
		//Deleting user using Id
		int id_Del = 3;
		userService.deleteUser(id_Del);
		
		//Listing All users
		List<UserDTO> userList = new ArrayList<UserDTO>();
		userList = userService.getUserList();
		model.addAttribute("userList",userList);
		
		//List All Categories
		List<CategoryDTO> categoryList = new ArrayList<CategoryDTO>();
		categoryList = categoryService.getCategoryList();
		model.addAttribute("categoryList",categoryList);
		
		
		/*Map<String,User> userMap = new HashMap<String, User>();
		userMap = userService.getUserMap();
		model.addAttribute("userMap", userMap);*/
		
		return "home";
	}
	
	/*@RequestMapping(value = "/categories/{categoryId}", method = RequestMethod.GET)
	public @ResponseBody List<Subcategory> getAllSubcategories(@PathVariable("categoryId") int categoryId) {
		return categoryService.getAllSubcategories(categoryId);
	}*/
	
	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * @return the categoryService
	 */
	public CategoryService getCategoryService() {
		return categoryService;
	}

	/**
	 * @param categoryService the categoryService to set
	 */
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	
}
