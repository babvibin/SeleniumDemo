package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlert {
	WebDriver driver;
	public JavaScriptAlert(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@class='btn btn-success']")
	WebElement clickMeButtonJavaScriptAlertBox;		
	
	@FindBy(xpath = "//button[@class='btn btn-warning']")
	WebElement clickMeButtonJavaScriptConfirmBox;
	
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement clickMeButtonJavaScriptPromptBox;
	
	
	public void clickClickMeButtonJavaScriptAlertBox()
	{
		clickMeButtonJavaScriptAlertBox.click();
	}
	
	public String getTextJavaScriptAlertBox()
	{
		Alert alert1= driver.switchTo().alert(); 
		String javaScriptAlertText=alert1.getText(); 
		return javaScriptAlertText;		
	}
	
	public void closeJavaScriptAlertBox()
	{
		Alert alert1= driver.switchTo().alert(); 
		String alertext=alert1.getText(); 
		alert1.accept(); 
	}
	
	public void clickclickMeButtonJavaScriptPromptBox()
	{
		clickMeButtonJavaScriptPromptBox.click();
	}
	
	public String getTextJavaScriptPromptBox()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Alert alert1= driver.switchTo().alert(); 
		String javaScriptPromptBoxtext=alert1.getText(); 
		return javaScriptPromptBoxtext;				
	}	
	
	public void dismissJavaScriptPromptBox()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Alert alert1= driver.switchTo().alert(); 
		alert1.dismiss();
	}	
	
	public void acceptJavaScriptPromptBox()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Alert alert1= driver.switchTo().alert(); 
		alert1.sendKeys(""); 
		alert1.sendKeys("Hello"); 
		alert1.accept(); 
		
	}
}
