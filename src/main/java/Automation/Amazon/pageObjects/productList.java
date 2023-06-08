package Automation.Amazon.pageObjects;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class productList extends AbstractComponent{
	WebDriver driver;
	public productList(WebDriver driver) { // constructor
		// Initialization code is written here 
		super(driver); //this needs to be done for every child class
		this.driver=driver; //this.driver Referees to the local class variable
		PageFactory.initElements(driver, this);
	}
	//WebElement userEmail = driver.findElement(By.id("ap_email"));
	
	Properties prop = new Properties();
	
	// PageFactory
	
	@FindBy(css=".p13n-sc-truncated") // shortCut method for the code written at line 14
	List<WebElement> products;
	
	@FindBy(css=".add-to-cart-button")
	WebElement addToCart;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement search;
	
	@FindBy(id="nav-search-submit-button")
	WebElement clickSearch;
	

	
	By products1 = By.cssSelector(".p13n-sc-truncated");
	
	// Action Methods
	public List<WebElement> getProdList() {
		return products;
	}
	
	public WebElement getProdByName(String name) {
		WebElement prod = null;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getText().equals(name)) {
				prod = products.get(i);
				break;
			}
		}
		return prod;
	}
	
	public cartItems addProdToCart(String name) throws InterruptedException {
		getProdByName(name).click();
		Thread.sleep(2000);
		addToCart.click();
		Thread.sleep(2000);
		cartItems items = new cartItems(driver);
		return items;
	}
	
	public void goTo() {
		driver.get("https://www.amazon.com/gp/yourstore/home?path=%2Fgp%2Fyourstore%2Fhome&signIn=1&useRedirectOnSuccess=1&action=sign-out&ref_=nav_AccountFlyout_signout&captcha_verified=1");
	}
	
	public void searchItem() {
		search.sendKeys("games");
		clickSearch.click();
	}
	
	public prevOrders myOrder() {
		prevOrders prev = new prevOrders(driver);
		return prev;
	}

	
	
	
}
