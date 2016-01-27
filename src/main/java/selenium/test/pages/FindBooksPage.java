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

public class FindBooksPage extends AbstractPageObject {
	@FindBy(xpath = "//button [contains(text(),'Add book')]")
	private WebElement addBook;
	@FindBy(xpath = "//button [contains(text(),'Szukaj')]")
	private WebElement searchBook;
	@FindBy(xpath = "//input")
	private WebElement bookTitle;
	@FindBy(xpath = "//section/table/tbody")
	private WebElement bookTable;
    @FindBy(xpath = "//button [contains(text(),'Edytuj')]")
    private List<WebElement> editBook;
    @FindBy(xpath = "//button [contains(text(),'Usuń')]")
    private List<WebElement> deleteBook;

	public FindBooksPage(WebDriver driver) {
		super(driver);
	}

	public FindBooksPage setTitlePrefix(String title) {
		this.bookTitle.sendKeys(title);
		return this;
	}

	public NewBookDialog clickAddBook() {
		addBook.click();
		return PageFactory.initElements(driver, NewBookDialog.class);
	}
	
	public EditBookDialog clickEditBook(int index) {
		if(index < editBook.size() || index >= 0) editBook.get(index).click();
        return PageFactory.initElements(driver,EditBookDialog.class);
	}

	public FindBooksPage clickDeleteButton(int index) {
        if (index < deleteBook.size() || index >= 0) deleteBook.get(index).click();
        return this;
    }
	
	public FindBooksPage clickSearchBook() {
		searchBook.click();
		return this;
	}

	public WebElement getAddBook() {
		return addBook;
	}

	public void setAddBook(WebElement addBook) {
		this.addBook = addBook;
	}

	public WebElement getSearchBook() {
		return searchBook;
	}

	public void setSearchBook(WebElement searchBook) {
		this.searchBook = searchBook;
	}

	public WebElement getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(WebElement bookTitle) {
		this.bookTitle = bookTitle;
	}

	public List<WebElement> getRows() {
		return bookTable.findElements(By.xpath("//section/table/tbody/tr"));
	}

	public int countRows() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(bookTable));
		return driver.findElements(By.xpath("//section/table/tbody/tr")).size();
	}

}
