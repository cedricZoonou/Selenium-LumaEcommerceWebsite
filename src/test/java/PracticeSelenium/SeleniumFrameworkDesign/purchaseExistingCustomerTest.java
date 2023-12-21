package PracticeSelenium.SeleniumFrameworkDesign;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PracticeSelenium.TestComponents.baseTest;
import PracticeSelenium.pageobjects.checkoutPage;
import PracticeSelenium.pageobjects.confirmationOrderPage;
import PracticeSelenium.pageobjects.landingPage;
import PracticeSelenium.pageobjects.menProductPage;
import PracticeSelenium.pageobjects.myAccountPage;
import PracticeSelenium.pageobjects.myOrdersPage;
import PracticeSelenium.pageobjects.orderPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class purchaseExistingCustomerTest extends baseTest{
	
	 String orderNumber;
	
	
	@Test(dataProvider="getData", groups= {"Purchase"}, retryAnalyzer=PracticeSelenium.TestComponents.Retry.class)
	public void purchaseExistingCustomer(HashMap<String, String> input) throws IOException, InterruptedException 
	{	
		
		menProductPage mp = lp.login(input.get("email"), input.get("password"));
		lp.menProduct();
		List<WebElement> products =	mp.getProductList();
		checkoutPage cp = mp.addToCart(input.get("product"));
		confirmationOrderPage cop = cp.confirmOrder();
		orderNumber = cop.getOrderNumber();
		
	}
	
	@Test(dataProvider="getData", groups= {"Purchase"})
	public void purchaseExistingCustomerAlt(HashMap<String, String> input) throws IOException, InterruptedException 
	{	
		
		menProductPage mp = lp.login(input.get("email"), input.get("password"));
		lp.menProduct();
		List<WebElement> products =	mp.getProductList();
		checkoutPage cp = mp.addToCartAlt(input.get("product"));
		confirmationOrderPage cop = cp.confirmOrder();
		orderNumber =	cop.getOrderNumber();
	
	}
	
	@Test(dataProvider="getData", groups= {"Purchase"})
	public void MultipleItemsPurchase(HashMap<String, String> input) throws IOException, InterruptedException
	{
		menProductPage mp = lp.login(input.get("email"), input.get("password"));
		lp.menProduct();
		List<WebElement> products =	mp.getProductList();
		mp.addToCart1(input.get("product"));
		checkoutPage cp = mp.addToCart(input.get("product2"));
		confirmationOrderPage cop = cp.confirmOrder();
		orderNumber = cop.getOrderNumber();
	}
	
	@Test(dependsOnMethods= {"purchaseExistingCustomerAlt"}, dataProvider="getData")
	public void OrderHistoryTest(HashMap<String, String> input) 
	{
		
		lp.login(input.get("email"), input.get("password"));
		myAccountPage map = lp.AccountPage();
		myOrdersPage mop = map.goToOrders();
		orderPage op = mop.ViewLastOrder();
		String OrderNum = op.getProductOrdered();
		Assert.assertTrue(OrderNum.equalsIgnoreCase(orderNumber));
		
	}
	
	@DataProvider
	public Object[] [] getData() throws IOException
	{
	List<HashMap<String, String>> data =	getJsonDataToMap(System.getProperty("user.dir")+ "\\src\\test\\java\\PracticeSelenium\\data\\PurchaseOrder.json");
	return	new Object[][] {{data.get(0)}, {data.get(1)}};                                 
	}
	
	
}
