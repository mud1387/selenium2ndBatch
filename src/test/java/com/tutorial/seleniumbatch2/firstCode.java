package com.tutorial.seleniumbatch2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class firstCode {

public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.facebook.com");
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
		driver.close();
		
	}
}
