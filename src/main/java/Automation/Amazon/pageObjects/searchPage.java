package Automation.Amazon.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class searchPage extends AbstractComponent{
	WebDriver driver;
	public searchPage(WebDriver driver) {
		super(driver);
		this.driver=driver; //this.driver Referees to the local class variable
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="s-result-sort-select")
	WebElement sort;
	
	@FindBy(css=".a-price-whole")
	List<WebElement> prices;
	
	public WebElement sortByPrice() {
		return sort;
	}
	
	public List<Integer> getPrices() {
		List<Integer> priceList = new ArrayList<>();
		String text;
		String newText;
		for (int i = 0; i < prices.size(); i++) {
			text = prices.get(i).getText();
			newText = text.replace(",", "");
			priceList.add(Integer.parseInt(newText));
		}
		return priceList;
	}
	
}
