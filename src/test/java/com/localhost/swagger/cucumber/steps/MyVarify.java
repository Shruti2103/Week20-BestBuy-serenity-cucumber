package com.localhost.swagger.cucumber.steps;

import com.localhost.swagger.productinfo.StoreSteps;
import com.localhost.swagger.utils.TestUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasKey;

public class MyVarify {
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
    @When("^User sends a GET request to list endpoint of stores$")
    public void userSendsAGETRequestToListEndpointOfStores() {
        response=new StoreSteps().getstore();
    }

    @Then("^User must get back a valid status code (\\d+) of stores$")
    public void userMustGetBackAValidStatusCodeOfStores(int code) {
        response.statusCode(code);
    }

    @And("^User must varrify if the total is equal to (\\d+)$")
    public void userMustVarrifyIfTheTotalIsEqualTo(int arg0) {
        response= response.body("total", equalTo(1567));

    }

    @And("^User must varrify if the stores of limit is equal to (\\d+)$")
    public void userMustVarrifyIfTheStoresOfLimitIsEqualTo(int arg0) {
        response=response.body("limit", equalTo(10));
    }

    @And("^user must  Check the single ‘Name’ in the Array list \\(Inver Grove Heights\\)$")
    public void userMustCheckTheSingleNameInTheArrayListInverGroveHeights() {
        response=response.body("data.name", hasItem("Inver Grove Heights"));
    }

    @And("^User must Check the multiple ‘Names’ in the ArrayList \\(Roseville, Burnsville, Maplewood\\)$")
    public void userMustCheckTheMultipleNamesInTheArrayListRosevilleBurnsvilleMaplewood() {
        response=  response.body("data.name", hasItem("Roseville"))
                .body("data.name", hasItem("Burnsville"))
                .body("data.name", hasItem("Maplewood"));
    }

    @And("^User must Verify the storied=7 inside storeservices of the third store of second services$")
    public void userMustVerifyTheStoriedInsideStoreservicesOfTheThirdStoreOfSecondServices() {
    response=storeSteps.getstore();
  //  response.body("data[2].services[1].storeservices.storeId", equalTo("7"));
    }

    @And("^User must Check hash map values ‘createdAt’ inside storeservices map where store name = Roseville$")
    public void userMustCheckHashMapValuesCreatedAtInsideStoreservicesMapWhereStoreNameRoseville() {
        response=response.body("data[1].services.storeservices", hasKey("createdAt"));
    }

    @And("^User must Verify the state = MN of forth store$")
    public void userMustVerifyTheStateMNOfForthStore() {
       response= response.body("data[3].state", equalTo("MN"));
    }

    @And("^User must Verify the store name = Rochester of (\\d+)th store$")
    public void userMustVerifyTheStoreNameRochesterOfThStore(int arg0) {
        response=response.body("data[8].name", equalTo("Rochester"));
    }

    @And("^User must Verify the storeId = (\\d+) for the (\\d+)th store$")
    public void userMustVerifyTheStoreIdForTheThStore(int arg0, int arg1) {
        response=response.body("data[5].services.storeservices.storeId", hasItem(11));
    }

    @And("^User Verify the serviceId = (\\d+) for the (\\d+)th service$")
    public void userVerifyTheServiceIdForTheThService(int arg0, int arg1) {
        response= response.body("data[6].services[3].storeservices.serviceId", equalTo(4));

    }
}
