
Feature: Testing different request on the BestBuy application

  Scenario: Check if the store application can be accessed by users
    When User sends a GET request to list endpoint of store
    Then User must get back a valid status code 200 of store

  Scenario: Create a new store & verify if the store is added
    When I create a new store by providing the storeId
    Then User must get back a valid status code 201 of store

  Scenario: Update a new store & verify if the store is updated
    When I update a new store by providing the storeId
    Then User must get back a valid status code 200 of store

  Scenario: Delete a new store & verify if the store is Deleted
    When I delete a new store by providing the storeId
    Then User must get back a valid status code 200 of store for varrify
