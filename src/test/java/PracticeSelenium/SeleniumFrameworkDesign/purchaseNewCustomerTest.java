package PracticeSelenium.SeleniumFrameworkDesign;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PracticeSelenium.TestComponents.baseTest;
import PracticeSelenium.pageobjects.checkoutPage;
import PracticeSelenium.pageobjects.checkoutShipping;
import PracticeSelenium.pageobjects.confirmationOrderPage;
import PracticeSelenium.pageobjects.landingPage;
import PracticeSelenium.pageobjects.menProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class purchaseNewCustomerTest extends baseTest {
	
	
	@Test(dataProvider="getData", groups= {"NewCustomers"})
	public void purchaseNewCustomer(HashMap<String, String> input) throws IOException, InterruptedException {
		menProductPage mp = lp.login(input.get("email"), input.get("password"));
		lp.menProduct();
		List<WebElement> products =	mp.getProductList();
		checkoutShipping cs = mp.addToCartNC(input.get("product"));
		checkoutPage cp = cs.Address(input.get("address"), input.get("city"), input.get("zip"), input.get("phone"));
		confirmationOrderPage cop = cp.NewCustomerConfirmOrder();
		cop.getOrderNumber();
	}
	
	@DataProvider
	public Object[] [] getData() throws IOException
	{
	List<HashMap<String, String>> data =	getJsonDataToMap(System.getProperty("user.dir")+ "\\src\\test\\java\\PracticeSelenium\\data\\NewCustomer.json");
	return	new Object[][] {{data.get(0)}, {data.get(1)}};                                 
	}
}
