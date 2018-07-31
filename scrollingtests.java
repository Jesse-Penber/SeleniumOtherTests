package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Scrolling within a browser, within a listbox element, and to a specific list item
//created by Jesse Penber, 7/31/2018 //

public class ScrollTest {
	
	public static void main(String[] args) {
		//set driver browser and open page in Chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jpenber\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3.org/TR/wai-aria-practices/examples/listbox/listbox-scrollable.html");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		
		//scroll down 2000px in browser
		((JavascriptExecutor)driver).executeScript("scroll(0,2000)");
		System.out.println("Browser scroll complete");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
		
		//scroll inside listbox panel
		WebElement listbox = driver.findElement(By.id("ss_elem_list"));
		listbox.sendKeys(Keys.PAGE_DOWN);
		System.out.println("Listbox scroll complete");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
		//scroll until list element Tennessine comes into view 
		WebElement tenessineItem = driver.findElement(By.id("ss_elem_Ts"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tenessineItem);
		System.out.println("Specific list element scroll complete");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}

}
