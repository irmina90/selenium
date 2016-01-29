package selenium.test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import selenium.test.AbstractPageObject;

public class FindAuthorsPage extends AbstractPageObject {
	@FindBy(xpath = "//button [contains(text(),'Szukaj')]")
	private WebElement searchAuthor;
	@FindBy(xpath = "//input")
	private WebElement authorName;
	@FindBy(xpath = "//section/author-table/tbody")
	private WebElement authorTable;
    
	public FindAuthorsPage(WebDriver driver) {
		super(driver);
	}
	
	public FindAuthorsPage setAuthorNamePrefix(String name) {
		this.authorName.sendKeys(name);
		return this;
	}
	
	public FindAuthorsPage clickSearchAuthor() {
		searchAuthor.click();
		return this;
	}
	
	public List<WebElement> getRows() {
		return authorTable.findElements(By.xpath("//section/table/tbody/tr"));
	}

	public int countRows() {
		return driver.findElements(By.xpath("//section/table/tbody/tr")).size();
	}
}
