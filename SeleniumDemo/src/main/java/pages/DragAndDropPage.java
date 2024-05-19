package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage {
	WebDriver driver;
	Actions actions;
	
	public DragAndDropPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);		
		this.actions=new Actions(driver);
	}
	
	@FindBy(xpath = "//div[@id='todrag']/child::span[text()='Draggable n°1']")
	WebElement sorceElement1;
	
	@FindBy(xpath = "//span[contains(text(),'Draggable n°2')]")
	WebElement sorceElement2;	
	
	@FindBy(xpath = "//span[contains(text(),'Draggable n°3')]")
	WebElement sorceElement3;
	
	@FindBy(xpath = "//span[contains(text(),'Draggable n°4')]")
	WebElement sorceElement4;
	
	@FindBy(id = "mydropzone")
	WebElement targetElement;	
	
	public void dragsAndDropSorceElement1()
	{
		actions.dragAndDrop(sorceElement1, targetElement).build().perform();		
	}
	
	public void dragsAndDropSorceElement2()
	{		
		actions.dragAndDrop(sorceElement2, targetElement).perform();
	}
	
	public void dragsAndDropSorceElement3()
	{		
		actions.dragAndDrop(sorceElement3, targetElement).perform();
	}
	
	public void dragsAndDropSorceElement4()
	{		
		actions.dragAndDrop(sorceElement4, targetElement).perform();
	}	
}
