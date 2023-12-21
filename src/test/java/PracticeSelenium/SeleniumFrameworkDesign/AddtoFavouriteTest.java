package PracticeSelenium.SeleniumFrameworkDesign;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PracticeSelenium.TestComponents.baseTest;
import PracticeSelenium.pageobjects.landingPage;
import PracticeSelenium.pageobjects.menProductPage;
import PracticeSelenium.pageobjects.myAccountPage;
import PracticeSelenium.pageobjects.registrationPage;
import graphql.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;



public class AddtoFavouriteTest extends baseTest {
	
	@Test(dataProvider="getData", groups= {"Purchase"}, retryAnalyzer=PracticeSelenium.TestComponents.Retry.class)
	
	
	public void AddItemToFavourite (HashMap<String, String> input)
	{	
		
		menProductPage mp = lp.login(input.get("email"), input.get("password"));
		lp.menProduct();
		
	}	
	
	
	@DataProvider
	public Object[] [] getData() throws IOException
	{
	List<HashMap<String, String>> data =	getJsonDataToMap(System.getProperty("user.dir")+ "\\src\\test\\java\\PracticeSelenium\\data\\PurchaseOrder.json");
	return	new Object[][] {{data.get(0)}, {data.get(1)}};                                 
	}
}
