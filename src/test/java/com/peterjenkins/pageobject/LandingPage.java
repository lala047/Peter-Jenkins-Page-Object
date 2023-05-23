package com.peterjenkins.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.Basepage;

public class LandingPage  extends Basepage{   // UserAccountPage
	
	
	public LandingPage(WebDriver driver) {
		super(driver);
		
		
		 // wait for page to load
 wait.until(ExpectedConditions.visibilityOfElementLocated(RtnHomePagebtn));   // As soon as the The wait  see this element, it will know it is on the right page. You can use any element on the home page
		
	}	
	
private By RtnHomePagebtn= By.xpath("//a[@title='Return to Home']");    //performing a return to Home Page by clicking on the House icon
private By Signoutlink=  By.xpath("//a[@title='Log me out']");

public void navigateToHomePage() {
wait.until(ExpectedConditions.visibilityOfElementLocated(RtnHomePagebtn));   //As soon as the The wait  see this element, it will know it is on the homepage. You can use any element on the home page
driver.findElement(RtnHomePagebtn).click();

}
public void ClickSignOut() throws InterruptedException {
driver.findElement(Signoutlink).click();
	
}
}