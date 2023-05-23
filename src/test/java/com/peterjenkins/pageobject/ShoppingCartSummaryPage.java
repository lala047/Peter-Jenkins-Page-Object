package com.peterjenkins.pageobject;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.Basepage;
import components.ShoppingCartItem;


//verify we have 1 item in the shopping cart

public class ShoppingCartSummaryPage extends Basepage {

	
	public ShoppingCartSummaryPage(WebDriver driver) {    //This driver is the browserdriver (e.g chrome)
		super(driver);
		
		   // wait for page to load
	wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantity));     // As soon as the The wait  see this element, it will know it is on the right page. You can use any element on the home page
		
		
	}	
	
private By productQuantity=By.id("summary_products_quantity");     ///We are to identify the element of this in the page 'Your shopping cart contains 1 product'
private By shoppingCartTableLocator = By.id("cart_summary");
private By totalPriceLocator = By.id("total_product");         //The total price of the  products  (Total products	= $79.00 <-- this is element to be located)

private By cartTableLocator = By.xpath("//table[@id='cart_summary']/thead/tr[1]/th");

private By rowProductNameLocator = By.cssSelector("td.cart_description > p.product-name > a");
private By rowSKULocator = By.cssSelector("td.cart_description > small.cart_ref");
private By rowColorLocator = By.cssSelector("td.cart_description > small:nth-child(3) > a");
private By rowInStockLocator = By.cssSelector("td.cart_avail > span");
private By rowUnitPriceLocator = By.cssSelector("td.cart_unit > span.price > span.price");
private By rowQuantityLocator = By.cssSelector("td.cart_quantity > input.cart_quantity_input");
private By rowTotalPriceLocator = By.cssSelector("td.cart_total > span.price");

private By rowProductImageLinkLocator = By.cssSelector("td.cart_product > a");
private By rowProductNameLinkLocator = By.cssSelector("td.cart_product > a");
private By rowIncreaseQuantityButtonLocator = By.cssSelector("td.cart_product > a");
private By rowDecreaseQuantityButtonLocator = By.cssSelector("td.cart_product > a");
private By rowRemoveProductButtonLocator = By.cssSelector("td.cart_product > a");


	//verify we have 1 item in the shopping cart
	// This can be used for both 1 or multiple purchases
	public int getQuantity() {      //int is used (not void) because we are dealing with quantity
	wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantity));
	String numProductsText = driver.findElement(productQuantity).getText();
	//convert the string to integer
    int spaceLocation = numProductsText.indexOf(" ");  //" " space in btw to accommodate '1 product' as there is a space btw them.
    int numProducts = Integer.parseInt(numProductsText.substring(0, spaceLocation));
    return numProducts;
}

public double getTotalPrice () {
    wait.until(ExpectedConditions.visibilityOfElementLocated(totalPriceLocator));
    String totalPriceString = driver.findElement(totalPriceLocator).getText();
    double totalPrice = Double.parseDouble(totalPriceString.substring(1));
    return totalPrice;
}

public List<ShoppingCartItem> getShoppingCart() throws Exception {
    wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartTableLocator));
    validateShoppingCart();
    WebElement shoppingCartTable = driver.findElement(shoppingCartTableLocator);
    List<WebElement> tableRows = shoppingCartTable.findElements(By.cssSelector("tbody > tr"));
    List<ShoppingCartItem> cartItems = new ArrayList<ShoppingCartItem>();

    for (WebElement row : tableRows) {
        ShoppingCartItem cartItem = new ShoppingCartItem();

        cartItem.setProductName(row.findElement(rowProductNameLocator).getText().trim());
        cartItem.setSKU(row.findElement(rowSKULocator).getText().trim());
        cartItem.setColor(row.findElement(rowColorLocator).getText().trim());
        cartItem.setInStock(row.findElement(rowInStockLocator).getText().trim().toLowerCase().equals("in stock"));
        cartItem.setUnitPrice(Double.parseDouble(row.findElement(rowUnitPriceLocator).getText().trim().substring(1)));
        cartItem.setQuantity(Integer.parseInt(row.findElement(rowQuantityLocator).getAttribute("value")));
        cartItem.setTotalPrice(Double.parseDouble(row.findElement(rowTotalPriceLocator).getText().trim().substring(1)));

        cartItem.setProductImageLink(row.findElement(rowProductImageLinkLocator));
        cartItem.setProductNameLink(row.findElement(rowProductNameLinkLocator));
        cartItem.setIncreaseQuantityButton(row.findElement(rowIncreaseQuantityButtonLocator));
        cartItem.setDecreaseQuantityButton(row.findElement(rowDecreaseQuantityButtonLocator));
        cartItem.setRemoveProductButton(row.findElement(rowRemoveProductButtonLocator));

        cartItems.add(cartItem);
    }

    return cartItems;
}

private void validateShoppingCart() throws Exception {

    wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartTableLocator));
    List<WebElement> cartHeaderRows = driver.findElements(cartTableLocator);
    int numberOfTableColumns = cartHeaderRows.size();
    if (numberOfTableColumns != 7) {
        throw new Exception("Number of shopping cart table columns was expected to be 7 but was " + Integer.toString(numberOfTableColumns));
    }

    String columnTitle = cartHeaderRows.get(0).getText();
    if (!columnTitle.equals("Product")) {
        throw new Exception("Column 1 of shopping cart table was expected to be 'Product' but was " + columnTitle);
    }

    columnTitle = cartHeaderRows.get(1).getText();
    if (!columnTitle.equals("Description")) {
        throw new Exception("Column 2 of shopping cart table was expected to be 'Description' but was " + columnTitle);
    }

    columnTitle = cartHeaderRows.get(2).getText();
    if (!columnTitle.equals("Avail.")) {
        throw new Exception("Column 3 of shopping cart table was expected to be 'Avail.' but was " + columnTitle);
    }

    columnTitle = cartHeaderRows.get(3).getText();
    if (!columnTitle.equals("Unit price")) {
        throw new Exception("Column 4 of shopping cart table was expected to be 'Unit price' but was " + columnTitle);
    }

    columnTitle = cartHeaderRows.get(4).getText();
    if (!columnTitle.equals("Qty")) {
        throw new Exception("Column 5 of shopping cart table was expected to be 'Qty' but was " + columnTitle);
    }

    columnTitle = cartHeaderRows.get(5).getText();
    if (!columnTitle.equals("Total")) {
        throw new Exception("Column 6 of shopping cart table was expected to be 'Total' but was " + columnTitle);
    }
}

}
