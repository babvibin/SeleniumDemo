package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButton {
	WebDriver driver;
	public RadioButton(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@value='Male' and @name='student-gender']")
	WebElement patientGenderMale;
	
	@FindBy(xpath = "//input[@value='Female' and @name='student-gender']")
	WebElement patientGenderFemale;	
	
	@FindBy(id = "button-two")
	WebElement getResultsButton;
	
	@FindBy(id = "message-two")
	WebElement messageText;	
	
	public void clickPatientGenderMale()
	{
		patientGenderMale.click();
	}

	public void clickPatientGenderFemale()
	{
		patientGenderFemale.click();
	}
	
	public void clickGetResultsButton()
	{
		getResultsButton.click();
	}
	
	public String getMessageText()
	{
		String messageTest= messageText.getText();
		return messageTest;
	}
}