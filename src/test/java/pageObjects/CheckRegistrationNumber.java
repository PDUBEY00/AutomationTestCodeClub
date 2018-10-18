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

	public WebElement getRegistrationNo() {
		return driver.findElement(registrationNumber);
	}
	public void enterRegistrationNo(String regNo) {
		driver.findElement(registrationNumber).sendKeys(regNo);;
	}

	public WebElement getsubmitRegDetails() {
		return driver.findElement(submit);
	}
	
	public void submitRegDetails() {
		driver.findElement(submit).click();
	}

}
