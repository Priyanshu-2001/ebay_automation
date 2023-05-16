package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class ProductPage extends TestBase{

	@FindBy(id = "binBtn_btn_1")
	WebElement buyNow;
	
	@FindBy(xpath = "//*[@id=\"mainContent\"]/form/div[2]/div/div[1]/div[2]/ul/li[2]/div")
	WebElement addToCart;
	
	@FindBy(xpath = "//*[@id=\"mainContent\"]/form/div[2]/div/div[1]/div[1]/div/div[2]/div/span[1]")
	WebElement productPrice;
	
	@FindBy(xpath = "//select[@id='x-msku__select-box-1000']")
	WebElement dropDown;
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public CheckOutPage clickOnBuyNow() {
		buyNow.click();
		return new CheckOutPage();
	}
	
	public boolean isAddToCartVisibile() {
		return addToCart.isDisplayed();
	}
	
	public String getProductPrice() {
		return productPrice.getAttribute("content");
	}

	public void selectOption() {
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='x-msku__select-box-1000']"));
		Select drop = new Select(dropDown);
		drop.selectByIndex(1);
	}
	
}
