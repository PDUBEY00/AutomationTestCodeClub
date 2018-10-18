package demoTest;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.UserRegistration;
import pageObjects.UserRegistrationHomePage;

public class TestUserRegistration {

	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	@Ignore
	public void verifyUserRegistration() throws InterruptedException {
		driver.get("http://www.way2automation.com/angularjs-protractor/registeration/#/login");
		// Create Steps to automate user login
		// Enter username
		// Enter password
		// Enter userDesc
		// Click login
		// get home text from home page and asssert the value of text
	}

	@Test @Ignore
	public void verifyUserRegistrationUsingPageObject() {
		UserRegistration userRegistration = new UserRegistration(driver);
		UserRegistrationHomePage userRegistrationHomePage = new UserRegistrationHomePage(driver);
		driver.get("http://www.way2automation.com/angularjs-protractor/registeration/#/login");
		// get username from page Object model
		// get password from page Object model
		// get userDesc from page Object model
		// get login from page Object model
		//// get home text from home page Object model and assert it

	}

	@After
	public void close() {
		driver.quit();
	}

}
