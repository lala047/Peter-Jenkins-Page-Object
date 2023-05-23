package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basepage {
	public WebDriver driver;     //   This driver is the driver which communicates with the browserdriver (e.g chrome) by sending request and receiving response back
	public WebDriverWait wait;
	
	public Basepage(WebDriver driver) {    //This driver is the browserdriver (e.g chrome)
	this.driver=driver;
	
		
		   // wait for page to load
	 wait= new WebDriverWait(driver, 5);

}
}