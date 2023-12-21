package PracticeSelenium.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PracticeSelenium.AbstractComponents.AbstractComponent;

public class landingPage extends AbstractComponent{
	
	WebDriver driver;
	
	public landingPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	
	@FindBy(linkText="Sign In")
	WebElement SignInCTA;
	
	@FindBy(id="email")
	WebElement userEmail;
	
	@FindBy(id="pass")
	WebElement password;
	
	@FindBy(xpath="//fieldset[@class='fieldset login']//button[@id='send2']")
	WebElement loginCTA;
	
	@FindBy(css="a[id='ui-id-5'] span:nth-child(2)")
	WebElement mp;
	
	@FindBy(linkText="Create an Account")
	WebElement CreateAccount;
	
	@FindBy(className="switch")
	WebElement chevronCTA;
	
	@FindBy(linkText="My Account")
	WebElement MyAccountCTA;
	
	@FindBy(xpath="//a[@class='block-promo home-t-shirts']")
	WebElement MixnMatch;
	
	@FindBy (xpath="//div[@class='page-wrapper']")
	WebElement page;
	
	@FindBy(xpath="//div[@class='product-item-info']")
	List<WebElement> prodPanel;
	

	
	public menProductPage login(String email, String pass) 
	{
		SignInCTA.click();
		userEmail.sendKeys(email);
		password.sendKeys(pass);
		loginCTA.click();
		
		menProductPage mp = new menProductPage(driver);
		return mp;
	}
	
	public void goTo() 
	{
		driver.get("https://magento.softwaretestingboard.com");
	}
	
	public void menProduct() 
	{
		mp.click();
	}
	
	public registrationPage createAccount() 
	{
		CreateAccount.click();
		registrationPage rp = new registrationPage(driver);
		return rp;
	}
	
	public myAccountPage AccountPage() 
	{
		chevronCTA.click();
		MyAccountCTA.click();
		myAccountPage map = new myAccountPage(driver);
		return map;
	}
	
	public Object sizeCheck() 
	{
		Object MMSize =	MixnMatch.getSize();
		return MMSize;
	}
	
	public String backgroundColor() 
	{
		String 	BGcolor = page.getCssValue("color");
		return BGcolor;
	}
	
	public int NumProducts() 
	{
	int ProductsPresent =	prodPanel.size();
	return ProductsPresent;
		
	}
}
