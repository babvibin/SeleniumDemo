package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InputForm {
	WebDriver driver;
	public InputForm(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath = "//a[contains(text(),'Simple Form Demo')]")
	WebElement simpleFormDemo;
	
	@FindBy(xpath = "//a[contains(text(),'Checkbox Demo')]")
	WebElement checkBoxDemo;	
	
	@FindBy(xpath = "//a[contains(text(),'Radio Buttons Demo')]")
	WebElement radioButtonsDemo;	
	
	@FindBy(xpath = "//a[contains(text(),'Select Input')]")
	WebElement selectInput;	
	
	@FindBy(xpath = "//a[contains(text(),'Form Submit')]")
	WebElement formSubmit;		
	
	@FindBy(xpath = "//a[contains(text(),'Ajax Form Submit')]")
	WebElement ajaxFormSubmit;	
	
	@FindBy(xpath = "//a[contains(text(),'Jquery Select2')]")
	WebElement jquerySelect;	
	
	
	public void clickSimpleFormDemo()
	{
		simpleFormDemo.click();
	}
	public void clickCheckBoxDemo()
	{
		checkBoxDemo.click();
	}
	public void clickRadioButtonsDemo()
	{
		radioButtonsDemo.click();
	}
	public void clickSelectInput()
	{
		selectInput.click();
	}
	public void clickFormSubmit()
	{
		formSubmit.click();
	}
	public void clickAjaxFormSubmit()
	{
		ajaxFormSubmit.click();
	}
	public void clickJquerySelect()
	{
		jquerySelect.click();
	}
}
