package PracticeSelenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PracticeSelenium.AbstractComponents.AbstractComponent;

public class orderPage extends AbstractComponent{
WebDriver driver;
	
	
	public orderPage(WebDriver driver) 
	{
		//Initialisation
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//strong[@class='product name product-item-name']")
	WebElement ProductOrdered;
	
	@FindBy (xpath="//h1[@class='page-title']")
	WebElement OrderNumber;
	
	public String getProductOrdered() 
	{
		String OrderNum = OrderNumber.getText();
		return OrderNum;
	}

}
