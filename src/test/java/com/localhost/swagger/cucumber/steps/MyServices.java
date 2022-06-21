package com.localhost.swagger.cucumber.steps;

import com.localhost.swagger.productinfo.CategoriesSteps;
import com.localhost.swagger.productinfo.ServicesSteps;
import com.localhost.swagger.utils.TestUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class MyServices {
    static String name = "Shruti" + TestUtils.getRandomValue();
    static ValidatableResponse response;
    static int servicesID;
    @Steps
    ServicesSteps servicesSteps;

    @When("^User sends a GET request to list endpoint of services$")
    public void userSendsAGETRequestToListEndpointOfServices() {
        response=new ServicesSteps().getservices();
    }

    @Then("^User must get back a valid status code (\\d+) of services$")
    public void userMustGetBackAValidStatusCodeOfServices(int code) {
        response.statusCode(code);
    }

    @When("^I create a new services by providing the servicesId$")
    public void iCreateANewServicesByProvidingTheServicesId() {
        response=servicesSteps.createServices(name);
        response.log().all().statusCode(201);
        servicesID = response.log().all().extract().path("id");
        System.out.println(servicesID);
    }

    @When("^I update a new services by providing the servicesId$")
    public void iUpdateANewServicesByProvidingTheServicesId() {
        name = name + "_updated";

    response=    servicesSteps.updateServices(servicesID, name
        ).log().all().statusCode(200);

        HashMap<Object, Object> servicesMap = servicesSteps.getServicesInfoByID(servicesID);
        Assert.assertThat(servicesMap, hasValue(name));
    }

    @When("^I delete a new services by providing the servicesId$")
    public void iDeleteANewServicesByProvidingTheServicesId() {
        response= servicesSteps.deleteServices(servicesID).statusCode(200);
    }

    @Then("^User must get back a valid status code (\\d+) of services for varrify$")
    public void userMustGetBackAValidStatusCodeOfServicesForVarrify(int code) {
        response= servicesSteps.getServicesById(servicesID).statusCode(404);
    }
}
