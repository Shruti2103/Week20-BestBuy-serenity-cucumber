
Feature: Testing different request on the BestBuy application

  Scenario: Check if the services application can be accessed by users
    When User sends a GET request to list endpoint of services
    Then User must get back a valid status code 200 of services

  Scenario: Create a new services & verify if the services is added
    When I create a new services by providing the servicesId
    Then User must get back a valid status code 201 of services

  Scenario: Update a new services & verify if the services is updated
    When I update a new services by providing the servicesId
    Then User must get back a valid status code 200 of services

  Scenario: Delete a new services & verify if the services is Deleted
    When I delete a new services by providing the servicesId
    Then User must get back a valid status code 200 of services for varrify
