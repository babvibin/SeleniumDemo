package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.WaitUtil;

public class JQueryUiProgress {
	WebDriver driver;
	WaitUtil waitUtil;
	
	public JQueryUiProgress(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "downloadButton")
	WebElement startDownloadButton;
	
	@FindBy(xpath = "//button[contains(text(),'Close') and @class='ui-button ui-corner-all ui-widget']")
	WebElement closeButton;
	
	public void clickStartDownloadBotton()
	{
		startDownloadButton.click();
	}
	
	public void clickCloseButton()
	{
		waitUtil=new WaitUtil(driver);
		waitUtil.explicitWaitVisibilityOfPageElement(closeButton);
		closeButton.click();
	}
}