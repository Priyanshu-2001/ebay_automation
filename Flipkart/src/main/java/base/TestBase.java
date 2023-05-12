package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import myUtility.TestUtils;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:\\Users\\Paritosh.Sharma\\eclipse-workspace\\Flipkart\\src\\main\\java\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void init() {
		String browser = prop.getProperty("browser");
		System.out.println(browser);
		if(browser.equals("chrome")) {
			System.setProperty("webDriver.Chrome.driver","C:\\Users\\Paritosh.Sharma\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver","C:\\Users\\Paritosh.Sharma\\Downloads\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.IMPLICIT_WAIT));
		driver.get(prop.getProperty("url"));
	}
}
