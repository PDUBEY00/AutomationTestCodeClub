package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.UserRegistration;
import pageObjects.UserRegistrationHomePage;

public class Stepdefinition_UserReg {

	WebDriver driver;

	@Given("^Webpage is launched$")
	public void webpage_is_launched() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.way2automation.com/angularjs-protractor/registeration/#/login");

	}

	@After
	public void close() {
		driver.quit();
	}

}
