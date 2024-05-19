package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsAndModals {
	WebDriver driver;
	public AlertsAndModals(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Bootstrap Alert')]")
	WebElement bootstrapAlert;
	
	@FindBy(xpath = "//a[contains(text(),'Bootstrap Modal')]")
	WebElement bootstrapModal;
	
	@FindBy(xpath = "//a[contains(text(),'Window Popup')]")
	WebElement windowPopup;	
	
	@FindBy(xpath = "//a[contains(text(),'Progress Bar Modal')]")
	WebElement progressBarModal;
	
	@FindBy(xpath = "//a[contains(text(),'Javascript Alert')]")
	WebElement javascriptAlert;
	
	@FindBy(xpath = "//a[contains(text(),'File Download')]")
	WebElement fileDownload;
	
	public void clickBootstrapAlert()
	{
		bootstrapAlert.click();
	}
	
	public void clickBootstrapModal()
	{
		bootstrapModal.click();
	}	
	
	public void clickWindowPopup()
	{
		windowPopup.click();
	}
	
	public void clickProgressBarModal()
	{
		progressBarModal.click();
	}
	
	public void clickJavascriptAlert()
	{
		javascriptAlert.click();
	}	
	
	public void clickFileDownload()
	{
		fileDownload.click();
	}	
}
