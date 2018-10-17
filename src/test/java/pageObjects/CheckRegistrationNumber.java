package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckRegistrationNumber {

	WebDriver driver;

	public CheckRegistrationNumber(WebDriver driver) {
		this.driver = driver;
	}

	By registrationNumber = By.id("Vrm");
	By submit = By.name("Continue");

	public WebElement enterRegistration() {
		return driver.findElement(registrationNumber);
	}

	public WebElement submitRegDetails() {
		return driver.findElement(submit);
	}

}
