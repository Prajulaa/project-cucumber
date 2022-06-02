package com.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseClass;

public class MMLoginPOM {
	WebDriver driver;
	public MMLoginPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@id='loginemail']") private WebElement enterEmail;
	@FindBy(id="loginpassword") private WebElement enterPassword;
	@FindBy(xpath = "//button[text()='Login']") private WebElement loginButton;
	@FindBy(xpath="//img[@class='tripledotbtn']") private WebElement threeDotButton;
	@FindBy(xpath="//span[text()='Report ']") private WebElement report;


	public WebElement getEnterEmail() {
		return enterEmail;
	}

	public WebElement getEnterPassword() {
		return enterPassword;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getThreeDotButton() {
		return threeDotButton;
	}

	public WebElement getReport() {
		return report;
	}

}
