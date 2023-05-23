package linear;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdvancedDropdownAssignment {

	public static void main(String[] args) throws InterruptedException {
	
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\emmai\\OneDrive\\Desktop\\SeleniumJars\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.guru99.com/test/newtours/register.php");

		driver.manage().window().maximize(); // maximize the window

		driver.switchTo().frame("gdpr-consent-notice");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Accept All']")).click();
		driver.switchTo().defaultContent();
		
		
		
		// print & Count how many countries are available in the dropdown in the 'Register' functionality
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='country']"));  
		Select sel = new Select(dropdown);
		List<WebElement> li = sel.getOptions();
		//System.out.println(li.size());
		 for(int i=0; i<li.size(); i++){ 
		System.out.println(li.get(i).getText());
		// System.out.println(s);
		
	   // print all the countries in the dropdown to the point where you have Nigeria
		if(li.get(i).getText().equals("NIGERIA")){
			//System.out.println(li.get(i).getText());
			 li.get(i).click();
		break; 
		
		}
			 //SELECT AND PRINT 'NIGERIA' FROM THE LIST OF COUNTRIES
			 if(li.get(i).getText().equals("NIGERIA")){
				 WebElement Nigeria=li.get(i);
				 Nigeria.click();
				 System.out.println(li.get(i).getText());
				 break;
				
			 
					}
	 

			
	
		}
		
		 driver.close();
		  

	}

}
