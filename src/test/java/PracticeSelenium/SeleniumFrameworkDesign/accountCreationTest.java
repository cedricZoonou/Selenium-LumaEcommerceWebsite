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
import PracticeSelenium.pageobjects.myAccountPage;
import PracticeSelenium.pageobjects.registrationPage;
import graphql.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class accountCreationTest extends baseTest {

	
	
	
	@Test(dataProvider="getData", groups= {"NewCustomers"})
	public void accountCreation(HashMap<String, String> input) throws InterruptedException, IOException {
		// login and wait for page to load
		registrationPage rp = lp.createAccount();
		myAccountPage map = rp.createNewCustomerAccount(input.get("firstName"), input.get("lastName"), input.get("email"), input.get("password"));
		String confirmMessage = map.accountCreationConfirmation();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thank you for registering with Fake Online Clothing Store."));
	}
	
	
	
	
	@DataProvider
	public Object[] [] getData() throws IOException
	{
	List<HashMap<String, String>> data =	getJsonDataToMap(System.getProperty("user.dir")+ "\\src\\test\\java\\PracticeSelenium\\data\\NewCustomer.json");
	return	new Object[][] {{data.get(0)}, {data.get(1)}};                                 
	}

}
