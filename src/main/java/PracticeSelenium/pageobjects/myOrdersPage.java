package PracticeSelenium.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PracticeSelenium.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;


public class myOrdersPage extends AbstractComponent{
WebDriver driver;
	
	
	public myOrdersPage(WebDriver driver) 
	{
		//Initialisation
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//tbody/tr[1]/td[6]/a[1]")
	WebElement ViewOrderCTA;
	
//	By orderNums = By.xpath("//td[@data-th='Order #']");
	
//	@FindBy ()
//	WebElement orderNumber;
	
	
	
	
	public orderPage ViewLastOrder()
	{
		ViewOrderCTA.click();
		orderPage op = new orderPage(driver);
		return op;
	}
}
