package PracticeSelenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PracticeSelenium.AbstractComponents.AbstractComponent;

public class checkoutPage extends AbstractComponent{
	
WebDriver driver;
	
	
	public checkoutPage(WebDriver driver) 
	{
		//Initialisation
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//input[@name='ko_unique_1']")
	WebElement shippingMethod;
	
	@FindBy(xpath="//button[@class='button action continue primary']")
	WebElement next;
	
	@FindBy (xpath="//button[@title='Place Order']")
	WebElement placeOrder;
	
	
	
	public confirmationOrderPage confirmOrder() throws InterruptedException 
	{
		shippingMethod.click();
		next.click();
		Thread.sleep(3000);
		
		placeOrder.click();
		confirmationOrderPage cop = new confirmationOrderPage(driver);
		return cop;
	}
	
	public confirmationOrderPage NewCustomerConfirmOrder() throws InterruptedException 
	{
		Thread.sleep(3000);
		placeOrder.click();
		confirmationOrderPage cop = new confirmationOrderPage(driver);
		return cop;
	}


}
