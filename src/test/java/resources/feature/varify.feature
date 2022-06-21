@SMOKE
Feature: Varrify different request on the BestBuy application

  Scenario: Check if the store application can be accessed by users
    When User sends a GET request to list endpoint of stores
    Then User must get back a valid status code 200 of stores
    And User must varrify if the total is equal to 1561
    And User must varrify if the stores of limit is equal to 10
    And user must  Check the single ‘Name’ in the Array list (Inver Grove Heights)
    And User must Check the multiple ‘Names’ in the ArrayList (Roseville, Burnsville, Maplewood)
    And User must Verify the storied=7 inside storeservices of the third store of second services
    And User must Check hash map values ‘createdAt’ inside storeservices map where store name = Roseville
    And User must Verify the state = MN of forth store
   And User must Verify the store name = Rochester of 9th store
    And User must Verify the storeId = 11 for the 6th store
   And User Verify the serviceId = 4 for the 7th service



