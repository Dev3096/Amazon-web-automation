package Automation.Amazon.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class signInPage extends AbstractComponent{
	WebDriver driver;
	public signInPage(WebDriver driver) { // constructor
		// Initialization code is written here 
		super(driver);
		this.driver=driver; //this.driver Referees to the local class variable
		PageFactory.initElements(driver, this);
	}
	//WebElement userEmail = driver.findElement(By.id("ap_email"));
	
	// PageFactory
	
//	@FindBy(id="ap_email") // shortCut method for the code written at line 14
//	WebElement userEmail;
//	
//	@FindBy(id="continue") // shortCut method for the code written at line 14
//	WebElement continueButton;
//	
//	@FindBy(id="signInSubmit") // shortCut method for the code written at line 14
//	WebElement signInButton;
//	
//	@FindBy(id="ap_password") // shortCut method for the code written at line 14
//	WebElement passwordEle;
//	
//	// Action Methods
//	public void loginApplication(String email, String password) {
//		userEmail.sendKeys(email);
//		continueButton.click();
//		passwordEle.sendKeys(password);
//		signInButton.click();
		
//	}
	
	
	
	
	
}
