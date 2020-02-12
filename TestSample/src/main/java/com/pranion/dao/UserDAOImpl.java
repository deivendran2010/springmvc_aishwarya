package com.pranion.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.pranion.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);

	final String DRIVER_CLASSNAME = "org.postgresql.Driver";
	final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
	final String USER_NAME = "postgres";
	final String PASS_WORD = "postgres";

	@Override
	public User getUserById(int id) {

		LOGGER.info("Start UserDAOImpl - getUserById()");

		Connection c = null;
		User user = new User();
		try {
			Class.forName(DRIVER_CLASSNAME);
			c = DriverManager.getConnection(DB_URL, USER_NAME, PASS_WORD);
			c.setAutoCommit(false);
			LOGGER.info("Opened database successfully");
			
			PreparedStatement statement = c.prepareStatement("select * from Users where id = ?");    
			statement.setInt(1, id);    
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				int userId = rs.getInt("id");
				user.setId(Integer.toString(userId));
				String name = rs.getString("name");
				user.setName(name);
				String age = rs.getString("age");
				user.setAge(age);
			}
			rs.close();
			statement.close();
			c.close();

		} catch (Exception e) {
			LOGGER.error(e.getClass().getName() + ": " + e.getMessage());
		}
		LOGGER.info("End UserDAOImpl - getUserById()");
		return user;

	}

	@Override
	public List<User> getUserList() {
		LOGGER.info("Start UserDAOImpl - getUserList()");

		Connection c = null;
		List<User> userList = new ArrayList<User>();
		try {
			Class.forName(DRIVER_CLASSNAME);
			c = DriverManager.getConnection(DB_URL, USER_NAME, PASS_WORD);
			c.setAutoCommit(false);
			LOGGER.info("Opened database successfully");

			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Users;");

			while (rs.next()) {
				User user = new User();
				int userId = rs.getInt("id");
				user.setId(Integer.toString(userId));
				String name = rs.getString("name");
				user.setName(name);
				String age = rs.getString("age");
				user.setAge(age);
				userList.add(user);
			}
			rs.close();
			stmt.close();
			c.close();

		} catch (Exception e) {
			LOGGER.error(e.getClass().getName() + ": " + e.getMessage());
		}
		LOGGER.info("End UserDAOImpl - getUserList()");
		return userList;
	}

	@Override
	public void addNewUser(User user) {
		LOGGER.info("Start UserDAOImpl - addNewUser",user);

		Connection c = null;
		
		try {
			Class.forName(DRIVER_CLASSNAME);
			c = DriverManager.getConnection(DB_URL, USER_NAME, PASS_WORD);
			c.setAutoCommit(false);
			LOGGER.info("Opened database successfully");

			Statement stmt = c.createStatement();
			String sql = "INSERT INTO Users (ID,NAME,AGE) VALUES ("
					    +Integer.parseInt(user.getId())
					    + ",'"
					    + user.getName() 
					    + "','"
					    + user.getAge()
					    + "');";
			
		    stmt.executeUpdate(sql);
		    c.commit();
			stmt.close();			
			c.close();

		} catch (Exception e) {
			LOGGER.error(e.getClass().getName() + ": " + e.getMessage());
		}
		LOGGER.info("End UserDAOImpl - addNewUser");
		
	}

	@Override
	public void updateUser(User user) {
		LOGGER.info("Start UserDAOImpl - updateUser",user);

		Connection c = null;
		
		try {
			Class.forName(DRIVER_CLASSNAME);
			c = DriverManager.getConnection(DB_URL, USER_NAME, PASS_WORD);
			c.setAutoCommit(false);
			LOGGER.info("Opened database successfully");

			Statement stmt = c.createStatement();
			String sql = "UPDATE Users SET NAME = '"
						+ user.getName()
						+ "',"
						+ "AGE = '"
						+ user.getAge()
						+ "'"
						+ "WHERE ID = "
					    +Integer.parseInt(user.getId())
					    + ";";
					    
			
		    stmt.executeUpdate(sql);
		    c.commit();
			stmt.close();
			c.close();

		} catch (Exception e) {
			LOGGER.error(e.getClass().getName() + ": " + e.getMessage());
		}
		LOGGER.info("End UserDAOImpl - updateUser");
		
	}

	@Override
	public void deleteUser(int id_Del) {
		LOGGER.info("Start UserDAOImpl - updateUser",id_Del);

		Connection c = null;
		
		try {
			Class.forName(DRIVER_CLASSNAME);
			c = DriverManager.getConnection(DB_URL, USER_NAME, PASS_WORD);
			c.setAutoCommit(false);
			LOGGER.info("Opened database successfully");

			Statement stmt = c.createStatement();
	        String sql = "DELETE from Users where ID = "
	        			 +id_Del
	        			 +";";
	        stmt.executeUpdate(sql);
	        c.commit();
			
		    c.commit();
		    stmt.close();
			c.close();

		} catch (Exception e) {
			LOGGER.error(e.getClass().getName() + ": " + e.getMessage());
		}
		LOGGER.info("End UserDAOImpl - updateUser");
		
	}

}
