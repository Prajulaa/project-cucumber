package com.pagefactory.flipkart;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightSelect {
	
	public WebDriver driver;

	public FlightSelect(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='_2o0hgL']") private List<WebElement> loadMore;
	@FindBy(xpath="//div[text()='Book']") private List<WebElement> allFlights;
	
	@FindBy(xpath="//span[text()='Book']") private WebElement newBook;
	

	
	
	public WebElement getNewBook() {
		return newBook;
	}

	public List<WebElement> getAllFlights() {
		return allFlights;
	}

	public List<WebElement> getLoadMore() {
		return loadMore;
	}
	
	
}
