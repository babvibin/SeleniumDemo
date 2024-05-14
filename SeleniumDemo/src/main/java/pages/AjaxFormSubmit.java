package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.WaitUtil;

public class AjaxFormSubmit {
	WebDriver driver;
	WaitUtil waitUtil;
	
	public AjaxFormSubmit(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "subject")
	WebElement subjectText;
	
	@FindBy(id = "description")
	WebElement descriptionText;
	
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	WebElement submitButton;
	
	@FindBy(id = "message-one")
	WebElement successMessage;
	
	@FindBy(xpath = "//div[contains(text(),'Form has been submitted successfully!')]")
	WebElement finalMessage;
	
	
	public void enterSubjectText(String subjectTextValue)
	{
		subjectText.sendKeys(subjectTextValue);
	}
	
	public void enterDescriptionText(String descriptionTextValue)
	{
		descriptionText.sendKeys(descriptionTextValue);
	}
	
	public void submitButtonClick()
	{
		submitButton.click();		
	}
	
	public String successMessageDisplay()
	{
		waitUtil=new WaitUtil(driver);
		waitUtil.fluentWaitTextToBePresentInElement(successMessage, "Form has been submitted successfully!");		
		String actualMessage=successMessage.getText();
		return actualMessage;
	}
}
