package Automation.Amazon.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class comparePage extends AbstractComponent{
	WebDriver driver;
	public comparePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".a-size-large")
	WebElement popName;
	
	@FindBy(css=".a-button-close")
	WebElement close;
	
	@FindBy(xpath="//*[@id=\"a-popover-content-2\"]/div/div/div/table/tbody/tr[1]/td[1]/div[4]/a")
	WebElement myElement;
	
	public String getpopName() {
		String name = popName.getText();
		return name;
	}
	
	public void closepopUp() {
		close.click();
	}
	
	public String getELement() {
		return myElement.getText();
	}
	
	

}
