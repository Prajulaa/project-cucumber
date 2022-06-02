package com.pagefactory.flipkart;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
	WebDriver driver;
	
	public Dashboard(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
@FindBy(xpath="//input[@title='Search for products, brands and more']") private WebElement search;
@FindBy(xpath="//button[@class='L0Z3Pu']") private WebElement searchIcon;
@FindBy(xpath="//img[@alt='Travel']") private WebElement travelButton;

public WebElement getSearch() {
	return search;
}

public WebElement getSearchIcon() {
	return searchIcon;
}
public WebElement getTravelButton() {
	return travelButton;
}


}
