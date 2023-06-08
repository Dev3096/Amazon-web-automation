package Automation.Amazon.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class prevOrders extends AbstractComponent{
	WebDriver driver;
	public prevOrders(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="time-filter")
	WebElement yearSelect;
	
	@FindBy(xpath="//*[@id=\"ordersContainer\"]/div[3]/div[2]/div/div[2]/div/div[1]/div/div/div/div[2]/div[1]/a")
	WebElement order;
	
	@FindBy(id="searchOrdersInput")
	WebElement search;
	
	@FindBy(xpath="//*[@id=\"ordersContainer\"]/div[3]/div[1]/div/div/div/div[2]/div[2]/ul/a[2]")
	WebElement invoice;
	
	@FindBy(xpath="/html/body/center[1]/a")
	WebElement print;
	
	@FindBy(xpath="//*[@id=\"sidebar\"]//print-preview-button-strip//div/cr-button[1]")
	WebElement savePDF;
	
	public WebElement mySelect() {
		return yearSelect;
	}
	
	public String recentOrder() {
		return order.getText();
	}
	
	public void enterSearch() {
		search.sendKeys("Dev");
	}
	
	public void clickInvoice() {
		invoice.click();
	}
	
	public void clickPrint() {
		print.click();
	}
	
	
	

}
