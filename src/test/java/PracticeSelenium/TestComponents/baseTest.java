package PracticeSelenium.TestComponents;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import PracticeSelenium.pageobjects.landingPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class baseTest {
//	public static ExtentTest test;
//	public static ExtentReports extent;
	public WebDriver driver;
	public landingPage lp;
	
	public WebDriver initializeDriver() throws IOException
	{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\PracticeSelenium\\resources\\GlobalData.properties");
		prop.load(fis);
		// prop load will take only input stream -> convert file path to input stream with FileInputStream
		
		
		String browserName =	System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
//		String browserName =	prop.getProperty("browser");
		
		
		
		if(browserName.contains("chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900)); //help to run in full screen
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions a = new Actions(driver);
		
		return driver;
	}
	
	
	
public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	
	{
		
		//read json to string
	
	String jsonContent =	FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
	
	//String to HasMap Jackson Databind
	
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
	});
	return data;
	//
	
	}

public String getScreenshot(String testCaseName, WebDriver driver) throws IOException 
	{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
	FileUtils.copyFile(source, file);
	return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}

	

	@BeforeMethod(alwaysRun=true)
	public landingPage launchApplication() throws IOException 
	{
		driver = initializeDriver();
		lp = new landingPage(driver);
		lp.goTo();
		return lp;
		
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() 
	{
	driver.quit();
	}


	
	


	
}
