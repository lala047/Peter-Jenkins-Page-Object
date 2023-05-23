package com.peterjenkins.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.XLUtils;
import com.peterjenkins.utilities.ReadConfig;

public class BaseClass {      //if there is an error, check the imports
	ReadConfig readconfig= new ReadConfig();  // create and object of ReadConfig Class so as to access the methods needed in the ReadConfig
	String baseURL=readconfig.getApplicationURL();
	String username= readconfig.getUsername();
	String password= readconfig.getPassword();
	public static WebDriver driver;
	public WebDriverWait wait;
	//public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
	
		
		
		/*
		 * Logger logger=Logger.getLogger("inetBankinvV1");
		 * PropertyConfigurator.configure("log4j.properties.txt");
		 */
		 
		
		
		  if(br.equals("chrome")) {
		  System.setProperty("webdriver.chrome.driver",readconfig.getChromePath()); //This is to access the chrome in Config. Properties 
	// or System.setProperty("webdriver.chrome.driver",./)+"//Drivers//chromedriver.exe"); // used in both java classes and properties file 
		  driver= new ChromeDriver();
		  
		  }else if (br.equals("firefox")){
		  System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
		  driver= new FirefoxDriver();
		  
		  }else if(br.equals("ie")){
		  System.setProperty("webdriver.ie.driver",readconfig.getIEPath()); 
		  driver= new InternetExplorerDriver(); 
		 
		 // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		  wait= new WebDriverWait(driver, 10);
		  }
		 

	
	
	driver.get(baseURL);
	 driver.manage().window().maximize();
	
	
	
		}
		
		  @AfterClass 
		  public void tearDown() { 
		  driver.quit(); }
		 
		
		  public void captureScreen(WebDriver driver, String tname) throws IOException { //tname=test case name
		  TakesScreenshot ts = (TakesScreenshot) driver; 
		  File source = ts.getScreenshotAs(OutputType.FILE); 
		  File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		  FileUtils.copyFile(source, target); System.out.println("Screenshot taken"); 
		  }
		 
		
		public String randomestring()
		{
			String generatedstring=RandomStringUtils.randomAlphabetic(8);
			return(generatedstring);
		}
		
		public static String randomeNum() {
			String generatedString2 = RandomStringUtils.randomNumeric(4);
			return (generatedString2);
		}
		
		
	}