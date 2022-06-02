package com.pagefactory.flipkart;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightReviewBooking {
	
	WebDriver driver;
	
	public FlightReviewBooking(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='MfYxi1']") private WebElement itineraryContinue;
	
	@FindBy(xpath="(//div[@class='_3vkNPQ'])[1]//select[@class='_1EDlbo _1bIJ-k iUXLpR b8a4WZ']") private WebElement adult1Title;
	@FindBy(xpath="(//div[@class='_3vkNPQ'])[1]//input[@name='First Name and Middle Name']") private WebElement adult1FirstName;
	@FindBy(xpath="(//div[@class='_3vkNPQ'])[1]//input[@name='Last Name']") private WebElement adult1LastName;
	@FindBy(xpath="(//div[@class='_3vkNPQ'])[1]//input[@name='Passport Number']") private WebElement adult1Passport;
	@FindBy(xpath="(//div[@class='_3vkNPQ'])[1]//select") private List<WebElement> adult1SelectTags;
	@FindBy(xpath="//input[@name='Phone Number']") private WebElement phoneNumber;
	@FindBy(xpath="//input[@name='Email Address']") private WebElement emailAddress;
	@FindBy(xpath="//div[text()='Continue']") private WebElement continueAfterContact;
	@FindBy(xpath="(//div[@class='_3vkNPQ'])[1]//option[text()='Nationality']/parent::select") private WebElement adult1Nationality;
	
	@FindBy(xpath="(//div[@class='_3vkNPQ'])[2]//select[@class='_1EDlbo _1bIJ-k iUXLpR b8a4WZ']") private WebElement adult2Title;
	@FindBy(xpath="(//div[@class='_3vkNPQ'])[2]//input[@name='First Name and Middle Name']") private WebElement adult2FirstName;
	@FindBy(xpath="(//div[@class='_3vkNPQ'])[2]//input[@name='Last Name']") private WebElement adult2LastName;
	@FindBy(xpath="(//div[@class='_3vkNPQ'])[2]//option[text()='Nationality']/parent::select") private WebElement adult2Nationality;
	
	@FindBy(xpath="(//div[@class='_3vkNPQ'])[3]//select[@class='_1EDlbo _1bIJ-k iUXLpR b8a4WZ']") private WebElement child1Title;
	@FindBy(xpath="(//div[@class='_3vkNPQ'])[3]//input[@name='First Name and Middle Name']") private WebElement child1FirstName;
	@FindBy(xpath="(//div[@class='_3vkNPQ'])[3]//input[@name='Last Name']") private WebElement child1LastName;
	@FindBy(xpath="(//div[@class='_3vkNPQ'])[3]//option[text()='Nationality']/parent::select") private WebElement child1Nationality;
	@FindBy(xpath="//select[@name='DD']") private WebElement child1Date;
	@FindBy(xpath="//select[@name='MM']") private WebElement child1Month;
	@FindBy(xpath="//select[@name='YY']") private WebElement child1Year;
	
	
	
	public WebElement getChild1Date() {
		return child1Date;
	}

	public WebElement getChild1Month() {
		return child1Month;
	}

	public WebElement getChild1Year() {
		return child1Year;
	}

	public WebElement getChild1Title() {
		return child1Title;
	}

	public WebElement getChild1FirstName() {
		return child1FirstName;
	}

	public WebElement getChild1LastName() {
		return child1LastName;
	}

	public WebElement getChild1Nationality() {
		return child1Nationality;
	}

	public WebElement getAdult2Title() {
		return adult2Title;
	}

	public WebElement getAdult2FirstName() {
		return adult2FirstName;
	}

	public WebElement getAdult2LastName() {
		return adult2LastName;
	}

	public WebElement getAdult2Nationality() {
		return adult2Nationality;
	}

	public WebElement getItineraryContinue() {
		return itineraryContinue;
	}
	
	public WebElement getNationality() {
		return adult1Nationality;
	}

	public WebElement getContinueAfterContact() {
		return continueAfterContact;
	}

	public WebElement getAdult1Title() {
		return adult1Title;
	}
	
	public List<WebElement> getAdult1SelectTags() {
		return adult1SelectTags;
	}
	
	
	public WebElement getAdult1FirstName() {
		return adult1FirstName;
	}
	
	public WebElement getAdult1LastName() {
		return adult1LastName;
	}
	
	public WebElement getAdult1Passport() {
		return adult1Passport;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getEmailAddress() {
		return emailAddress;
	}
	
	
	

}
