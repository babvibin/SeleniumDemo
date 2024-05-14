package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormSubmit {
	WebDriver driver;
	public FormSubmit(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "validationCustom01")
	WebElement firstName;
	
	@FindBy(id = "validationCustom02")
	WebElement lastName;
	
	@FindBy(id = "validationCustomUsername")
	WebElement userName;
	
	@FindBy(id = "validationCustom03")
	WebElement city;
	
	@FindBy(id = "validationCustom04")
	WebElement state;
	
	@FindBy(id = "validationCustom05")
	WebElement zip;
	
	@FindBy(className = "form-check-label")
	WebElement termsAndConditionsCheckBox;
	
	@FindBy(xpath = "//button[contains(@class,'btn btn-primary')]")
	WebElement submitFormButton;
	
	@FindBy(id = "message-one")
	WebElement submittedSuccessfullyMessage;
	
	@FindBy(xpath = "//label[contains(@class,'form-check-label')]/following-sibling::div")
	WebElement checkboxValidationMessage;
	
	public void enterFirstName(String firstNameValue)
	{
		firstName.sendKeys(firstNameValue);
	}
	
	public void enterLastName(String lastNameValue)
	{
		lastName.sendKeys(lastNameValue);
	}	
	
	public void enterUserName(String userNameValue)
	{
		userName.sendKeys(userNameValue);
	}
	
	public void enterCity(String cityValue)
	{
		city.sendKeys(cityValue);
	}
	
	public void enterState(String stateValue)
	{
		state.sendKeys(stateValue);
	}	
	
	public void enterZip(long zipValue)
	{
		zip.sendKeys(String.valueOf(zipValue));
	}
	
	public void selectTermsAndConditionsCheckBox()
	{
		termsAndConditionsCheckBox.click();
	}
	
	public void clickSubmitFormButton()
	{
		submitFormButton.click();
	}
	
	public String displaySubmittedSuccessfullyMessage()
	{
		String successMessage=submittedSuccessfullyMessage.getText();
		return successMessage;
	}
	
	public String displaycheckboxValidationMessage()
	{
		String validationMessage=checkboxValidationMessage.getText();
		return validationMessage;
	}

}
