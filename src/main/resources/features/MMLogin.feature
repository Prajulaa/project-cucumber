Feature: Muslim Match login
  
  @MMlogin
  Scenario: Login to Muslim Match with usable profile credentials
    Given The login user should be a usable profile "<UserName>"
    When I enter the official Muslim Match website
    And enter username "smuthuqa@gmail.com" and enter password "test4mm" and click submit
    And click on report
    And should be landed on the matches section
    Then report banner should be opened
    