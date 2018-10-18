package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserRegistrationHomePage {
	
	WebDriver driver;
	
	public UserRegistrationHomePage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	By homePageText = By.cssSelector("body > div.jumbotron > div > div > div > h1");
	
	public WebElement homePage() {
		return driver.findElement(homePageText);
		
	}
	public String gethomePage() {
		return driver.findElement(homePageText).getText();
		
	}

}
