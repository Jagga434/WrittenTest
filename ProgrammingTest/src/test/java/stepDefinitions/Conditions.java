package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Conditions {
	
	
	private Properties config;
	public static WebDriver driver;
	@Before
	public void setup(Scenario scenario) throws IOException {
		config = new Properties();
		FileInputStream ip = new FileInputStream("./Config.properties");
		config.load(ip);
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String baseUrl = config.getProperty("url");
		driver.get(baseUrl);
	}
	
	@After
	
	public void tearDown() {
		driver.quit();
	}
	}


