package com.stepdefinitions;

import java.util.List;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import com.pagefactory.flipkart.Dashboard;
import com.pagefactory.flipkart.FlightReviewBooking;
import com.pagefactory.flipkart.FlightSearch;
import com.pagefactory.flipkart.FlightSelect;
import com.pagefactory.flipkart.Login;
import com.utility.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlipkartFlightBooking extends BaseClass {
	

	List<String> data;
	List<List<String>> datas;
	FlightReviewBooking review;

	@Given("load {string}")
	public void load(String string, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		launchFirefox();
		clearBrowserCache();
		data = dataTable.asList();
		String url= data.get(0);
		get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@When("enter the {string} and {string} and login")
	public void enter_the_and_and_login(String string, String string2, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		Login login = new Login(driver);
		data= dataTable.asList();
		String userName = data.get(0);
		sendKeys(login.getEmailId(), userName);
		String password = data.get(1);
		sendKeys(login.getPassword(), password);
		click(login.getSubmit());
		Thread.sleep(4000);

	}

	@When("navigate to the flights section")
	public void navigate_to_the_flights_section() {

		Dashboard homePage = new Dashboard(driver);
		click(homePage.getTravelButton());
	}

	@When("enter the flight details and click search")
	public void enter_the_flight_details_and_click_search(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		FlightSearch search = new FlightSearch(driver);
		search.getRoundTrip().click();


		//place
		data = dataTable.asList();
		sendKeys(search.getDepartureCity(),data.get(0));
		Thread.sleep(1000);
		String enterPlace = Keys.chord(Keys.ARROW_DOWN, Keys.ENTER);
		sendKeys(search.getDepartureCity(), enterPlace);
		sendKeys(search.getArrivalCity(),data.get(1));
		Thread.sleep(1000);
		sendKeys(search.getArrivalCity(), enterPlace);


		//date
		if(search.getCalNextMonth().isEnabled()) {
			search.getCalNextMonth().click(); 
			search.getCalDateLhs().click();
			search.getCalDateRhs().click(); 
		}
		else {
			while(search.getCalPrevMonth().isEnabled()) {
				search.getCalPrevMonth().click();
			}
			search.getCalDateRhs().click();
			search.getCalNextMonth().click();
			search.getCalNextMonth().click();
			search.getCalDateLhs().click();

		}


		//travellers/class
		search.getTravellersClass().click();
		int adultNumber = Integer.parseInt(search.getAdultCount().getText());
		while(adultNumber>2) {
			search.getMinusAdult().click();
			adultNumber--;
		}

		int childCount = Integer.parseInt(search.getChildCount().getText());
		while(childCount>2) {
			search.getMinusChildren().click();
			childCount--;
		}
		int infantCount = Integer.parseInt(search.getInfantCount().getText());
		while(!(infantCount==0)) {
			search.getMinusInfant().click();
			infantCount--;	
		}
		search.getBusiness().click();
		Thread.sleep(1000);
		search.getTravellersClassDone().click();

		//search for results
		search.getSearch().click();

		Thread.sleep(6000);		

	}



	@When("select one flight and click book")
	public void select_one_flight_and_click_book() throws InterruptedException {

		FlightSelect select = new FlightSelect(driver);
		select.getNewBook().click();


	}
	@When("review itinerary click continue")
	public void review_itinerary_click_continue() {

		review = new FlightReviewBooking(driver);
		review.getItineraryContinue().click();


	}
	@When("enter adult traveller details")
	public void enter_adult_traveller_details(io.cucumber.datatable.DataTable dataTable) {


		datas = dataTable.asLists();
		review = new FlightReviewBooking(driver);
		//adult 1
		Select title = new Select(review.getAdult1Title());
		title.selectByVisibleText("Mr");
		sendKeys(review.getAdult1FirstName(), datas.get(0).get(0));
		sendKeys(review.getAdult1LastName(), datas.get(0).get(1));

		Select select = new Select(review.getNationality());
		select.selectByVisibleText("India");

		//adult2
		Select adult2Title = new Select(review.getAdult2Title());
		adult2Title.selectByVisibleText("Mrs");
		sendKeys(review.getAdult2FirstName(), datas.get(1).get(0));
		sendKeys(review.getAdult2LastName(), datas.get(1).get(1));

		Select adult2Nationality = new Select(review.getAdult2Nationality());
		adult2Nationality.selectByVisibleText("India");

	}
	@When("enter child traveller details")
	public void enter_child_traveller_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		review = new FlightReviewBooking(driver);
		datas= dataTable.asLists();

		//child 1 details

		Select child1Title = new Select(review.getChild1Title());
		child1Title.selectByVisibleText("Miss");
		sendKeys(review.getChild1FirstName(), datas.get(1).get(0));
		sendKeys(review.getChild1LastName(), datas.get(1).get(1));

		Select child1Date = new Select(review.getChild1Date());
		child1Date.selectByVisibleText("24");
		Select child1Month = new Select(review.getChild1Month());
		child1Month.selectByVisibleText("Sep");
		Select child1Year = new Select(review.getChild1Year());
		child1Year.selectByIndex(5);

				Thread.sleep(3000);
				Select child1Nationality = new Select(review.getChild1Nationality());
				child1Nationality.selectByVisibleText("India");


	}
	
	@When("enter contact information")
	public void enter_contact_information(io.cucumber.datatable.DataTable dataTable) {
		data = dataTable.asList();
		review = new FlightReviewBooking(driver);
		jsScrollToElementTrue(review.getPhoneNumber());
		sendKeys(review.getPhoneNumber(), (data.get(0)));
		review.getEmailAddress().sendKeys(data.get(1));
	}
	
	@Then("navigation should be made to the payment page when clicking continue")
	public void navigation_should_be_made_to_the_payment_page_when_clicking_continue() {
		review = new FlightReviewBooking(driver);
		review.getContinueAfterContact().click();
	}


}
