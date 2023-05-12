package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath = "//*[@id=\"gh-ug\"]/a")
	WebElement signInBtn;
	
	@FindBy(id = "gh-ac")
	WebElement searchBar;

	@FindBy(id = "gh-btn")
	WebElement searchBtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPageEmail openLoginPage() {
		signInBtn.click();
		return new LoginPageEmail();
	}
	
	public SearchListPage searchProductFromHomePage(String prod) {
		searchBar.sendKeys(prod);
		searchBtn.click();
		return new SearchListPage();
	}

}
