package TestCases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPageEmail;
import pages.LoginPagePassword;
import pages.ProductPage;
import pages.SearchListPage;

public class BuyNowProductTest extends TestBase{
	
	HomePage homePage;
	LoginPageEmail EmailLoginPage;
	LoginPagePassword passwordLoginPage;
	SearchListPage searchListPage;
	ProductPage productPage;
	CheckOutPage checkOutPage;
	
	SoftAssert softAssert = new SoftAssert();
	
	
	public BuyNowProductTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		init();
		homePage = new HomePage();
	}
	
	@Test()
	public void openLoginPage() throws InterruptedException {
		//HomePage
		EmailLoginPage = homePage.openLoginPage();

		//login email page
		EmailLoginPage.enterEmail(prop.getProperty("email"));
		Assert.assertEquals(EmailLoginPage.isContinueBtnDisplayed(), true);
		Assert.assertEquals(EmailLoginPage.isLogoDisplayed(), true);
		Assert.assertEquals(EmailLoginPage.isGoogleSignInDisplayed(), true);
		softAssert.assertEquals(EmailLoginPage.textTypedInEmail(), prop.getProperty("email"));//sometimes captcha appears here
		passwordLoginPage = EmailLoginPage.continueToPassword();
		Assert.assertTrue(passwordLoginPage instanceof LoginPagePassword, "Expected instance of LoginPagePassword not there");

		passwordLoginPage.typePassword(prop.getProperty("password"));
		
		//password login page
		Assert.assertEquals(passwordLoginPage.enteredEmailVerification(),prop.getProperty("email"),"Email is not Correct on password page");
		Assert.assertTrue(passwordLoginPage.verifySignInBtnVisible(),"Continue Button visible");
		Assert.assertEquals(passwordLoginPage.verifyTypedPassword(),prop.getProperty("password"));
		Thread.sleep(1000);
		passwordLoginPage.clickSignIn();
		
		//Homepage
		System.out.println(prop.getProperty("productName"));
		searchListPage = homePage.searchProductFromHomePage(prop.getProperty("productName"));
		
		//search list page
		searchListPage.filterProductByOnlyBuyNowCategory();
		Assert.assertTrue(searchListPage.isLogoDisplayed());
		Assert.assertTrue(searchListPage.getTitle().contains(prop.getProperty("productName")));
		
		//product page
		productPage = searchListPage.clickOnProduct();
		try {
			productPage.selectOption();
		}catch (Exception e) {
			
		}
		Assert.assertTrue(productPage.isAddToCartVisibile(),"Add To Cart not Visble");
		String price = productPage.getProductPrice();
		System.out.println(price);
		checkOutPage = productPage.clickOnBuyNow();
		
		//checkout page
		checkOutPage.selectGpayOption();
//		checkOutPage.selectConversionBtn();
		checkOutPage.clickOnSubmitBtn();
	}
	
//	
//	@Test(priority=2)
//	public void EnterEmailTest() {
//		loginPagePassword = loginPage.login(prop.getProperty("email"));
//	}
//	
//	@Test(priority = 3)
//	public void enterPasswordTest() {
//		homePage= loginPagePassword.typePasswordAndSignIn(prop.getProperty("password"));
//	}
//	
//	@Test(priority = 4)
//	public void searchPageTest() {
//		searchListPage = homePage.searchProductFromHomePage(prop.getProperty("product"));
//	}
//	
	@AfterMethod
	public void tearMethod() throws InterruptedException {
//		Thread.sleep(3000);
//		driver.quit();
	}
	
}
