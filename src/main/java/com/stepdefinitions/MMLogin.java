package com.stepdefinitions;


import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.runner.RunWith;

import com.utility.BaseClass;

public class MMLogin extends BaseClass {


	@Given("The login user should be a usable profile")
	public void the_login_user_should_be_a_usable_profile() {

		launchEdge();
		get("https://www.muslimmatch.com/");
		

	}

	@When("enter username {string} and enter password {string} and click submit")
	public void enter_username_and_enter_password_and_click_submit(String string, String string2) {
		MMLogin login = new MMLogin();
//		sendKeys(, string2);

	}
	@When("click on report")
	public void click_on_report() {


	}
	@Then("report banner should be opened")
	public void report_banner_should_be_opened() {


	}

	@When("I enter the official Muslim Match website")
	public void i_enter_the_official_muslim_match_website() {


	}
	@When("should be landed on the matches section")
	public void should_be_landed_on_the_matches_section() {


	}




}