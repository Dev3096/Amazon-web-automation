package Automation.Amazon.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class cartItems extends AbstractComponent{
	WebDriver driver;
	public cartItems(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".sc-grid-item-product-title:last-of-type")
	List<WebElement> cartEle;
	
	@FindBy(id="quantity")
	WebElement dropdown;
	
	@FindBy(css=".sc-product-price")
	WebElement prodPrice;
	
	@FindBy(xpath="//*[@id=\"sc-subtotal-amount-buybox\"]/span")
	WebElement subTotal;
	
	@FindBy(css=".a-input-text")
	WebElement qtyText;
	
	@FindBy(xpath="//*[@id=\"a-autoid-2-announce\"]")
	WebElement update;
	
	@FindBy(xpath="//*[@id=\"sc-important-message-alert\"]/div/div/div/p/span")
	WebElement error;
	
	@FindBy(css=".a-color-link")
	List<WebElement> compare;

	
	public List<WebElement> getCartElements() {
		return cartEle;
	}
	
	public signInPage displayCartElements() {
		//getCartElements();
		for (int i = 0; i < cartEle.size(); i++) {
			System.out.println(cartEle.get(i).getText());
		}
		signInPage signIn = new signInPage(driver);
		return signIn;
	}
	
	public WebElement selectDrodown() {
		return dropdown;
	}
	
	public String itemPrice() {
		String myStr = prodPrice.getText();
		return myStr.substring(1,myStr.length());
	}
	
	public String itemSubTotal() {
		String myStr = subTotal.getText();
		return myStr.substring(1,myStr.length());
	}
	
	public String enterQty() throws InterruptedException {
		qtyText.sendKeys("100");
		update.click();
		return error.getText();
	}
	
	public comparePage compElement() {
		compare.get(2).click();
		comparePage cPage = new comparePage(driver);
		return cPage;
	}
	
	

}
