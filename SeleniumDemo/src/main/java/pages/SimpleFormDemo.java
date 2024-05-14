package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpleFormDemo {
	WebDriver driver;
	public SimpleFormDemo(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "single-input-field")
	WebElement messageTextBox;
	
	@FindBy(xpath = "//button[contains(@id,'button-one')]")
	WebElement showMessageButton;
	
	@FindBy(id = "message-one")
	WebElement yourMessageText;
	
	@FindBy(id = "value-a")
	WebElement valueATextBox;
	
	@FindBy(id = "value-b")
	WebElement valueBTextBox;
	
	@FindBy(id = "button-two")
	WebElement getTotalButton;	
	
	@FindBy(id = "message-two")
	WebElement totalText;		
	
	public void enterMessage(String message)
	{
		messageTextBox.sendKeys(message);			
	}
	
	public void showMessageButtonClick()
	{
		showMessageButton.click();
	}
	public String yourMessageTextVerify()
	{
		String messageTextValue = yourMessageText.getText();
		return messageTextValue;
	}

	public void enterValueA(long valueA)
	{
		valueATextBox.sendKeys(String.valueOf(valueA));
	}
	
	public void enterValueB(long valueB)
	{
		valueBTextBox.sendKeys(String.valueOf(valueB));		
	}	
	
	public void getTotalButtonClick()
	{
		getTotalButton.click();
	}
	
	public String totalTextVerify()
	{
		String totalTextValue = totalText.getText();
		return totalTextValue;
	}
	
}
