@mobileSearch
Feature: Flipkart Mobile Search
  
  @descriptionAlso
  Scenario: Searching mobile results
    Given login to "https://www.flipkart.com/"
    When enter userName ("prajularavi@gmail.com") and password("flipkart") and login
    And search for "mobiles" and click enter
    And get the mobile page number from the user
    And click on the page the user has entered
    Then mobile name, price and description details from the selected page should be displayed
    
    @onlyPrice
    Scenario: Searching mobile results
    Given login to "https://www.flipkart.com/"
    When enter userName ("prajularavi@gmail.com") and password("flipkart") and login
    And search for "mobiles" and click enter
    And get the mobile page number from the user
    And click on the page the user has entered
    Then mobile name and price should be displayed as key and value pair
    
   
