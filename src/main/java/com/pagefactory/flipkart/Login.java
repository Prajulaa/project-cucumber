package com.pagefactory.flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	WebDriver driver;
	
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='IiD88i _351hSN']/input[@type='text']") private WebElement emailId;
	@FindBy(xpath="//div[@class='IiD88i _351hSN']/input[@type='password']") private WebElement password;
	@FindBy(xpath="//div[@class='_1D1L_j']/button[@type='submit']") private WebElement submit;
	
	public WebElement getEmailId() {
		return emailId;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getSubmit() {
		return submit;
		
	}

}
