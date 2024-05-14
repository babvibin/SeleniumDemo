package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.WaitUtil;

public class WindowPopup {
	WebDriver driver;
	WaitUtil waitUtil;
	
	public WindowPopup(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='btn btn-primary windowSingle']")
	WebElement likeUsOnFacebook;
	
	@FindBy(xpath = "//a[@id='windowMulti']")
	WebElement followAll;
	
	@FindBy(xpath = "//div[@class='xod5an3']/child::div[@class='x78zum5 xdt5ytf xh8yej3']/descendant::input")
	WebElement email;
	
	@FindBy(xpath = "//div[@class='x1c436fg']/child::div[@class='x78zum5 xdt5ytf xh8yej3']/descendant::input")
	WebElement password;
	
	@FindBy(xpath = "//div[@class='x1c436fg']/descendant::span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft x1j85h84']")
	WebElement loginButton;	
	
	@FindBy(xpath = "//div[@aria-label='Close']/i")
	WebElement closeButton;

	@FindBy(xpath = "//h1[contains(text(),'Obsqura Zone')]")
	WebElement obsquraZoneText;
	
	
	public void clicklikeUsOnFacebook()
	{
		likeUsOnFacebook.click();
	}
	
	public void enterEmail(String emailText)
	{
		waitUtil=new WaitUtil(driver);		
		waitUtil.implicitWait(5);
		email.sendKeys(emailText);
	}
	
	public void enterPassword(String passwordTest)
	{
		password.sendKeys(passwordTest);
	}
	
	public void clickLoginButton()
	{
		loginButton.click();		
	}
	
	public void clickCloseButton()
	{
		closeButton.click();
	}
	
	public String getText()
	{
		String PageText= obsquraZoneText.getText();
		System.out.println(PageText);
		return PageText;
	}

}
