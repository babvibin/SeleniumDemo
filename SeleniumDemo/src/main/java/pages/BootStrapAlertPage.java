package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BootStrapAlertPage {
	WebDriver driver;
	public BootStrapAlertPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "autoclosable-btn-success")
	WebElement autoclosableSuccessButton;
	
	@FindBy(id = "normal-btn-success")
	WebElement normalSuccessButton;
	
	@FindBy(id = "autoclosable-btn-warning")
	WebElement autoclosableWarningButton;
	
	@FindBy(id = "normal-btn-warning")
	WebElement normalWarningButton;	
	
	@FindBy(id = "autoclosable-btn-danger")
	WebElement autoclosableDangerButton;	
	
	@FindBy(id = "normal-btn-danger")
	WebElement normalDangerButton;	
	
	@FindBy(id = "autoclosable-btn-info")
	WebElement autoclosableInfoButton;	
	
	@FindBy(id = "normal-btn-info")
	WebElement normalInfoButton;	
	
	@FindBy(xpath = "//div[@class='col-md-6']/child::div[2]")
	WebElement normalSuccessMessage;
	
	
	public void clickAutoclosableSuccessButton()
	{
		autoclosableSuccessButton.click();
	}
	
	public void clickNormalSuccessButton()
	{
		normalSuccessButton.click();
	}
	
	public void clickAutoclosableWarningButton()
	{
		autoclosableWarningButton.click();
	}
	
	public void clickNormalWarningButton()
	{
		normalWarningButton.click();
	}
	
	public void clickAutoclosableDangerButton()
	{
		autoclosableDangerButton.click();
	}
	
	public void clickNormalDangerButton()
	{
		normalDangerButton.click();
	}
	
	public void clickAutoclosableInfoButton()
	{
		autoclosableInfoButton.click();
	}	
	
	public void clickNormalInfoButton()
	{
		normalInfoButton.click();
	}
	
	public String normalSuccessMessage()
	{
		String normalSuccessMessageText=normalSuccessMessage.getText();
		return normalSuccessMessageText;
	}	
}
