package com.tutorial.seleniumbatch2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class seleniumTestng {

@Test	
public void testFb() throws InterruptedException {
		
 		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver_win32\\chromedriver.exe");
 		WebDriver driver= new ChromeDriver();
 		driver.get("https:www.facebook.com");
 		driver.manage().window().maximize();
 		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
 		driver.findElement(By.id("email")).sendKeys("test");
 		driver.findElement(By.id("pass")).sendKeys("test");
 		driver.findElement(By.xpath("//input[@value='Log In']")).click();
 		Thread.sleep(3000);
 		WebElement alert=driver.findElement(By.cssSelector("div[class='pam _3-95 uiBoxRed']"));
 		if(alert.isDisplayed()) {
 			System.out.println("Alert window encountered");
 		}
 		else {
 			System.out.println("Test Case failed");
 		}
 		 //identify recover your account and click on it
 		WebElement accountLink=driver.findElement(By.linkText("Recover Your Account"));
 		
 		if (accountLink.isDisplayed()) {
 			
 			accountLink.click();
 			Thread.sleep(3000);
 			WebElement recover= driver.findElement(By.xpath(" div[contains(text(),'Please enter your email or phone number to search for your account.')]"));
 			if (recover.isDisplayed()) {
 				driver.findElement(By.xpath("//span[contains(text(),'Cancel')]")).click();
 				if(driver.findElement(By.xpath("//span[contains(text(),'Log Into Facebook')]")).isDisplayed()) {
 				System.out.println("Test case passed");
 				}
 				else {
 					System.out.println("Test case failed");
 				}
 			}
 			else {
 				System.out.println("Recovery text is not found--Failed");
 			}
 		
 		}
 		else {
 			System.out.println("Link not found--Failed");
 		}
 		
 		 //identify this element"Please enter your email or phone number to search for your account. "
 		  //click on cancel button
 		driver.close();
	

	
	
	
	
	
	}

@Test
public void printSomething() {
	System.out.println("Hello");
}

@Test
public void printSomethingExtra() {
	int div= 1/0;
	System.out.println(div);
}

}
