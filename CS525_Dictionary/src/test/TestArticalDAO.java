package test;

import org.junit.jupiter.api.Test;

import com.dictionary.dao.ArticleDAO;

class TestArticalDAO {

	@Test
	void test() {
		ArticleDAO articalDAO = new ArticleDAO();

		System.out.println("phase 1");
		System.out.println(articalDAO.queryArticals("title"));

		System.out.println("phase 2");

		System.out.println(articalDAO.queryArticalById(3));

		System.out.println("phase 3");

		System.out.println(articalDAO.queryArticalsByUserId(1));
	}

}
