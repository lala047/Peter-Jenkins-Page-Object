package com.peterjenkins.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Basepage;

public class ProductDetailsPage extends Basepage{
	
	
	public ProductDetailsPage(WebDriver driver) {    //This driver is the browserdriver (e.g chrome)
		super(driver);
		
		   // wait for page to load
	wait= new WebDriverWait(driver, 5);
	wait.until(ExpectedConditions.visibilityOfElementLocated(Addtocartbtn));     // As soon as the The wait  see this element, it will know it is on the right page. You can use any element on the home page
		
		
	}	
	
	private By Addtocartbtn=By.xpath("//span[text()='Add to cart']");  
	
	
	
	public AddToCartConfirmationPopup clickAddToCartButton() {
 wait.until(ExpectedConditions.elementToBeClickable(Addtocartbtn)); 
driver.findElement(Addtocartbtn).click();
return new AddToCartConfirmationPopup(driver);


}
}
