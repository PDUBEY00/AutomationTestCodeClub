package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.CheckRegistrationNumber;
import pageObjects.ConfirmDetails;
import pageObjects.ViewVehicleDetails;

public class Stepdefinition_CarDetails {

	WebDriver driver;

	@Given("^Vehicle inquiry page is available$")
	public void vehicle_inquiry_page_is_available() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://vehicleenquiry.service.gov.uk/");

	}

	@When("^user enters car \"([^\"]*)\" details$")
	public void user_enters_car_details(String regNo) throws Throwable {
		CheckRegistrationNumber checkRegistartion = new CheckRegistrationNumber(driver);
		checkRegistartion.enterRegistrationNo(regNo);;
		checkRegistartion.submitRegDetails();

	}

	@When("^Confirms the details are correct$")
	public void confirms_the_details_are_correct() throws Throwable {
		ConfirmDetails confirmDetails = new ConfirmDetails(driver);
		confirmDetails.confirmRegDetails();
		confirmDetails.submitRegDetails();

	}

	@Then("^details of car should be displayed which are \"([^\"]*)\" and tax due date is \"([^\"]*)\"$")
	public void details_of_car_should_be_displayed_which_are_and_tax_due_date_is(String expectedReg, String taxDueOn) throws Throwable {
		ViewVehicleDetails viewVehicleDetails = new ViewVehicleDetails(driver);
		String actualReg = viewVehicleDetails.registrationNumberDetails().getText();
		String taxDueDate = viewVehicleDetails.taxDueDetails().getText();
		boolean checkTaxDueDate = taxDueDate.contains(taxDueOn);
		assertTrue("Incorrect Details", checkTaxDueDate);
		System.out.println(taxDueDate);
		assertEquals("Scenario failed", expectedReg, actualReg);
	
	}
	
	@After
	public void close() {
		driver.quit();
	}

}
