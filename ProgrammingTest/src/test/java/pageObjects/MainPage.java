package pageObjects;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MainPage extends CustomStepsPage {

	public MainPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(css = "[id*='lbl_val']")
	private List<WebElement> valueLabelList;
	
	@FindBy(css = "[id*='txt_val']")
	private List<WebElement> valueList;
	
	@FindBy(id = "lbl_ttl_val")
	private WebElement totalvalueLabel;
	
	@FindBy(id ="txt_ttl_val")
	private WebElement totalValue;
	
	
	public void ValidateTheValuesOnPage(WebDriver driver, int valueCount) {
		
		Assert.assertEquals(valueLabelList.size(), valueCount, "The Count is not matching");
		
		Assert.assertEquals(valueList.size(), valueCount, "The Count is not matching");
		
	}
	
	public void ValidateTheValuesGreaterThanZero(WebDriver driver, int numValue) throws ParseException {
		
		NumberFormat form = NumberFormat.getCurrencyInstance();
		for (WebElement value : valueList) {
			String currencyValue = value.getText().trim();
			Number number = form.parse(currencyValue);
			Assert.assertTrue(number.floatValue() > numValue, "The value " + currencyValue + " is not greater than zero");
		}
		String totalBal = totalValue.getText().trim();
		Number number = form.parse(totalBal);
		Assert.assertTrue(number.floatValue() > numValue, "The Total value is not greater than zero");
		
	}
	
	public void ValidateTotalBalance(WebDriver driver) throws ParseException {
		float totalVal = 0;
		NumberFormat format = NumberFormat.getCurrencyInstance();
		for (WebElement value : valueList) {
			String currencyValue = value.getText().trim();
			Number currencyValueNumber = format.parse(currencyValue);
			totalVal += currencyValueNumber.floatValue();
		}
		String totalBal = totalValue.getText().trim();
		Number totalBalanceNumber = format.parse(totalBal);
		Assert.assertEquals(totalVal, totalBalanceNumber.floatValue(), "Balance is incorrect");
	}
	
	public void ValidateTheValuesAreFormatted(WebDriver driver) {
		for (WebElement value : valueList) {
			String currencyValue = value.getText().trim();
			boolean b = Pattern.matches("^\\$[0-9]{1,3}(\\,[0-9]{3})*\\.[0-9]{2}$", currencyValue);
			Assert.assertTrue(b, "Value " + currencyValue + " is not formatted as currency");
		}
		String totalBal = totalValue.getText().trim();
		boolean b = Pattern.matches("^\\$[0-9]{1,3}(\\,[0-9]{3})*\\.[0-9]{2}$", totalBal);
		Assert.assertTrue(b, "Total balance value is not formatted as currency");
	}
	
	public void ValidateTheTotalBalanceAgainstSum(WebDriver driver) throws ParseException {
		float totalVal = 0;
		NumberFormat format = NumberFormat.getCurrencyInstance();
		for (WebElement value : valueList) {
			String currencyValue = value.getText().trim();
			Number currencyValueNumber = format.parse(currencyValue);
			totalVal += currencyValueNumber.floatValue();
		}
		String totalBal = totalValue.getText().trim();
		Number totalBalanceNumber = format.parse(totalBal);
		Assert.assertEquals(totalVal, totalBalanceNumber.floatValue(), "Total sum against balance is incorrect");
	}
	
	
}



