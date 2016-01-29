package selenium.test;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import selenium.test.pages.AddMoreAuthorsDialog;

public class AddMoreAuthorsDialogTest extends AbstractSelenium {
	AddMoreAuthorsDialog addMoreAuthorsDialog;
	
	@Override
	@Before
	public void setUp() {
		super.setUp();
		addMoreAuthorsDialog = openLibrary().clickFindBook().clickAddBook().clickAddMoreAuthorsButton();
	}
	
	@Test
	public void shouldAddAuthorCorrectly() {
		addMoreAuthorsDialog.setAuthorFirstName("First name").setAuthorLastName("Last name").clickAddAuthorButton();
		assertFalse(addMoreAuthorsDialog.hasError());
	}
	
}