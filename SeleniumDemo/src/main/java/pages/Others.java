package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Others {
	WebDriver driver;
	public Others(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath = "//a[contains(text(),'Drag and Drop')]")
	WebElement dragAndDrop;
	
	public void clickDragAndDrop()
	{
		dragAndDrop.click();
	}
}
