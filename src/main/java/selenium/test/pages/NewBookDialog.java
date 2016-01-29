package selenium.test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.test.AbstractPageObject;

public class NewBookDialog extends AbstractPageObject {
	@FindBy(xpath = "//input [@ng-model='book.title']")
	private WebElement bookTitle;
	@FindBy(xpath = "//input [@ng-model='book.authors.firstName']")
	private WebElement authorFirstName;
	@FindBy(xpath = "//input [@ng-model='book.authors.lastName']")
	private WebElement authorLastName;
	@FindBy(xpath = "//button [contains(text(),'Dodaj książkę')]")
	private WebElement addBook;
	@FindBy(xpath = "//button [contains(text(),'Dodaj więcej autorów')]")
	private WebElement addMoreAuthors;
	@FindBy(xpath = "//section/table/tbody")
	private WebElement authorsTable;

	public NewBookDialog(WebDriver driver) {
		super(driver);
	}

	public WebElement getBookTitle() {
		return bookTitle;
	}

	public NewBookDialog setBookTitle(String bookTitle) {
		this.bookTitle.clear();
		this.bookTitle.sendKeys(bookTitle);
		return this;
	}

	public NewBookDialog setAuthorFirstName(String firstName) {
		this.authorFirstName.clear();
		this.authorFirstName.sendKeys(firstName);
		return this;
	}

	public NewBookDialog setAuthorLastName(String lastName) {
		this.authorLastName.clear();
		this.authorLastName.sendKeys(lastName);
		return this;
	}

	public NewBookDialog clickAddBookButton() {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOf(addBook));
		addBook.click();
		return this;
	}

	public AddMoreAuthorsDialog clickAddMoreAuthorsButton() {
		addMoreAuthors.click();
		return PageFactory.initElements(driver, AddMoreAuthorsDialog.class);
	}

	public List<WebElement> getRows() {
		return authorsTable.findElements(By.xpath("//section/author-table/tbody/tr"));
	}

	public int countRows() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(authorsTable));
		return driver.findElements(By.xpath("//author-table/tbody/tr")).size();
	}

}
