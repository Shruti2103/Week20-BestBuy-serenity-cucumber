package com.localhost.swagger.cucumber.steps;

import com.localhost.swagger.productinfo.StoreSteps;
import com.localhost.swagger.utils.TestUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class MyStore {
    static String name = "Energizer - MAX Batteries AA (4-Pack)" + TestUtils.getRandomValue();
    static String type = "HardGood" + TestUtils.getRandomValue();
    static String address = "16, lyon Road" + TestUtils.getRandomValue();
    static String address2 = "Harrow" + TestUtils.getRandomValue();
    static String city = "Ahmedabad" + TestUtils.getRandomValue();
    static String state = "Gujarat" + TestUtils.getRandomValue();
    static String zip = "123456" + TestUtils.getRandomValue();
    static int lat = 123;
    static int lng = 456;
    static String hours = "10";


    static int storeID;
    static ValidatableResponse response;
    @Steps
    StoreSteps storeSteps;
    @When("^User sends a GET request to list endpoint of store$")
    public void userSendsAGETRequestToListEndpointOfStore() {
        response=new StoreSteps().getstore();
    }

    @Then("^User must get back a valid status code (\\d+) of store$")
    public void userMustGetBackAValidStatusCodeOfStore(int code) {
        response.statusCode(code);
    }

    @When("^I create a new store by providing the storeId$")
    public void iCreateANewStoreByProvidingTheStoreId() {
        HashMap<Object, Object> services = new HashMap<>();
        services.put("storeId", 1);
        services.put("serviceId", 1);
        response=storeSteps.createStore(name, type, address, address2, city, state, zip, lat, lng, hours, services);
        response.log().all().statusCode(201);
        storeID = response.log().all().extract().path("id");
        System.out.println(storeID);
    }

    @When("^I update a new store by providing the storeId$")
    public void iUpdateANewStoreByProvidingTheStoreId() {
        name = name + "_updated";
        HashMap<Object, Object> services = new HashMap<>();
        services.put("storeId", 1);
        services.put("serviceId", 1);

    response=    storeSteps.updateStore( storeID,name,  type,  address,address2,
                city,  state,  zip,  lat,  lng,  hours, services) .log().all().statusCode(200);


        HashMap<Object, Object> storeMap = storeSteps.getStoreInfoByID(storeID);
        Assert.assertThat(storeMap, hasValue(name));

    }

    @When("^I delete a new store by providing the storeId$")
    public void iDeleteANewStoreByProvidingTheStoreId() {
        response= storeSteps.deletestore(storeID).statusCode(200);

    }

    @Then("^User must get back a valid status code (\\d+) of store for varrify$")
    public void userMustGetBackAValidStatusCodeOfStoreForVarrify(int code) {
        storeSteps.getstortById(storeID).statusCode(404);
    }
}
