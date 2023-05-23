package com.peterjenkins.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
	WebDriver driver;
	
	public CreateAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
@FindBy (id="email_create") public WebElement txtemailadd;
@FindBy (xpath="//span[normalize-space()='Create an account']")public WebElement btncreateacct;
	
	public void custemailadd(String cemailadd) {
		txtemailadd.sendKeys(cemailadd);
}
	public void ClickCreateAcct( ) {
		btncreateacct.click();
}
}