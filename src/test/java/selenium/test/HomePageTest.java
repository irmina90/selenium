package selenium.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import selenium.test.pages.HomePage;

public class HomePageTest extends AbstractSelenium {

	private HomePage homePage;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		homePage = openLibrary();
	}

	@Test
	public void shouldCheckIfHomePageOpensCorrectly() {
		assertFalse(homePage.hasError());
		assertTrue(homePage.getBookList().isDisplayed());
		assertTrue(homePage.getAuthorList().isDisplayed());
	}

}
