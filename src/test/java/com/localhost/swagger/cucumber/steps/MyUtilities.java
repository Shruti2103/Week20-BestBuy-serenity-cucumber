package com.localhost.swagger.cucumber.steps;

import com.localhost.swagger.productinfo.UtilitiesSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;

public class MyUtilities {
    static ValidatableResponse response;
    @When("^User sends a GET request to list endpoint of utilities$")
    public void userSendsAGETRequestToListEndpointOfUtilities() {
       response=new UtilitiesSteps().getutilities();
    }

    @Then("^User must get back a valid status code (\\d+) of utilities$")
    public void userMustGetBackAValidStatusCodeOfUtilities(int code) {
        response.statusCode(code);
    }
}
