package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPageEmail extends TestBase{
	
	@FindBy(name="userid")
	private WebElement email;
	
	@FindBy(id = "signin-continue-btn")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//img[@id='gh-logo']")
	private WebElement logo;
	
	@FindBy(id = "signin_ggl_btn")
	private WebElement googleSignIn;
	
	public LoginPageEmail() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String email) {
		this.email.sendKeys(email);
	}
	
	public LoginPagePassword continueToPassword() {
		this.submitBtn.click();
		return new LoginPagePassword();
	}
	
	public boolean isContinueBtnDisplayed() {
		return submitBtn.isDisplayed();
	}
	
	public boolean isLogoDisplayed() {
		return logo.isDisplayed();
	}
	
	public boolean isGoogleSignInDisplayed() {
		return googleSignIn.isDisplayed();
	}
	
	public String textTypedInEmail() {
		return email.getText();	
	}
}
