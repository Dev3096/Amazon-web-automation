package Automation.Amazon;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Automation.Amazon.pageObjects.cartItems;
import Automation.Amazon.pageObjects.comparePage;
import Automation.Amazon.pageObjects.productList;
import Automation.Amazon.pageObjects.signInPage;
import TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class standAloneTest extends BaseTest{
	String prodName = "Sparkling ICE, Black Raspberry Sparkling Water, Zero Sugar…";
	String prodName1 = "Starbucks K-Cup Coffee Pods—Medium Roast Coffee—Pike…";
	String prodValidation = "Sparkling ICE, Black Raspberry Sparkling Water, Zero Sugar";
	@Test(groups= {"inCart"})
	public void submitOrder() throws IOException, InterruptedException {
		// test case to select a given element from the UI and add it to cart
		Thread.sleep(2000);
		// get all the elements visible and add to cart
		List<WebElement> products = prodList.getProdList();
		Thread.sleep(2000);
		cartItems items = prodList.addProdToCart(prodName);
		Thread.sleep(2000);
		prodList.goToCart();
		
		// get all the elements in the cart
		List<WebElement> myCart = items.getCartElements(); 
		System.out.println(myCart.size());
		
		//check if correct element is added to the cart
		prodValidation = "Sparkling ICE, Black Raspberry Sparkling Water, Zero Sugar";
		Assert.assertTrue(myCart.get(0).getText().contains(prodValidation));
		
		signInPage signIn = items.displayCartElements();
		
		//proceed to checkout
		items.checkOut();
		
		// login to complete the order
		signIn.loginApplication("devgoel30@gmail.com", "Codadvance@2");
	}
	
	@Test(groups= {"inCart"})
	public void verifyCart() throws InterruptedException {
		// test to increase the quantity by 4 and validate the increased item price
		String quantity = "4";
		cartItems items = prodList.addProdToCart(prodName);
		prodList.goToCart();
		Thread.sleep(2000);
		Select se = new Select(items.selectDrodown());
		se.selectByVisibleText(quantity);
		
		Thread.sleep(2000);
		
		String itemPrice = items.itemPrice();
		String subTotal = items.itemSubTotal();
	
		// assertion to check the total price after increasing the quantity by 4
		Assert.assertEquals(Float.parseFloat(subTotal), Float.parseFloat(quantity) * Float.parseFloat(itemPrice));
		Thread.sleep(2000);
		
	}
	
	@Test(groups= {"inCart"})
	public void verifyError() throws InterruptedException {
		Thread.sleep(2000);
		// get all the elements visible and add to cart
		List<WebElement> products = prodList.getProdList();
		Thread.sleep(2000);
		cartItems items = prodList.addProdToCart(prodName1);
		prodList.goToCart();
		Select se = new Select(items.selectDrodown());
		se.selectByVisibleText("10+");
		
		// get the error message after increasing the quantity
		String error = items.enterQty();
		//System.out.println(error);
		//System.out.println(items.reverseString(error));
		Thread.sleep(2000);
		
		//get the updated quantity after the error is displayed
		String updatedQty = se.getFirstSelectedOption().getText();
		
		// check if the quantity displayed in the error message is updated in the quantity dropdown
		Assert.assertEquals(items.reverseString(error), Integer.parseInt(updatedQty));
		Thread.sleep(2000);
		}
	
	@Test(groups={"inCart"})
	public void compareItems() throws InterruptedException {
		cartItems items = prodList.addProdToCart(prodName);
		prodList.goToCart();
		
		Thread.sleep(2000);
		
		//select compare with similar items link
		comparePage compPage = items.compElement();
		
		Thread.sleep(2000);
		
		// verify that "compare with similar items is popup is displayed"
		Assert.assertEquals(compPage.getpopName(),"Compare with similar items");
		
		Thread.sleep(2000);
		
		//Verify that the selected item is present in the compare popup lists
		Assert.assertTrue(compPage.getELement().contains(prodValidation));
		
		compPage.closepopUp();
		
	}
	
}

