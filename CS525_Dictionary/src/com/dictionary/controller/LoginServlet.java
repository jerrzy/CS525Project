package com.dictionary.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//request.getRequestDispatcher("link.html").include(request, response);

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		RequestDispatcher dispatcher;

		if (password.equals("admin123")) {
			//out.print("Welcome, " + name);
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			dispatcher=request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			
		} else {
			out.print("Sorry, username or password error!");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
		out.close();
		//test to see
	}
}