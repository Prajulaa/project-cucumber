package com.pagefactory.flipkart;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileSearch {
	WebDriver driver;
	
	public MobileSearch(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div/nav/a[contains(@class,'ge-49M')]") private List<WebElement> pageNumbers;

	@FindBy(xpath="//div[@class='_2kHMtA']//div[@class='_4rR01T']") private List<WebElement> mobileNamesList;
	@FindBy(xpath="//div[@class='_2kHMtA']//div[@class='_25b18c']/div[@class='_30jeq3 _1_WHN1']") private List<WebElement> mobilePriceList;
	@FindBy(xpath="//div[@class='_13oc-S']/div") private List<WebElement> mobileDataIdSet;
	
	public List<WebElement> getPageNumbers() {
		return pageNumbers;
	}
	
	public List<WebElement> getMobileNamesList() {
		return mobileNamesList;
	}
	public List<WebElement> getMobileDataIdSet() {
		return mobileDataIdSet;
	}
	public List<WebElement> getMobilePriceList() {
		return mobilePriceList;
	}

	
}
