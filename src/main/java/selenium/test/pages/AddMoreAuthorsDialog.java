package selenium.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.test.AbstractPageObject;

public class AddMoreAuthorsDialog extends AbstractPageObject {
	@FindBy(xpath = "//input [@ng-model='author.firstName']")
	private WebElement authorFirstName;
	@FindBy(xpath = "//input [@ng-model='author.lastName']")
	private WebElement authorLastName;
	@FindBy(xpath = "//button [contains(text(),'Dodaj autora')]")
	private WebElement addAuthor;

	public AddMoreAuthorsDialog(WebDriver driver) {
		super(driver);
	}

	public AddMoreAuthorsDialog setAuthorFirstName(String firstName) {
		this.authorFirstName.clear();
		this.authorFirstName.sendKeys(firstName);
		return this;
	}

	public AddMoreAuthorsDialog setAuthorLastName(String lastName) {
		this.authorLastName.clear();
		this.authorLastName.sendKeys(lastName);
		return this;
	}

	public AddMoreAuthorsDialog clickAddAuthorButton() {
//    	WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOf(addAuthor));
		addAuthor.click();
		return this;
	}

}
