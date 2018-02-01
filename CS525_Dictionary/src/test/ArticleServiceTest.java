package test;

import org.junit.jupiter.api.Test;

import com.dictionary.service.ArticleService;

class ArticleServiceTest {

	@Test
	void test() {
		// fail("Not yet implemented");

		// System.out.println("case 1");
		ArticleService service = new ArticleService();
		// System.out.println(service.selectArticleById(3));

		// System.out.println("case 2");
		// System.out.println(service.selectArticlesByUserId(1));

		// System.out.println(service.fuzzySelectArticlesByKeyWord("first"));

		System.out.println(service.deleteArticleById("3"));
	}

}
