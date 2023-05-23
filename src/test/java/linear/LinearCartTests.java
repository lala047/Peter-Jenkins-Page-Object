package linear;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinearCartTests {
	//public static void main(String[] args) throws InterruptedException {
	
		
	    @Test
	    public void LinearAddToCartTest() {

		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	    	WebDriverManager.chromedriver().setup();        // You can use WebDriverManager instead of specifying the path
	    	//WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new ChromeDriver();      // Polymorphism
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("http://automationpractice.com/");
		driver.manage().window().maximize();
		
		// navigate to login page
		driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();
		
		// log in
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("petejenkins@test.com");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Password1234");
		driver.findElement(By.xpath("//span[normalize-space()='Sign in']")).click();
		
		// navigate back to home page  
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Order history and details']"))); //the presence of order history shows that we are in the same page as the house icon
		driver.findElement(By.xpath("//i[@class='icon-home']")).click();         // clicking on the House icon    
		
		// select the first product
		List<WebElement> allproducts = driver.findElements((By.xpath("//a[@class='product-name']")));    // To identify the element of multiple elements, identify one of the elements and Store in a list
		wait.until(ExpectedConditions.elementToBeClickable((allproducts.get(0))));
		allproducts.get(0).click();
	
		// add 1 item to the shopping cart
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='add_to_cart']/button")));
		driver.findElement(By.xpath("//span[normalize-space()='Add to cart']")).click(); 
		
		// proceed to checkout
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Proceed to checkout']")));
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click(); 
		
		// verify we have 1 item in the shopping cart
		String numProductsLabelText = driver.findElement(By.id("//span[contains(text(),'01')]")).getText();   //This is to read this on the page: 'Your shopping cart contains: 1 Products'
      	int spaceLocation = numProductsLabelText.indexOf(" ");      									//  it returns 1 space in btw 1 and Products    'Your shopping cart contains: 1 Products'
		int numProducts = Integer.parseInt(numProductsLabelText.substring(0, spaceLocation));    //   This converts the string into an integer
		//Assert.assertEquals(numProducts, 1, "Expected number of products in shopping cart was 1 but actual value was: " + Integer.toString(numProducts));
		 Assert.assertEquals(numProducts, 1);       // This is to verify that we have 1 item in the basket
	
		driver.quit();
		}
}



