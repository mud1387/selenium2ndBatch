package com.tutorial.seleniumbatch2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tutorial.pageObjects.loginPage;

public class pomClass2 {

	public WebDriver driver;
	public loginPage lp;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
	}
	
	@Test
	public void testCaseExecution() throws InterruptedException {
		
		// launch the chrome browser and open the application url

		driver.get("http://automationpractice.com/index.php");
		// maximize the browser window

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		// declare and initialize the variable to store the expected title of the webpage.

		String expectedTitle = "My Store";
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
		lp.loginToApplication("abcd@gmail.com", "1234");
		
		WebElement errorAlert= driver.findElement(By.xpath("//li[contains(text(),'Invalid password.')]"));
		
		if (errorAlert.isDisplayed()) {
			
			System.out.println("Alert error found");
		}
		// close the web browser
		
		
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
