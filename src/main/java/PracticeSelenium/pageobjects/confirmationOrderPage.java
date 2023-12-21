package PracticeSelenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PracticeSelenium.AbstractComponents.AbstractComponent;

public class confirmationOrderPage extends AbstractComponent{
	
	WebDriver driver;

	public confirmationOrderPage(WebDriver driver) {
		//Initialisation
				super(driver);
				this.driver = driver;
				PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath ="//a[@class='order-number']")
	WebElement orderNumber;

	public String getOrderNumber() 
	{
	
	String ON = orderNumber.getText();
	return ON;
	
	}
	

}
