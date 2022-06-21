
Feature: Testing different request on the BestBuy application

  Scenario: Check if the product application can be accessed by users
    When User sends a GET request to list endpoint
    Then User must get back a valid status code 200

  Scenario: Create a new product & verify if the product is added
    When I create a new product by providing the productId
    Then User must get back a valid status code 201

  Scenario: Update a new product & verify if the product is updated
    When I update a new product by providing the productId
    Then User must get back a valid status code 200

  Scenario: Delete a new product & verify if the product is Deleted
    When I delete a new product by providing the productId
    Then User must get back a valid status code 200
    And User should verify that product is deleted with 200










