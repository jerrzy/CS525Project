package com.dictionary.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dictionary.Configuration;
import com.dictionary.domain.User;
import com.dictionary.service.UserService;
import com.google.gson.Gson;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3000832611409388727L;
	private UserService userService;

	public LoginServlet() {
		userService = new UserService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher;
		User currentUser = (User) session.getAttribute(Configuration.getKeyCurrentUser());

		if (currentUser != null) {
			session.removeAttribute(Configuration.getKeyCurrentUser());
			dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		} else {
			String username = request.getParameter(Configuration.getKeyUserName());
			String password = request.getParameter(Configuration.getKeyPassword());

			User user = null;

			if (username != null) {
				Gson g = new Gson();
				String userstr = this.userService.fuzzySelectUserByUserName(username);
				user = g.fromJson(userstr, User.class);
			}

			if (user != null && password.equals(user.getPassword())) {

				session.setAttribute(Configuration.getKeyCurrentUser(), user);
				dispatcher = request.getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);

			} else {
				dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.include(request, response);
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}