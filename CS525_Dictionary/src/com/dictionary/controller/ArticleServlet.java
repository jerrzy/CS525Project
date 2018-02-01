package com.dictionary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dictionary.service.ArticleService;

/**
 * Servlet implementation class ArticalServlet
 */
public class ArticleServlet extends HttpServlet {

	private ArticleService articleService;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArticleServlet() {
		super();

		articleService = new ArticleService();
	}

	/**
	 * query article
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String articleId = request.getParameter("articleId");
		String userId = request.getParameter("userId");
		String keyWord = request.getParameter("keyWord");

		String responseJSON = "";
		if (keyWord != null && !keyWord.isEmpty()) {
			responseJSON = articleService.fuzzySelectArticlesByKeyWord(keyWord);
		} else if (userId != null && !userId.isEmpty()) {
			responseJSON = articleService.selectArticlesByUserId(userId);
		} else if (articleId != null && !articleId.isEmpty()) {
			responseJSON = articleService.selectArticleById(articleId);
		} else {
			responseJSON = articleService.selectAllArticles();
		}

		response.getOutputStream().print(responseJSON);
	}

	/**
	 * add article
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		response.getOutputStream().print(articleService.addArticle(userId, title, content));
	}

	/**
	 * delete article
	 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String articleId = req.getParameter("articleId");
		resp.getOutputStream().print(articleService.deleteArticleById(articleId));
	}

}
