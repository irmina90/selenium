package selenium.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.test.AbstractPageObject;

public class HomePage extends AbstractPageObject{
	@FindBy(linkText="Book List")
	private WebElement bookList;
	@FindBy(linkText="Author List")
	private WebElement authorList;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver.get("http://localhost:9000/#/main/welcome");
	}
	
	public FindBooksPage clickFindBook() {
		getBookList().click();
		return PageFactory.initElements(driver, FindBooksPage.class);
	}
	
	public FindAuthorsPage clickFindAuthor() {
		getAuthorList().click();
		return PageFactory.initElements(driver, FindAuthorsPage.class);
	}

	public WebElement getBookList() {
		return bookList;
	}

	public void setBookList(WebElement bookList) {
		this.bookList = bookList;
	}

	public WebElement getAuthorList() {
		return authorList;
	}

	public void setAuthorList(WebElement authorList) {
		this.authorList = authorList;
	}
	
}
