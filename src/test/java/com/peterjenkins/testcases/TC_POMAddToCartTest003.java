package com.peterjenkins.testcases;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.peterjenkins.pageobject.AddToCartConfirmationPopup;
import com.peterjenkins.pageobject.HomePage;
import com.peterjenkins.pageobject.LandingPage;
import com.peterjenkins.pageobject.LoginPage;
import com.peterjenkins.pageobject.ProductDetailsPage;
import com.peterjenkins.pageobject.ShoppingCartSummaryPage;

import components.ShoppingCartItem;

public class TC_POMAddToCartTest003 extends BaseClass{
	
	@Test  
	public void POMAddToCartTest() throws Exception {
		
		// navigate to login page
		HomePage homepage= new HomePage(driver);
		homepage.ClickSigninBtn();
		
		//log in
		
		  LoginPage loginpage= new LoginPage(driver); 
		  loginpage.login(username,password);
		
		//OR
		// log in
		
//		  LoginPage loginpage= new LoginPage(driver); 
//		  loginpage.setusername(username); //The username and password is in the config.properties file
//		  loginpage.setpassword(password); 
//		  loginpage.Clickbtn();
//		 

	// navigate back to home page
	LandingPage landingpage= new LandingPage(driver);
	landingpage.navigateToHomePage();
	
	
	 // select the first product
	  List<WebElement> allproducts = homepage.selectfirstproduct(); //(no need to create an object as the object of the home page was previously created (store the obj.method in the variable
      allproducts.get(0).click();
      
      // add 1 item to the shopping cart
      ProductDetailsPage  productdetailspage= new ProductDetailsPage(driver);
      productdetailspage.clickAddToCartButton();
     
      
      
   // proceed to checkout
      AddToCartConfirmationPopup addTocartconfirmationpopup = new AddToCartConfirmationPopup(driver);
      addTocartconfirmationpopup .clickProceedToCheckoutButton();
      landingpage.navigateToHomePage();
      allproducts.get(1).click();
      addTocartconfirmationpopup .clickProceedToCheckoutButton();
      
      
      
   // verify we have 1 item in the shopping cart
      //ShoppingCartSummaryPage shoppingcartsummarypage = new ShoppingCartSummaryPage(driver);
     // int numProducts = shoppingcartsummarypage.getQuantity();  // use int x=obj.method to call the method because we are dealing with integer(quantity)
      //assertEquals(numProducts, 1, "Expected number of products in shopping cart was 1 but actual value was: " + Integer.toString(numProducts));
     // Assert.assertEquals(numProducts, 1);       // This is to verify that we have 1 item in the basket
	   
      
      
	// verify the total cost for each item in the basket adds up to the total cost in the shopping cart  (This is for multiple items in the shopping cart)
	//This is the reason we needed to create the shopping cart item class containing data values(variables) and Actions so we can use it to solve issue of multiple items in the cart
    ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
    List<ShoppingCartItem> cartItems = shoppingCartSummaryPage.getShoppingCart();            //USE OF JAVA STREAM TO SUM UP THE VALUE OF THE TOTAL ITEMS IN THE CART
    double totalItemAmounts = cartItems.stream().mapToDouble(ShoppingCartItem::getTotalPrice).sum();   // This will do the sum
    
    
    totalItemAmounts = Math.round(totalItemAmounts*100)/100.0d;     // This rounds  the amount to decimal places
    double totalAmount = shoppingCartSummaryPage.getTotalPrice();
   // Assert.assertEquals(totalItemAmounts, totalAmount, "Total value of items does not equal total quoted");
   Assert.assertEquals( totalItemAmounts, totalAmount); 
    
   		//To Remove 2nd item from the Basket
//    cartItems.get(1).removeProductFromBasket();         // This will remove the item in the 2nd row from the cart
   
   		//To get the quantity of the first row
//    int quantity = cartItems.get(0).getQuantity();

 
}


	}
