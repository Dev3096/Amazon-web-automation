package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Automation.Amazon.pageObjects.cartItems;
import Automation.Amazon.pageObjects.prevOrders;
import Automation.Amazon.pageObjects.signInPage;

public class AbstractComponent {
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		driver = this.driver;
		PageFactory.initElements(driver, this);
	}

	// resuable code is written in this class
	public void waitForElement(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	@FindBy(id="nav-cart")
	WebElement goToCart;
	
	@FindBy(name="proceedToRetailCheckout")
	WebElement proceedCheckOut;
	
	@FindBy(xpath="//*[@id='nav-orders']/span[1]")
	WebElement orders;
	
	@FindBy(id="ap_email") // shortCut method for the code written at line 14
	WebElement userEmail;
	
	@FindBy(id="continue") // shortCut method for the code written at line 14
	WebElement continueButton;
	
	@FindBy(id="signInSubmit") // shortCut method for the code written at line 14
	WebElement signInButton;
	
	@FindBy(id="ap_password") // shortCut method for the code written at line 14
	WebElement passwordEle;
	
	public void goToCart() {
		goToCart.click();
	}
	
	public void checkOut() {
		proceedCheckOut.click();
	}
	
	
	
	public void prevOrder() {
		orders.click();
		
	}
	
	// Action Methods
		public void loginApplication(String email, String password) {
			userEmail.sendKeys(email);
			continueButton.click();
			passwordEle.sendKeys(password);
			signInButton.click();
			
		}
		
	
	public Integer reverseString(String myStr) {
		String res = "";
		for (int i = myStr.length()-2; i>=0; i--) {
            if (Character.isDigit(myStr.charAt(i))) res += myStr.charAt(i);
            else break;
        }
		StringBuilder build = new StringBuilder();
		build.append(res);
		build.reverse();
		return Integer.parseInt(build.toString());
	}
	

}
