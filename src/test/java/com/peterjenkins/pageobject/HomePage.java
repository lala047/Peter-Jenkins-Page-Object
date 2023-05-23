package com.peterjenkins.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.Basepage;

public class HomePage extends Basepage {  //Homepage is different from the landing page. it is the first page upon navigating to the webpage



	
	public HomePage(WebDriver driver) {
		super(driver);   // This is used to access the driver in the base page
		
		
		   // wait for page to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(signInLink));   // As soon as the The wait  see this element, it will know it is on the right page. You can use any element on the home page
		
	
	}	
	
	private By signInLink= By.xpath("//a[normalize-space()='Sign in']");  
	private By productLinkslocator= By.xpath(" //a[@class='product-name']");  // To identify the element of multiple elements, identify one of the elements and check the parent(which is common among all the elements in the list and take that of the parent


//ACTION METHODS

public void ClickSigninBtn() {
wait.until(ExpectedConditions.visibilityOfElementLocated(signInLink));  
driver.findElement(signInLink).click();
}

// select the first product
public List<WebElement> selectfirstproduct(){       //List<WebElement> is used (not void) because we are dealing with a list of items
wait.until(ExpectedConditions.elementToBeClickable(productLinkslocator));
List<WebElement> allproducts = driver.findElements(productLinkslocator);    // To identify the element of multiple elements, identify one of the elements and Store in a list
 return allproducts;       //List will return what you stored in it
	
}

}
