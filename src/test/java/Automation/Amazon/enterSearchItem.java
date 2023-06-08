package Automation.Amazon;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestComponents.BaseTest;

public class enterSearchItem extends BaseTest{
	
	@Test(groups= {"searchItem"})
	public void amazonLogo() throws InterruptedException {
		// search an item in the search bar
		prodList.searchItem();
		
		//select high to low from the dropdown
		Select se = new Select(search.sortByPrice());
		se.selectByVisibleText("Price: High to Low");
		
		Thread.sleep(2000);
		// display all the prices in descending order
		for (int i = 0; i < search.getPrices().size()-1; i++) {
			System.out.println(search.getPrices().get(i));
			if (search.getPrices().get(i) < search.getPrices().get(i+1)) {
				
				System.out.println("The items are not in sorted order");
				break;
			}
		}
	}

}
