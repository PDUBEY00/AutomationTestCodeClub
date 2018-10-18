package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmDetails {
	WebDriver driver;

	public ConfirmDetails(WebDriver driver) {
		this.driver = driver;
	}

	By confirmYes = By.id("Correct_True");
	By confirmNo = By.id("Correct_False");
	By submit = By.name("Continue");

	public WebElement getconfirmRegDetails() {
		return driver.findElement(confirmYes);
	}
	
	public void confirmRegDetails() {
		driver.findElement(confirmYes).click();
	}

	public WebElement incorrectRegDetails() {
		return driver.findElement(confirmNo);
	}

	public void submitRegDetails() {
		driver.findElement(submit).click();
	}

}
