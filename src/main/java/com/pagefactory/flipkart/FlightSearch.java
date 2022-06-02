package com.pagefactory.flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightSearch {
	
	WebDriver driver;
	
	public FlightSearch(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//label[@for='ROUND_TRIP']") private WebElement roundTrip;
	@FindBy(xpath="//label[@for='ONE_WAY']") private WebElement oneWay;
	@FindBy(xpath="//input[contains(@name,'departcity')]") private WebElement departureCity;
	@FindBy(xpath="//input[contains(@name,'arrivalcity')]") private WebElement arrivalCity;
	@FindBy(xpath="//input[contains(@name,'datefrom')]") private WebElement dateFrom;
	@FindBy(xpath="//input[contains(@name,'dateto')]") private WebElement dateTo;
	@FindBy(xpath="//input[contains(@name,'travellerclasscount')]") private WebElement travellersClass;
	@FindBy(xpath="(//button[@class='_2KpZ6l _34K0qG _37Ieie'])[1]") private WebElement minusAdult;
	@FindBy(xpath="(//button[@class='_2KpZ6l _34K0qG _37Ieie'])[2]") private WebElement addAdult;
	@FindBy(xpath="(//div[@class='_19cAhQ _3ahBnm'])[1]") private WebElement adultCount;
	@FindBy(xpath="(//button[@class='_2KpZ6l _34K0qG _37Ieie'])[4]") private WebElement addChildren;
	@FindBy(xpath="(//button[@class='_2KpZ6l _34K0qG _37Ieie'])[3]") private WebElement minusChildren;
	@FindBy(xpath="(//div[@class='_19cAhQ _3ahBnm'])[2]") private WebElement childCount;
	@FindBy(xpath="(//button[@class='_2KpZ6l _34K0qG _37Ieie'])[5]") private WebElement minusInfant;
	@FindBy(xpath="(//div[@class='_19cAhQ _3ahBnm'])[3]") private WebElement infantCount;
	@FindBy(xpath="//div[@class='_2jIO64 _1NhOqr']/div[text()='Business']") private WebElement business;
	@FindBy(xpath="//div[@class='_2DGHmF']/button") private WebElement travellersClassDone;
	@FindBy(xpath="//span[text()='SEARCH']") private WebElement search;
	
	@FindBy(xpath="(//table[@class='aSgzfL']//button[text()='3'])[1]") private WebElement calDateLhs;
	@FindBy(xpath="(//table[@class='aSgzfL']//tr//th//button)[1]") private WebElement calPrevMonth;
	@FindBy(xpath="(//table[@class='aSgzfL']//tr//th//button)[2]") private WebElement calNextMonth;
	@FindBy(xpath="(//table[@class='aSgzfL']//button[text()='3'])[2]") private WebElement calDateRhs;
	
	
	public WebElement getCalDateLhs() {
		return calDateLhs;
	}
	public WebElement getRoundTrip() {
		return roundTrip;
	}
	public WebElement getOneWay() {
		return oneWay;
	}
	public WebElement getDepartureCity() {
		return departureCity;
	}
	public WebElement getArrivalCity() {
		return arrivalCity;
	}
	public WebElement getDateFrom() {
		return dateFrom;
	}
	public WebElement getDateTo() {
		return dateTo;
	}
	public WebElement getTravellersClass() {
		return travellersClass;
	}
	
	public WebElement getMinusAdult() {
		return minusAdult;
	}
	public WebElement getAddAdult() {
		return addAdult;
	}
	public WebElement getAdultCount() {
		return adultCount;
	}
	public WebElement getAddChildren() {
		return addChildren;
	}
	public WebElement getMinusChildren() {
		return minusChildren;
	}
	public WebElement getChildCount() {
		return childCount;
	}
	public WebElement getMinusInfant() {
		return minusInfant;
	}
	
	public WebElement getInfantCount() {
		return infantCount;
	}
	
	public WebElement getBusiness() {
		return business;
	}
	public WebElement getTravellersClassDone() {
		return travellersClassDone;
	}
	public WebElement getSearch() {
		return search;
	}
	public WebElement getCalNextMonth() {
		return calNextMonth;
	}
	public WebElement getCalDateRhs() {
		return calDateRhs;
	}
	public WebElement getCalPrevMonth() {
		return calPrevMonth;
	}
	
	
	

}
