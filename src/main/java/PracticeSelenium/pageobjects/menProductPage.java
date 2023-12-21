package PracticeSelenium.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PracticeSelenium.AbstractComponents.AbstractComponent;

public class menProductPage extends AbstractComponent {
	
	
	WebDriver driver;
	
	
	public menProductPage(WebDriver driver) 
	{
		//Initialisation
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}


	
	@FindBy(xpath="//li[@class='product-item']")
	List<WebElement> products;
	
	@FindBy(xpath="//a[@class='action showcart']")
	WebElement cart;
	
	@FindBy(className="checkout")
	WebElement checkOut;
	
	@FindBy(linkText="shopping cart")
	WebElement altcart;
	
	
	@FindBy(xpath="//button[@data-role='proceed-to-checkout']")
	WebElement altcheckOut;
	
	
	By productsBy = By.xpath("//li[@class='product-item']");
	By chooseSize = By.id("option-label-size-143-item-169");
	By chooseColour = By.id("option-label-color-93-item-52");
	By addToCart = By.className("tocart");

	public List<WebElement> getProductList() 
	{
		
		return products;
		
	}
	
	public WebElement getProductByName(String productName) 
	{
		WebElement prod = getProductList().stream().filter(product -> product.findElement(By.cssSelector("strong")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addToCart1(String productName) 
	{
		
		WebElement prod = getProductByName(productName);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scroll(0,1200)");
		
		Actions a = new Actions(driver);
		a.scrollToElement(prod).build().perform();
		a.moveToElement(prod).build().perform();
		
		prod.findElement(chooseSize).click();
		prod.findElement(chooseColour).click();
		prod.findElement(addToCart).click();
		
	}
	
	public checkoutPage addToCart(String productName) 
	{
		
		WebElement prod = getProductByName(productName);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scroll(0,1200)");
		
		Actions a = new Actions(driver);
		a.scrollToElement(prod).build().perform();
		a.moveToElement(prod).build().perform();
		
		prod.findElement(chooseSize).click();
		prod.findElement(chooseColour).click();
		prod.findElement(addToCart).click();
		cart.click();
		cart.click();
		checkOut.click();
		checkoutPage cp = new checkoutPage(driver);
		return cp;
	}
	
	public checkoutPage addToCartAlt(String productName) 
	{
		
		WebElement prod = getProductByName(productName);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scroll(0,1200)");
		
		Actions a = new Actions(driver);
		a.moveToElement(prod).build().perform();
		prod.findElement(chooseSize).click();
		prod.findElement(chooseColour).click();
		prod.findElement(addToCart).click();
		altcart.click();
		altcheckOut.click();
		checkoutPage cp = new checkoutPage(driver);
		return cp;
	}
	
	public checkoutShipping addToCartNC(String productName) 
	{
		
		WebElement prod = getProductByName(productName);
		
		Actions a = new Actions(driver);
		a.moveToElement(prod).build().perform();
		prod.findElement(chooseSize).click();
		prod.findElement(chooseColour).click();
		prod.findElement(addToCart).click();
		cart.click();
		cart.click();
		checkOut.click();
		checkoutShipping cs = new checkoutShipping(driver);
		return cs;
		
	}
}
