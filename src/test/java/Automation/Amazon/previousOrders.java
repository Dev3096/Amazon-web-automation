package Automation.Amazon;

import java.util.Set;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import Automation.Amazon.pageObjects.prevOrders;

import TestComponents.BaseTest;

public class previousOrders extends BaseTest{
	
	@Test(groups= {"order"})
	public void prevOrders() throws InterruptedException {
		
		// navigate to product list page
		prodList.goTo();
		
		// click on orders link
		prodList.prevOrder();
		prevOrders myprev = prodList.myOrder();
		
		Thread.sleep(2000);
		
		// login using valid credentials
		prodList.loginApplication("dgoel4@hawk.iit.edu", "Codadvance@2");
		System.out.println(driver.getTitle());
		Thread.sleep(4000);
		
		//myprev.enterSearch();
		//select 2022 from the dropdown
		Select se = new Select(myprev.mySelect());
		se.selectByVisibleText("2022");
		
		Thread.sleep(2000);
		
		// verify the previous order
//		String myorder = "Zinus Callie 14 Inch Classic SmartBase Mattress Foundation / "
//				+ "Platform Bed Frame / Box Spring Replacement / Quiet Noise-Free / Under-bed Storage, Twin ";
//		Assert.assertTrue(myprev.recentOrder().contains(myorder));
		
		// click on invoice
		myprev.clickInvoice();
		
		Thread.sleep(2000);
		
		//click on print
		myprev.clickPrint();

		
	}

}
