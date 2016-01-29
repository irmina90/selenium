package selenium.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import selenium.test.pages.FindAuthorsPage;

public class FindAuthorsPageTest extends AbstractSelenium {
	private FindAuthorsPage findAuthorsPage;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		findAuthorsPage = openLibrary().clickFindAuthor();
	}

	@Test
	public void testIfSearchWithEmptyPrefix() {
		// given
		String emptyPrefix = " ";
		// when
		findAuthorsPage.clickSearchAuthor();
		int amountOfRows = findAuthorsPage.countRows();
		findAuthorsPage.setAuthorNamePrefix(emptyPrefix);
		int amountOfRowsWithPrefixSearch = findAuthorsPage.countRows();
		// then
		assertTrue(amountOfRows >= 0);
		assertEquals(amountOfRows, amountOfRowsWithPrefixSearch);
	}

}
