package com.peterjenkins.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Basepage;

public class AddToCartConfirmationPopup extends Basepage {
	
	WebDriver driver;     //   This driver is the driver which communicates with the browserdriver (e.g chrome) by sending rquest and receiving  response back
    WebDriverWait wait;
	
	public AddToCartConfirmationPopup(WebDriver driver) {    //This driver is the browserdriver (e.g chrome)
		super(driver);
		
		   // wait for page to load
	wait= new WebDriverWait(driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckoutButton));     // As soon as the The wait  see this element, it will know it is on the right page. You can use any element on the home page
		
		
	}	
	
	private By proceedToCheckoutButton=By.xpath("//span[contains(text(),'Proceed to checkout')]");  
	
	
	 public void clickProceedToCheckoutButton() {
	wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
	        driver.findElement(proceedToCheckoutButton).click();
	
	
	

}
}