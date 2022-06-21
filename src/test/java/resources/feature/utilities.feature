@SMOKE
Feature: Testing different request on the BestBuy application

  Scenario: Check if the utilities application can be accessed by users
    When User sends a GET request to list endpoint of utilities
    Then User must get back a valid status code 200 of utilities
