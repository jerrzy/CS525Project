package com.dictionary.dao;

import java.util.ArrayList;
import java.util.List;

import com.dictionary.DBConnection;
import com.dictionary.domain.User;

public class UserDAO {
	private final String tableName = "user";

	private final String addSQLTemplate = "INSERT INTO " + tableName + " (username, "
			+ "firstname,lastname,email,password,role,state_name,city,street,zip) VALUES (?," + "?,?,?,?,?,?,?,?,?) ";

	private final String fuzzySQLTemplate = "SELECT * FROM " + tableName + " WHERE username = ?";

	private final String allSQLTemplate = "SELECT * FROM " + tableName;

	private final String queryByIdSQLTemplate = "SELECT *  FROM " + tableName + " WHERE user_id=? ";

	private final String queryByUserIdSQLTemplate = "SELECT id, user_id, title, content FROM " + tableName
			+ " WHERE user_id=? ";

	private final String deleteUserByIdSQLTemplate = "DELETE FROM " + tableName + " WHERE user_id=? ";

	public int addUser(User user) {
		return DBConnection.getInstance().add(addSQLTemplate,
				new Object[] { user.getUserName(), user.getFirstName(), user.getLastName(), user.getEmail(),
						user.getPassword(), user.getRole(), user.getState(), user.getCity(), user.getStreet(),
						user.getZipcode() });
	}

	public User queryUsers(String userName) {

		List<Object[]> queryResult = DBConnection.getInstance().query(fuzzySQLTemplate,
				new Object[] {userName});

		try {
			Object[] obj = queryResult.get(0);
			User user = new User();
			user.setId(Integer.parseInt(obj[0].toString()));
			user.setUserName(obj[1].toString());
			user.setFirstName(obj[2].toString());

			user.setLastName(obj[3].toString());
			user.setEmail(obj[4].toString());
			user.setPassword(obj[5].toString());
			user.setRole(obj[6].toString());
			user.setState(obj[7].toString());
			user.setCity(obj[8].toString());
			user.setStreet(obj[9].toString());
			user.setZipcode(obj[10].toString());
			return user;
		} catch (Exception e) {
		}

		return null;
	}

	public List<User> queryAllUsers() {

		List<Object[]> queryResult = DBConnection.getInstance().query(allSQLTemplate);
		List<User> result = new ArrayList<User>();
		for (Object[] objects : queryResult) {
			User user = new User();
			try {
				user.setId(Integer.parseInt(objects[0].toString()));
				user.setUserName(objects[1].toString());
				user.setFirstName(objects[2].toString());

				user.setLastName(objects[3].toString());
				user.setEmail(objects[4].toString());
				user.setPassword(objects[5].toString());
				user.setRole(objects[6].toString());
				user.setState(objects[7].toString());
				user.setCity(objects[8].toString());
				user.setStreet(objects[9].toString());
				user.setZipcode(objects[10].toString());
			} catch (Exception e) {
			}
			result.add(user);
		}
		return result;
	}

	public User queryUserById(int id) {
		List<Object[]> queryResult = DBConnection.getInstance().query(queryByIdSQLTemplate, new Object[] { id });
		User user = new User();
		for (Object[] objects : queryResult) {
			try {
				user.setId(Integer.parseInt(objects[0].toString()));
				user.setUserName(objects[1].toString());
				user.setFirstName(objects[2].toString());

				user.setLastName(objects[3].toString());
				user.setEmail(objects[4].toString());
				user.setPassword(objects[5].toString());
				user.setRole(objects[6].toString());
				user.setState(objects[7].toString());
				user.setCity(objects[8].toString());
				user.setStreet(objects[9].toString());
				user.setZipcode(objects[10].toString());
			} catch (Exception e) {
			}
		}
		return user;
	}

	public int deleteUser(int userId) {

		return DBConnection.getInstance().delete(deleteUserByIdSQLTemplate, new Object[] { userId });
	}

}
