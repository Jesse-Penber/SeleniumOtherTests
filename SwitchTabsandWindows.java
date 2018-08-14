package test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//Demonstration of switching tabs and windows on Ask.com
//Created by Jesse Penber, 8-14-2018

public class SwitchTabsandWindows {
	public static void main(String[] args) {
		// set driver properties to Chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jpenber\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//navigate to Ask.com and open Help in new tab
		driver.navigate().to("https://ask.com");
		driver.findElement(By.linkText("Help")).click();	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//create dynamic array for windows handles and switch to new tab
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		//click Submit A Request
		driver.findElement(By.linkText("Submit a request")).click();	
		
		//open Ask in new window
		Actions clickLink = new Actions(driver);
		WebElement privacyLink = driver.findElement(By.linkText("Ask"));
		clickLink.keyDown(Keys.SHIFT).click(privacyLink).keyUp(Keys.SHIFT).build().perform();
		
		//switch to Ask window and enter text in Search bar to verify switch successful
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(2));
		driver.findElement(By.cssSelector("#query")).sendKeys("Success");
	}
}