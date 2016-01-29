package selenium.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import selenium.test.pages.NewBookDialog;

public class NewBookDialogTest extends AbstractSelenium {
	NewBookDialog newBookDialog;
	
	@Override
	@Before
	public void setUp() {
		super.setUp();
		newBookDialog = openLibrary().clickFindBook().clickAddBook();
	}
	
	@Test
	public void shouldAddBookCorrectly() {
		newBookDialog.setBookTitle("New title").setAuthorFirstName("Firstname").setAuthorLastName("Lastname").clickAddBookButton();
		assertFalse(newBookDialog.hasError());
	}
	
	@Test
	public void shouldSaveMoreAuthorsCorrectly() {
		newBookDialog.clickAddMoreAuthorsButton().setAuthorFirstName("Firstname").setAuthorLastName("Lastname").clickAddAuthorButton();
		int amountOfBooks = newBookDialog.countRows();
		assertNotNull(newBookDialog.getRows().get(amountOfBooks-1).findElement(By.xpath("//td [contains(text(),'Firstname')]")));
		assertNotNull(newBookDialog.getRows().get(amountOfBooks-1).findElement(By.xpath("//td [contains(text(),'Lastname')]")));
	}
}
