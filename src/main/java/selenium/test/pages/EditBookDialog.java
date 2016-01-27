package selenium.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.test.AbstractPageObject;

public class EditBookDialog extends AbstractPageObject {
	@FindBy(xpath = "//input [@ng-model='title']")
	private WebElement bookTitle;
	@FindBy(xpath = "//button [contains(text(),'Zapisz tytuł')]")
	private WebElement saveBook;

	public EditBookDialog(WebDriver driver) {
		super(driver);
	}

	public EditBookDialog setBookTitle(String bookTitle) {
		this.bookTitle.clear();
		this.bookTitle.sendKeys(bookTitle);
		return this;
	}

	public FindBooksPage clickSaveButton() {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOf(saveBook));
		saveBook.click();
		return PageFactory.initElements(driver, FindBooksPage.class);
	}

}
