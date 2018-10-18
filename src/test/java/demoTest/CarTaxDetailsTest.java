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

import pageObjects.CheckRegistrationNumber;
import pageObjects.ConfirmDetails;
import pageObjects.ViewVehicleDetails;

public class CarTaxDetailsTest {

	WebDriver driver;
	CheckRegistrationNumber checkRegistartion;
	ConfirmDetails confirmDetails;
	ViewVehicleDetails viewVehicleDetails;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		checkRegistartion = new CheckRegistrationNumber(driver);
		confirmDetails = new ConfirmDetails(driver);
		viewVehicleDetails = new ViewVehicleDetails(driver);
		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void testGooglePage() {
		driver.get("http://www.google.com");
		String pageTitle = driver.getTitle();
		System.out.println("Page Title is :" + pageTitle);
		assertEquals("Incorrect Title", "Google", pageTitle);
		driver.quit();
	}

	@Test
	public void testVehicleInformationFromDvla() throws InterruptedException {

		driver.get("https://www.gov.uk/get-vehicle-information-from-dvla");
		driver.findElement(By.xpath("/html/body/div[5]/div[2]/main/div/div[1]/div/section[1]/p/a")).click();
		System.out.println("Now entering value");
		driver.findElement(By.id("Vrm")).sendKeys("GU18SCZ");
		driver.findElement(By.name("Continue")).click();
		driver.findElement(By.id("Correct_True")).click();
		driver.findElement(By.name("Continue")).click();
		String actualReg = driver.findElement(By.className("reg-mark")).getText();
		String taxDue = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[1]/p/strong")).getText();
		assertEquals("Scenario failed", "GU18 SCZ", actualReg);
		assertEquals("Incorrect Tax details", "Tax due:\n" + "01 March 2019", taxDue);

	}

	@Test
	@Ignore
	public void testVehicleInformationUsingPageObject() {
		driver.get("https://vehicleenquiry.service.gov.uk/");
		checkRegistartion.enterRegistrationNo("GU18 SCZ");
		checkRegistartion.submitRegDetails();
		confirmDetails.confirmRegDetails();
		confirmDetails.submitRegDetails();
		String actualReg = viewVehicleDetails.registrationNumberDetails().getText();
		String taxDue = viewVehicleDetails.taxDueDetails().getText();
		assertEquals("Scenario failed", "GU18 SCZ", actualReg);
		assertEquals("Incorrect Tax details", "Tax due:\n" + "01 March 2019", taxDue);
	}

	@After
	public void close() {
		driver.quit();
	}

}
