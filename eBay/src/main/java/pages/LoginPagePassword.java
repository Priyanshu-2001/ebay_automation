package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPagePassword extends TestBase {

	@FindBy(id="pass")
	WebElement password;
	
	@FindBy(id="sgnBt")
	WebElement signIn;
	
	@FindBy(id = "user-info")
	WebElement userEmailEntered;
	
	public LoginPagePassword() {
		PageFactory.initElements(driver, this);
	}
	
	public void typePassword(String pass) {
		password.sendKeys(pass);

	}
	
	public HomePage clickSignIn() {
		signIn.click();
		return new HomePage();
	}
	
	public String enteredEmailVerification() {
		return userEmailEntered.getText();
	}
	
	public boolean verifySignInBtnVisible() {
		return signIn.isDisplayed();
	}
	
	public String verifyTypedPassword() {
		return password.getAttribute("value");
	}
	
}
