package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInitializer {
	WebDriver driver;
	public static final String URL="https://selenium.qabible.in/";
	
	public WebDriver getDriver()
	{
		driver.get(URL);
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeClass
	@Parameters({"browser"})	
	public void browserSelection(@Optional ("chrome") String browserName)
	{
	System.out.println(browserName);	
	
	switch(browserName)
	{
	case "chrome":
	//	System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
		driver=new ChromeDriver();
		break;	
	case "firefox":
		System.setProperty("webdriver.firefox.driver",System.getProperty("user.dir")+"/src/main/resources/geckodriver.exe");
		driver=new FirefoxDriver();
		break;
	case "edge":
		System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"/src/main/resources/msedgedriver.exe");
		driver=new EdgeDriver();
		break;
	default:
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
			driver=new ChromeDriver();
	}	
	}	
/*
@AfterTest
	public void browserclose()
	{
		driver.quit();
	}
	*/
}
