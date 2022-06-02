package com.stepdefinitions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pagefactory.flipkart.Dashboard;
import com.pagefactory.flipkart.Login;
import com.pagefactory.flipkart.MobileSearch;
import com.utility.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlipkartMobileSearch extends BaseClass {

	Dashboard dashboard;
	String userSelectedPage;
	MobileSearch results;
	Map<String, String> mobileDetails;
	
	Logger log = LogManager.getLogger(FlipkartMobileSearch.class);
	

	@Given("login to {string}")
	public void login_to(String url) {
		launchEdge();
		get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	@When("enter userName \\({string}) and password\\({string}) and login")
	public void enter_user_name_and_password_and_login(String email, String password) throws InterruptedException {
		Login login = new Login(driver);
		sendKeys(login.getEmailId(), email);
		sendKeys(login.getPassword(), password);
		click(login.getSubmit());
		Thread.sleep(2000);

	}
	@When("search for {string} and click enter")
	public void search_for_and_click_enter(String searchKeyword) throws InterruptedException {
		dashboard = new Dashboard(driver);
		sendKeys(dashboard.getSearch(), searchKeyword);
		Thread.sleep(2000);
		dashboard.getSearchIcon().click();    
	}
	
	
	@When("get the mobile page number from the user")
	public void get_the_mobile_page_number_from_the_user() {
		log.info("going to get the mobile number from user");
		results = new MobileSearch(driver);
		log.info("What page results do you want to see?");
		for(WebElement pageNumber: results.getPageNumbers()) {
			System.out.print(pageNumber.getText()+" ");
		}
		System.out.println("\nPlease enter the page number below from the options displayed above");

		Scanner sc = new Scanner(System.in);
		userSelectedPage = sc.nextLine();
		sc.close();

	}
	
	@When("click on the page the user has entered")
	public void click_on_the_page_the_user_has_entered() throws InterruptedException {
		results = new MobileSearch(driver);
		for(WebElement page: results.getPageNumbers()) {
			String text = page.getText();
			if(userSelectedPage.equals(text)) {
				jsClickElement(page);
				Thread.sleep(2000);
			}
		}

	}
	
	@Then("mobile name, price and description details from the selected page should be displayed")
	public void mobile_name_price_and_description_details_from_the_selected_page_should_be_displayed() {
		 results = new MobileSearch(driver);
		int totalResults = results.getMobileNamesList().size();
		System.out.println("Total result count in page number "+userSelectedPage+" is: "+totalResults);
		System.out.println();
		//mobile name
		for(int i=0; i<totalResults; i++) {
			System.out.println("\nMOBILE MODEL: "+ results.getMobileNamesList().get(i).getText());	
			//mobile price
			for(int j=i; j==i; j++) {
				String priceText = results.getMobilePriceList().get(j).getText();
				String priceINR = priceText.replace("₹", "INR ");
				System.out.println("PRICE: "+ priceINR);
			}
			//mobile description
			for(int k=i; k==i; k++ ) {
				WebElement dataId = results.getMobileDataIdSet().get(k);
				String dataID= jsGetAttribute(dataId, "data-id");
				List<WebElement> descriptions = dataId.findElements(By.xpath("//div[@class='_13oc-S']//div[@data-id='"+dataID+"']//ul/li"));
				System.out.println("KEY FEATURES:");
				for(WebElement description: descriptions){
					System.out.println(description.getText());
			}
			}
			System.out.println();
		}
	}
	
	@Then("mobile name and price should be displayed as key and value pair")
	public void mobile_name_and_price_should_be_displayed_as_key_and_value_pair() {
		
		MobileSearch results = new MobileSearch(driver);
		int totalResults = results.getMobileNamesList().size();
		mobileDetails = new LinkedHashMap<String, String>();
		System.out.println("Total result count in page number "+userSelectedPage+" is: "+totalResults);
		System.out.println();
		//mobile name
		for(int i=0; i<totalResults; i++) {
			String mobileName = results.getMobileNamesList().get(i).getText();	
			//mobile price
			for(int j=i; j==i; j++) {
				String priceText = results.getMobilePriceList().get(j).getText();
				String priceINR = priceText.replace("₹", "INR ");
				mobileDetails.put(mobileName, priceINR);
			}
		}
		
		Set<Entry<String, String>> mobileSet = mobileDetails.entrySet();
		for(Entry<String,String> oneMobile: mobileSet) {
			System.out.print("Mobile Name: "+ oneMobile.getKey());
			System.out.print("\tMobile Price: "+ oneMobile.getValue());
			System.out.println();
		}

	}}