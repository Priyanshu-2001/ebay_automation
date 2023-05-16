package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutPage extends TestBase {
	
	@FindBy(xpath = "//*[@id=\"selectable-render-summary5\"]")
	WebElement GpayBtn;
	
	@FindBy(xpath = "//div[@class='gpay-card-info-placeholder-container']")
	WebElement GpaySubmitBtn;
	
	@FindBy(xpath = "//button[@class='btn currency-cta-container__primary btn--primary']")
	WebElement acceptCurrencyConversionBtn;

	
	public CheckOutPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void selectGpayOption() {
		GpayBtn.click();
	}
	
	public void selectConversionBtn() {
		acceptCurrencyConversionBtn.click();
	}
	
	public void clickOnSubmitBtn() {
		System.out.println(GpaySubmitBtn.getText());
		GpaySubmitBtn.click();
	}

}
