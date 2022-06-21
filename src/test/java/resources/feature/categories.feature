
Feature: Testing different request on the BestBuy application

  Scenario: Check if the categories application can be accessed by users
    When User sends a GET request to list endpoint of categories
    Then User must get back a valid status code 200 of categories

  Scenario: Create a new categories & verify if the categories is added
    When I create a new categories by providing the categoriesId
    Then User must get back a valid status code 201 of categories

  Scenario: Update a new categories & verify if the categories is updated
    When I update a new categories by providing the categoriesId
    Then User must get back a valid status code 200 of categories

  Scenario: Delete a new categories & verify if the categories is Deleted
    When I delete a new store by providing the categoriesId
    Then User must get back a valid status code 200 of categories for varrify
