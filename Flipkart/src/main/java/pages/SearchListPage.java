package pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class SearchListPage extends TestBase {
	@FindBy(xpath = "//*[@id=\"s0-53-16-5-4[1]\"]/div[2]/div[1]/div/ul/li[4]")
	WebElement onlyBuyNowBtn;
	
	@FindBy(id = "gh-ac")
	WebElement searchBar;
	
	@FindBy(id = "gh-la")
	WebElement logo;

	public SearchListPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void filterProductByOnlyBuyNowCategory() {
		onlyBuyNowBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public ProductPage clickOnProduct() {	
		List<WebElement> productList = driver.findElements(By.xpath("//li[@class='s-item s-item__pl-on-bottom']"));
		int size = productList.size();

		int randomItr = (int) (Math.random() * size) + 0;
		productList.get(randomItr).click();

		Set<String> wnd = driver.getWindowHandles();
		// window handles iterate
		Iterator<String> i = wnd.iterator();i.next();
		String prntw = i.next();
		// switching pop up tab
		driver.switchTo().window(prntw);
		System.out.println(driver.getTitle() + " title");

		return new ProductPage();
	}
	
	public boolean isLogoDisplayed() {
		return logo.isDisplayed();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
}
