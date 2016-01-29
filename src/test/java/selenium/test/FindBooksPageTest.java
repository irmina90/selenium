package selenium.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import selenium.test.pages.FindBooksPage;

public class FindBooksPageTest extends AbstractSelenium {
	private FindBooksPage findBooksPage;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		findBooksPage = openLibrary().clickFindBook();
	}

	@Test
	public void testCheckIfSearchWorksWithEmptyPrefix() {
		// given
		String emptyPrefix = " ";
		// when
		findBooksPage.clickSearchBook();
		int amountOfRows = findBooksPage.countRows();
		findBooksPage.setTitlePrefix(emptyPrefix);
		int amountOfRowsWithPrefixSearch = findBooksPage.countRows();
		// then
		assertTrue(amountOfRows >= 0);
		assertEquals(amountOfRows, amountOfRowsWithPrefixSearch);
	}

	@Test
		 public void testCheckIfSearchWorksWithPrefix() {
		 // given
		 String prefix = "Pierwsza";
		 // when
		 findBooksPage.setTitlePrefix(prefix);
		 findBooksPage.clickSearchBook();
		 int amountOfBooks = findBooksPage.countRows();
		
		 assertNotNull(findBooksPage.getRows().get(amountOfBooks-1).findElement(By.xpath("//td [contains(text(),'Pierwsza')]")));
	 }

	@Test
	public void testCheckIfBookIsRemoved() {
		// when
		int amountOfBooks = findBooksPage.clickSearchBook().countRows();

		if (amountOfBooks > 0) {
			amountOfBooks--;
			findBooksPage.clickDeleteButton(amountOfBooks);
		}

		int booksAfterDelete = findBooksPage.clickSearchBook().countRows();

		// then
		assertEquals(amountOfBooks, booksAfterDelete);
	}

	@Test
	public void testCheckIfBookIsChanged() {
		// when
		findBooksPage.clickSearchBook();
		int amountOfBooks = findBooksPage.countRows();
		findBooksPage.clickEditBook(amountOfBooks - 1).setBookTitle("New title").clickSaveButton();
		// then
		assertNotNull(findBooksPage.getRows().get(amountOfBooks - 1)
				.findElement(By.xpath("//td [contains(text(),'New title')]")));
	}

	@Test
	public void testIfNewBookIsAdded() {
		// when
		findBooksPage.clickSearchBook();
		int amountOfBooks = findBooksPage.countRows();
		findBooksPage.clickAddBook().setBookTitle("New title").setAuthorFirstName("First name")
				.setAuthorLastName("Last name").clickAddBookButton();
		findBooksPage.clickSearchBook();
		// then
		assertNotNull(findBooksPage.getRows().get(amountOfBooks - 1)
				.findElement(By.xpath("//td [contains(text(),'New title')]")));
		assertNotNull(findBooksPage.getRows().get(amountOfBooks - 1)
				.findElement(By.xpath("//td [contains(text(),'First name')]")));
	}

}
