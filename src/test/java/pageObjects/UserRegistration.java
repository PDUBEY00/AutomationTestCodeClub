package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserRegistration {
	WebDriver driver;

	public UserRegistration(WebDriver driver) {
		this.driver = driver;
	}

	By userName = By.id("username");
	By passWord = By.name("password");
	By userDesc = By.id("formly_1_input_username_0");
	By login = By.xpath("/html/body/div[3]/div/div/div/form/div[3]/button");

	public WebElement getUserName() {
		return driver.findElement(userName);
	}

	public void setUserName(String username) {
		driver.findElement(userName).sendKeys(username);
		;
	}

	public WebElement getPassword() {
		return driver.findElement(passWord);
	}

	public void setPassword(String password) {
		driver.findElement(passWord).sendKeys(password);
		;
	}

	public WebElement getUserDesc() {
		return driver.findElement(userDesc);
	}

	public void setUserDesc(String userdesc) {
		driver.findElement(userDesc).sendKeys(userdesc);
		;
	}

	public WebElement getlogin() {
		return driver.findElement(login);
	}

	public void clickLogin() {
		driver.findElement(login).click();
	}

}
