package com.dictionary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dictionary.Configuration;
import com.dictionary.authority.Authority;
import com.dictionary.domain.User;
import com.google.gson.Gson;

/**
 * Servlet implementation class AuthorityServlet
 */
public class AuthorityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthorityServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute(Configuration.getKeyCurrentUser());
		Authority authority = Authority.anonymous();
		if (user != null) {
			if (user.getUserName().equalsIgnoreCase("feili")) {
				authority = Authority.administrator();
			} else {
				authority = Authority.regularUser();
			}
		}
		Gson gson = new Gson();
		response.getOutputStream().print(gson.toJson(authority));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
