package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ProductPage extends TestBase{

	@FindBy(id = "binBtn_btn_1")
	WebElement buyNow;
	
	@FindBy(xpath = "//*[@id=\"mainContent\"]/form/div[2]/div/div[1]/div[2]/ul/li[2]/div")
	WebElement addToCart;
	
	@FindBy(xpath = "//*[@id=\"mainContent\"]/form/div[2]/div/div[1]/div[1]/div/div[2]/div/span[1]")
	WebElement productPrice;
	
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
	
}
