
Feature: Flipkart flight booking
Description: The purpose of this feature is to check the Flipkart flight booking till the pament page

Background: Login to flipkart
Given load "<url>"
|https://www.flipkart.com/|
When enter the "<userName>" and "<password>" and login
|prajularavi@gmail.com |flipkart|

Scenario: flight booking
When navigate to the flights section
And enter the flight details and click search
|BOM|MAA|
And select one flight and click book
And review itinerary click continue
And enter adult traveller details
|Ravichandran | Ganesan | XS786543R786 |
|Aruna        | Devi    | XS786543R286 |
And enter child traveller details 
|Vilasini |Ravichandran|
|Prajula  |Ravichandran|
And enter contact information 
|7094782427|prajularavi@gmail.com|
Then navigation should be made to the payment page when clicking continue






