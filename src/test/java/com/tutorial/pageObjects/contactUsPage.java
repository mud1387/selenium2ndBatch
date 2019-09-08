package com.tutorial.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class contactUsPage {

	private  WebDriver driver;
	@FindBy(how=How.LINK_TEXT, using="Contact us")
	@CacheLookup
	WebElement contactUsLink;
	
	@FindBy(how=How.ID, using="id_contact")
	@CacheLookup
	WebElement subjectDropdown;
	
	@FindBy(how=How.ID, using="email")
	@CacheLookup
	WebElement email;
	
	@FindBy(how=How.ID, using="id_order")
	@CacheLookup
	WebElement order;
	
	@FindBy(how=How.ID, using="message")
	@CacheLookup
	WebElement message;
	
	@FindBy(how=How.NAME, using="submitMessage")
	@CacheLookup
	WebElement send;
	
	public contactUsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickContactUsLink() {
		contactUsLink.click();
	}
	
	
	public void selectSubjectheading(String text) {
		
		Select sel= new Select(subjectDropdown);
		sel.selectByVisibleText(text);
		System.out.println("Selected heading from dropdown= "+text);
	}
	
	public void enterEmailAddress(String emailValue) {
		
		email.clear();
		email.sendKeys(emailValue);
	}
	
	
	public void enterOrderReference(String orderValue) {
		
		order.clear();
		order.sendKeys(orderValue);
	}
	
	public void enterMessage(String text) {
		
		message.clear();
		message.sendKeys(text);
	}
	
	public void clickSendButton() {
		send.click();
	}
	
	public void creatingCustomerMessage(String subject,String email, String order,String message) throws InterruptedException {
		clickContactUsLink();
		Thread.sleep(2000);
		System.out.println("Clicked on Contactus link");
		selectSubjectheading(subject);
		enterEmailAddress(email);
		enterOrderReference(order);
		enterMessage(message);
		clickSendButton();	
		System.out.println("Clicked on Send button");
	}
}
