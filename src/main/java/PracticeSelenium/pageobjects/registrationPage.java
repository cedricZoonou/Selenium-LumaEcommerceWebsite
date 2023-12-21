package PracticeSelenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PracticeSelenium.AbstractComponents.AbstractComponent;

public class registrationPage extends AbstractComponent{
	
	WebDriver driver;
	
	public registrationPage(WebDriver driver) 
	{
		//Initialisation
				super(driver);
				this.driver = driver;
				PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="firstname")
	WebElement FirstName;
	
	@FindBy(id="lastname")
	WebElement LastName;
	
	@FindBy(id="email_address")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="password-confirmation")
	WebElement passwordConfirmation;
	
	@FindBy (css="button[title='Create an Account'] span")
	WebElement CreateAccountCTA;
	


	
	public myAccountPage createNewCustomerAccount(String fN, String lN, String mail, String pass) 
	{
		FirstName.sendKeys(fN);
		LastName.sendKeys(lN);
		email.sendKeys(mail);
		password.sendKeys(pass);
		passwordConfirmation.sendKeys(pass);
		CreateAccountCTA.click();
		myAccountPage map = new myAccountPage(driver);
		return map;
	}
	

}
