package PracticeSelenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PracticeSelenium.AbstractComponents.AbstractComponent;

public class checkoutShipping extends AbstractComponent{
	
WebDriver driver;
	
	
	public checkoutShipping(WebDriver driver) 
	{
		//Initialisation
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@name='street[0]']")
	WebElement street;
	
	@FindBy (xpath="//input[@name='city']")
	WebElement City;
	
	@FindBy(xpath="//select[@name='region_id']")
	WebElement region;
	
	@FindBy(xpath="//input[@name='postcode']")
	WebElement postcode;
	
	@FindBy(xpath="//select[@name='country_id']")
	WebElement country;
	
	@FindBy(xpath="//input[@name='telephone']")
	WebElement telephone;
	
	@FindBy(xpath="//input[@name='ko_unique_3']")
	WebElement shippingMethods;
	
	@FindBy(xpath="//button[@class='button action continue primary']")
	WebElement Next;
	
	public checkoutPage Address(String ad, String city, String zip, String phone) 
	{
		street.sendKeys(ad);
		City.sendKeys(city);
		region.click();
		region.sendKeys("A");
		postcode.sendKeys(zip);
		country.click();
		telephone.sendKeys(phone);
		shippingMethods.click();
		Next.click();
		checkoutPage cp = new checkoutPage(driver);
		return cp;
	}
	


}
