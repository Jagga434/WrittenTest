

package stepDefinitions;

import java.text.ParseException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;

import pageObjects.MainPage;


public class StepDefinitions {
	
	WebDriver driver = Conditions.driver;
	MainPage value = new MainPage(driver);
	private Properties config;
	
	
	@Given("I am on the page https://www.exercise1.com/values ")
	public void ValidatePage() throws InterruptedException {
		Assert.assertEquals("The URL is not the same", config.getProperty("url"), driver.getCurrentUrl());
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I validate that the number of values on the page are {int}")
	public void ValidateValuesOnPage(int valueCount) {
	    
		value.ValidateTheValuesOnPage(driver, valueCount);
		
	    throw new io.cucumber.java.PendingException();
	}

	@And("I validate that the number of values on the page are greater than {int}")
	public void ValidateValuesGreaterThanZero(int numValue) throws ParseException {
	   
		value.ValidateTheValuesGreaterThanZero(driver, numValue);
		
	    throw new io.cucumber.java.PendingException();
	}

	@And("I validate that the total balance of values on the page are correct")
	public void ValidateTheTotalBalance() throws ParseException {
	    
		value.ValidateTotalBalance(driver);
		
	    throw new io.cucumber.java.PendingException();
	}

	@And("I validate that the values on the page are formatted")
	public void ValidateValuesAreFormatted() {
	    
		value.ValidateTheValuesAreFormatted(driver);
		
	    throw new io.cucumber.java.PendingException();
	}

	@And("I validate the total balance matches the sum of values on the page")
	public void ValidateTotalBalanceAgainstSum() throws ParseException {
	    
		value.ValidateTheTotalBalanceAgainstSum(driver);
		
	    throw new io.cucumber.java.PendingException();
	}


}
