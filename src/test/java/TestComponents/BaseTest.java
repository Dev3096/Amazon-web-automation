package TestComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import Automation.Amazon.pageObjects.productList;
import Automation.Amazon.pageObjects.searchPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected WebDriver driver;
	protected productList prodList;
	protected searchPage search;
	public WebDriver initializeDriver() throws IOException {
		
		// properties class
		Properties prop = new Properties();
		//FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\GlobalData.properties");
		
		FileInputStream fis = new FileInputStream("D:\\Eclips workspace\\Amazon\\src\\test\\java\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if (browserName.equals("firefox")) {
			//firefox
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		} else if (browserName.equals("edge")) {
			// edge
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public productList launchApp() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.manage().window().fullscreen();
		prodList = new productList(driver);
		search = new searchPage(driver);
		prodList.goTo();
		Thread.sleep(2000);
		return prodList;
	}
	
//	@AfterMethod(alwaysRun=true)
//	public void closeBrowser() {
//		driver.close();
//	}
	

	
}
