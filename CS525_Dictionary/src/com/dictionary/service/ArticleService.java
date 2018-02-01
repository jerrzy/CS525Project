package com.dictionary.service;

import java.util.List;

import com.dictionary.Configuration;
import com.dictionary.dao.ArticleDAO;
import com.dictionary.domain.Article;
import com.google.gson.Gson;

public class ArticleService {

	private ArticleDAO articleDAO;

	public ArticleService() {
		articleDAO = new ArticleDAO();
	}

	/**
	 * userId not null. title not null.content could be null.
	 * 
	 * @param userId
	 * @param title
	 * @param content
	 * @return
	 */
	public String addArticle(String userId, String title, String content) {

		int result = 0;

		int userIdI = -1;
		try {
			userIdI = Integer.parseInt(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String json = "";
		if (userIdI != -1 && title != null && !title.isEmpty()) {
			Article article = new Article(userIdI, title, content);
			article.setDate(Configuration.nowS());
			result = articleDAO.addArticle(article);
			Gson gson = new Gson();
			json = gson.toJson(result);
		}

		return json;
	}

	public String selectAllArticles() {
		List<Article> articles = articleDAO.queryAllArticles();
		Gson gson = new Gson();
		String json = gson.toJson(articles);
		return json;
	}

	public String fuzzySelectArticlesByKeyWord(String keyWord) {
		List<Article> articles = articleDAO.queryArticals(keyWord);
		Gson gson = new Gson();
		String json = gson.toJson(articles);
		return json;
	}

	public String selectArticleById(String articleId) {

		int articleIdI = -1;
		try {
			articleIdI = Integer.parseInt(articleId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String json = "";
		if (articleIdI != -1) {
			Article article = articleDAO.queryArticalById(articleIdI);
			Gson gson = new Gson();
			json = gson.toJson(article);
		}

		return json;
	}

	public String selectArticlesByUserId(String userId) {

		int userIdI = -1;
		try {
			userIdI = Integer.parseInt(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String json = "";
		if (userIdI != -1) {
			List<Article> articles = articleDAO.queryArticalsByUserId(userIdI);
			Gson gson = new Gson();
			json = gson.toJson(articles);
		}

		return json;
	}

	public String deleteArticleById(String articleId) {

		boolean result = false;
		int articleIdI = -1;
		try {
			articleIdI = Integer.parseInt(articleId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String json = "";
		if (articleIdI != -1) {
			result = articleDAO.deleteArticle(articleIdI) == 1 ? true : false;
			Gson gson = new Gson();
			json = gson.toJson(result);
		}

		return json;
	}
}
