package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomStepsPage {
	
	private WebDriver driver;
	public final static int WAIT_SECONDS = 20;
	
	public CustomStepsPage(WebDriver driver) {
		
	PageFactory.initElements(driver, this);
		this.driver= driver;
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.driver.manage().window().maximize();
		
	}

	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	public void explicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, WAIT_SECONDS);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}

