package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgressBars {
	WebDriver driver;
	public ProgressBars(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'JQuery UI Progress')]")
	WebElement jQueryUiProgress;
	
	@FindBy(xpath = "//a[contains(text(),'JQuery UI Progress')]")
	WebElement rangeSliders;
	
	public void clickJQueryUiProgress()
	{
		jQueryUiProgress.click();
	}
	
	public void clickRrangeSliders()
	{
		rangeSliders.click();
	}
}
