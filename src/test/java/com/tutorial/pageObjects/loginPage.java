package com.tutorial.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class loginPage {

	private  WebDriver driver;
	@FindBy(how=How.XPATH, using="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	@CacheLookup
	WebElement signIn;
	
	@FindBy(how=How.XPATH, using="//*[@id='email']")
	@CacheLookup
	WebElement loginEmailAddress;
	
	@FindBy(how=How.XPATH, using="//*[@id='passwd']")
	@CacheLookup
	WebElement loginPassword;
	
	@FindBy(how=How.ID, using="SubmitLogin")
	@CacheLookup
	WebElement submitButton;
	
	
	public loginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickSignIn() {
		signIn.click();
	}
	
	public void clickOnSubmitBtn() {
		
		submitButton.click();
		
	}
	
	public void enterEmailAddress(String email) {
		
		loginEmailAddress.clear();
		loginEmailAddress.sendKeys(email);
	}
	
	public void enterPassword(String pwd) {
		
		loginPassword.clear();
		loginPassword.sendKeys(pwd);
	}
	
	public void loginToApplication(String email, String pwd) throws InterruptedException {
		clickSignIn();
		Thread.sleep(5000);
		System.out.println("Clicked on Signin link");
		enterEmailAddress(email);
		System.out.println("Entered emailId");
		enterPassword(pwd);
		System.out.println("Entered Password");
		clickOnSubmitBtn();
		System.out.println("Clicked on Submit button");
	}
}
