package PracticeSelenium.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.model.Report;

import PracticeSelenium.TestComponents.baseTest;
import PracticeSelenium.pageobjects.landingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class cosmeticTest extends baseTest {
	
	

	@Test
	public void Pagetitle() {
		
		landingPage lp = new landingPage(driver);
		Object MMSize =	lp.sizeCheck();
		String BGcolour =	lp.backgroundColor();
		int ProductsPresent = lp.NumProducts();
		String title =	driver.getTitle();
		
		
		String message = ("The page title is " + title);
		
//		test.info("where the string should be");
		
		
//		String answer2 = ("The mix and match element has a size of "+ MMSize);
//		String answer3 = ("There are " +ProductsPresent+" products present on the landing page. ");
//		String answer4 = ("The landing page background color is "+ BGcolour);
		
		
		
		
//		System.out.println("The mix and match element has a size of "+ MMSize);
//		System.out.println("There are " +ProductsPresent+" products present on the landing page. ");
//		System.out.println("The landing page background color is "+ BGcolour);
		
		
	}
}
	