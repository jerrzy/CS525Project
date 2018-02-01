package com.dictionary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dictionary.domain.User;
import com.dictionary.service.UserService;

public class UserServlet extends HttpServlet{
	private UserService userService;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();

		userService = new UserService();
	}

	/**
	 * query article
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");

		String responseJSON = "";
		if (userName != null && !userName.isEmpty()) {
			responseJSON = userService.fuzzySelectUserByUserName(userName);
		} 
		else if(userId != null && !userId.isEmpty()) {
			responseJSON = userService.selectUserById(userId);
		}
		else {
			responseJSON = userService.allSelectUsers();
		}

		response.getOutputStream().print(responseJSON);
	}

	/**
	 * add article
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = new User();
		
		user.setUserName(request.getParameter("username"));
		user.setFirstName(request.getParameter("firstname"));
		
		user.setLastName(request.getParameter("lastname"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setRole("user");
		user.setState(request.getParameter("state"));
		user.setCity(request.getParameter("city"));
		user.setStreet(request.getParameter("street"));
		user.setZipcode(request.getParameter("zipcode"));
		
		response.getOutputStream().print(userService.addUser(user));
	}

	/**
	 * delete article
	 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userId = req.getParameter("userId");
		resp.getOutputStream().print(userService.deleteUserById(userId));
	}

}
