package com.dictionary.dao;

import java.util.ArrayList;
import java.util.List;

import com.dictionary.DBConnection;
import com.dictionary.domain.Article;

public class ArticleDAO {

	private final String tableName = "artical";

	private final String addSQLTemplate = "INSERT INTO " + tableName
			+ " (user_id, date, title, content) VALUES (?,?,?,?) ";

	private final String selectAllSQLTemplate = "SELECT id, user_id, date, title, content FROM " + tableName;

	private final String fuzzySQLTemplate = "SELECT id, user_id, date, title, content FROM " + tableName
			+ " WHERE title LIKE ? OR content LIKE ?";

	private final String queryByIdSQLTemplate = "SELECT id, user_id, date, title, content FROM " + tableName
			+ " WHERE id=? ";

	private final String queryByUserIdSQLTemplate = "SELECT id, user_id, date, title, content FROM " + tableName
			+ " WHERE user_id=? ";

	private final String deleteArticleByIdSQLTemplate = "DELETE FROM " + tableName + " WHERE id=? ";

	public int addArticle(Article article) {

		return DBConnection.getInstance().add(addSQLTemplate,
				new Object[] { article.getUserId(), article.getDate(), article.getTitle(), article.getContent() });
	}

	public List<Article> queryAllArticles() {
		List<Object[]> queryResult = DBConnection.getInstance().query(selectAllSQLTemplate, new Object[] {});
		List<Article> result = new ArrayList<Article>();
		for (Object[] objects : queryResult) {
			Article entry = new Article();
			try {
				entry.setId(Integer.parseInt(objects[0].toString()));
				entry.setUserId(Integer.parseInt(objects[1].toString()));
				entry.setDate(objects[2].toString());
				entry.setTitle(objects[3].toString());
				entry.setContent(objects[4].toString());
			} catch (Exception e) {
			}
			result.add(entry);
		}
		return result;
	}

	public List<Article> queryArticals(String keyWord) {

		List<Object[]> queryResult = DBConnection.getInstance().query(fuzzySQLTemplate,
				new Object[] { "%" + keyWord + "%", "%" + keyWord + "%" });
		List<Article> result = new ArrayList<Article>();
		for (Object[] objects : queryResult) {
			Article entry = new Article();
			try {
				entry.setId(Integer.parseInt(objects[0].toString()));
				entry.setUserId(Integer.parseInt(objects[1].toString()));
				entry.setDate(objects[2].toString());
				entry.setTitle(objects[3].toString());
				entry.setContent(objects[4].toString());
			} catch (Exception e) {
			}
			result.add(entry);
		}
		return result;
	}

	public Article queryArticalById(int id) {
		List<Object[]> queryResult = DBConnection.getInstance().query(queryByIdSQLTemplate, new Object[] { id });
		Article entry = new Article();
		for (Object[] objects : queryResult) {
			try {
				entry.setId(Integer.parseInt(objects[0].toString()));
				entry.setUserId(Integer.parseInt(objects[1].toString()));
				entry.setDate(objects[2].toString());
				entry.setTitle(objects[3].toString());
				entry.setContent(objects[4].toString());
			} catch (Exception e) {
			}
		}
		return entry;
	}

	public List<Article> queryArticalsByUserId(int userId) {
		List<Object[]> queryResult = DBConnection.getInstance().query(queryByUserIdSQLTemplate,
				new Object[] { userId });
		List<Article> result = new ArrayList<Article>();
		for (Object[] objects : queryResult) {
			Article entry = new Article();
			try {
				entry.setId(Integer.parseInt(objects[0].toString()));
				entry.setUserId(Integer.parseInt(objects[1].toString()));
				entry.setDate(objects[2].toString());
				entry.setTitle(objects[3].toString());
				entry.setContent(objects[4].toString());
			} catch (Exception e) {
			}
			result.add(entry);
		}
		return result;
	}

	public int deleteArticle(int articleId) {

		return DBConnection.getInstance().delete(deleteArticleByIdSQLTemplate, new Object[] { articleId });
	}
}
