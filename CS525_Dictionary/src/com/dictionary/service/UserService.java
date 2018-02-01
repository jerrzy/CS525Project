package com.dictionary.service;

import java.util.List;

import com.dictionary.dao.UserDAO;
import com.dictionary.domain.User;
import com.google.gson.Gson;

public class UserService {
	private UserDAO userDAO;

	public UserService() {
		userDAO = new UserDAO();
	}

	/**
	 * userId not null. title not null.content could be null.
	 * 
	 * @param userId
	 * @param title
	 * @param content
	 * @return
	 */
	public String addUser(User user) {

		int result = 0;
		String json = "";
		if (user.getFirstName() != null && !user.getPassword().isEmpty()) {

			result = userDAO.addUser(user);
			Gson gson = new Gson();
			json = gson.toJson(result);
		}

		return json;
	}

	public String selectUserById(String userId) {

		int userIdI = -1;
		try {
			userIdI = Integer.parseInt(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String json = "";
		if (userIdI != -1) {
			User user = userDAO.queryUserById(userIdI);
			Gson gson = new Gson();
			json = gson.toJson(user);
		}

		return json;
	}

	public String fuzzySelectUserByUserName(String userName) {
		User users = userDAO.queryUsers(userName);
		Gson gson = new Gson();
		String json = gson.toJson(users);
		return json;
	}

	public String allSelectUsers() {
		List<User> users = userDAO.queryAllUsers();
		Gson gson = new Gson();
		String json = gson.toJson(users);
		return json;
	}

	public String deleteUserById(String usetId) {

		boolean result = false;
		int usetIdI = -1;
		try {
			usetIdI = Integer.parseInt(usetId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String json = "";
		if (usetIdI != -1) {
			result = userDAO.deleteUser(usetIdI) == 1 ? true : false;
			Gson gson = new Gson();
			json = gson.toJson(result);
		}

		return json;
	}
}
