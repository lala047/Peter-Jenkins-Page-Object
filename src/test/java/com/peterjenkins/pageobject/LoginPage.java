 package com.peterjenkins.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.Basepage;


public class LoginPage extends Basepage{

	
	public LoginPage(WebDriver driver) {    //This driver is the browserdriver (e.g chrome)
		super(driver);
		   // wait for page to load
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));     // As soon as the The wait  see this element, it will know it is on the right page. You can use any element on the home page
		
	}	
	
	private By txtemail=By.id("email");  
	private By txtpassword = By.id("passwd");   
	private By signInbtn= By.id("SubmitLogin");
	
	
	
	  public LandingPage login(String uname, String pwd) {   //This method is called BUSINESS METHODS(i.e it returns the page it is navigating to
		  driver.findElement(txtemail).sendKeys(uname); 
		  driver.findElement(txtpassword).sendKeys(pwd); 
			driver.findElement(signInbtn).click();
	   return new LandingPage(driver);


    
        


//    	//setting the username and pw individualy just incase you need them
//private LoginPage setusername(String uname) {        // it is in private
//wait.until(ExpectedConditions.visibilityOfElementLocated(txtemail));
//driver.findElement(txtemail).sendKeys(uname);     //This driver is the driver which communicates with the browserdriver (e.g chrome)
//return this;           // This means it is still in the same page and has not navigated yet to the next page
//	
//	// or  if you want to clear the textbox. store in a Webelement before doing so
////WebElement emailTextbox = driver.findElement(txtemail);   // store in a webelement before you can clear the textbox
////emailTextbox.clear();
////emailTextbox.sendKeys(uname);
//
//}
//private LoginPage setpassword(String pwd) {
//	wait.until(ExpectedConditions.visibilityOfElementLocated(txtpassword)); //txtpassword
//	driver.findElement(txtpassword).sendKeys(pwd);
//	return this; 
//	
//	// or  if you want to clear the textbox. store in a Webelement beore doing so
//	//WebElement pwdTextbox = driver.findElement(password);   // store in a webelement before you can clear the textbox
//	//pwdTextbox.clear();
//	//pwdTextbox.sendKeys(pwd);
//
//}
//private LandingPage Clickbtn() {
//	wait.until(ExpectedConditions.elementToBeClickable(signInbtn));
//	driver.findElement(signInbtn).click();
//	 return new LandingPage(driver);
//

}

}