package com.tutorial.seleniumbatch2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tutorial.pageObjects.loginPage;

import browserType.chromeBrowser;
import config.config;

public class pomClass3 {
	
	public WebDriver driver;
	public loginPage lp;
	public chromeBrowser ch= new chromeBrowser();
	public config cf=new config();
	
	@BeforeTest
	public void setup() {
		
		
		driver= ch.getChromeDriver();
	}
	
	@Test
	public void testCaseExecution() throws InterruptedException {
		
		// launch the chrome browser and open the application url

		driver.get(cf.getUrl());
		// maximize the browser window

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(cf.getImplicitWait(), TimeUnit.SECONDS);
		// declare and initialize the variable to store the expected title of the webpage.

		String expectedTitle = cf.getHomePageTitle();
		// fetch the title of the web page and save it into a string variable

		String actualTitle = driver.getTitle();
		// compare the expected title of the page with the actual title of the page and
		// print the result

		if (expectedTitle.equals(actualTitle))
		{
			System.out.println("Verification Successful - The correct title is displayed on the web page.");
		}
		else{
			System.out.println("Verification Failed - An incorrect title is displayed on the web page.");
		}
		
		lp=new loginPage(driver);
		lp.loginToApplication(cf.getUsername(), cf.getPassword());
		
		WebElement errorAlert= driver.findElement(By.xpath("//li[contains(text(),'Invalid password.')]"));
		
		if (errorAlert.isDisplayed()) {
			
			System.out.println("Alert error found");
		}
		
		Thread.sleep(500);

		System.out.println("Test script executed successfully.");
		
	}
	
	@AfterTest
	public void close() {

		driver.close();
		// terminate the program

		System.exit(0);
	}
	

}
