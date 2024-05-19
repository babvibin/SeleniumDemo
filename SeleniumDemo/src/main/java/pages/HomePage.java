package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Home']")
	WebElement homeMenu;
	
	@FindBy(xpath = "//a[contains(text(),'Input Form')]")
	WebElement inputFormMenu;
	
	@FindBy(xpath = "//a[contains(text(),'Date Pickers')]")
	WebElement datePickersMenu;	
	
	@FindBy(xpath = "//a[contains(text(),'Table')]")
	WebElement tableMenu;		
	
	@FindBy(xpath = "//a[contains(text(),'Progress Bars')]")
	WebElement progressBarMenu;			
	
	@FindBy(xpath = "//a[contains(text(),'Alerts and Modals')]")
	WebElement alertsAndModalsMenu;			
	
	@FindBy(xpath = "//a[contains(text(),'List Box')]")
	WebElement listBoxMenu;	
	
	@FindBy(xpath = "//a[contains(text(),'Others')]")
	WebElement othersMenu;		
	
	public void clickHomeMenu()
	{
		homeMenu.click();
	}
	
	public void clickInputFormMenu()
	{
		inputFormMenu.click();
	}	
	
	public void clickDatePickersMenu()
	{
		datePickersMenu.click();
	}	
	
	public void clickTableMenu()
	{
		tableMenu.click();
	}		
	
	public void clickProgressBarMenu()
	{
		progressBarMenu.click();
	}	

	public void clickAlertsAndModalsMenu()
	{
		alertsAndModalsMenu.click();
	}	
	
	public void clickListBoxMenu()
	{
		listBoxMenu.click();
	}	
	
	public void clickOthersMenu()
	{
		othersMenu.click();
	}	
}
