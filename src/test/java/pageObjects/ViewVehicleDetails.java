package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewVehicleDetails {
	WebDriver driver;

	public ViewVehicleDetails(WebDriver driver) {
		this.driver = driver;
	}

	By registrationNumber = By.className("reg-mark");
	By taxDue = By.xpath("/html/body/main/div[2]/div[1]/div[1]/p/strong");
	By mot = By.xpath("/html/body/main/div[2]/div[2]/div[1]/p/strong");

	public WebElement registrationNumberDetails() {
		return driver.findElement(registrationNumber);
	}

	public WebElement taxDueDetails() {
		return driver.findElement(taxDue);
	}

	public WebElement motDetails() {
		return driver.findElement(mot);
	}

}
