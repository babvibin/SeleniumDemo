package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Table {
	WebDriver driver;
	public Table(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Table with Pagination')]")
	WebElement tableWithPagination;
	
	@FindBy(xpath = "//a[contains(text(),'Table Sort And Search')]")
	WebElement tableSortAndSearch;
	
	@FindBy(xpath = "//a[contains(text(),'Table Filter')]")
	WebElement tableFilter;
	
	@FindBy(xpath = "//a[contains(text(),'Table Data Download')]")
	WebElement tableDataDownload;
	
	public void clickTableWithPagination()
	{
		tableWithPagination.click();
	}
	
	public void clickTableSortAndSearch()
	{
		tableSortAndSearch.click();
	}
	
	public void clickTableFilter()
	{
		tableFilter.click();
	}
	
	public void clickTableDataDownload()
	{
		tableDataDownload.click();
	}
}