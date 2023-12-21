package PracticeSelenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PracticeSelenium.AbstractComponents.AbstractComponent;

public class myAccountPage extends AbstractComponent{
	
	WebDriver driver;
	
	public myAccountPage(WebDriver driver) 
	{
		//Initialisation
				super(driver);
				this.driver = driver;
				PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement AccountConfirmation;
	
	@FindBy(xpath="//a[normalize-space()='My Orders']")
	WebElement myOrdersCTA;
	
	
	public String accountCreationConfirmation() throws InterruptedException 
	{
		
		Thread.sleep(3000);
		return AccountConfirmation.getText();
		

	}
	
	public myOrdersPage goToOrders() 
	{
		myOrdersCTA.click();
		myOrdersPage mop= new myOrdersPage(driver);
		return mop;
		
	}

}
