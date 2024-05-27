package util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadUtil {
	WebDriver driver;
	public FileUploadUtil(WebDriver driver, String sourceFilePath, String buttonXpath) throws AWTException
	{
		this.driver=driver;	
		String filePath = sourceFilePath; 
		Robot robot = new Robot(); 		
		StringSelection stringSelection = new StringSelection(filePath); 		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null); 		 	
		driver.findElement(By.xpath("buttonXpath")).click(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));		
		robot.keyPress(KeyEvent.VK_CONTROL); 		
		robot.keyPress(KeyEvent.VK_V); 		
		robot.keyRelease(KeyEvent.VK_V); 		
		robot.keyRelease(KeyEvent.VK_CONTROL); 		
		robot.keyPress(KeyEvent.VK_ENTER); 		
		robot.keyRelease(KeyEvent.VK_ENTER);		
	}
}
