package com.localhost.swagger.cucumber.steps;

import com.localhost.swagger.productinfo.CategoriesSteps;
import com.localhost.swagger.utils.TestUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class MyCategories {
    static String id = "3" + TestUtils.getRandomValue();
    static String name = "PrimeUser" + TestUtils.getRandomValue();

    static String categoriesID;
    static ValidatableResponse response;
    @Steps
    CategoriesSteps categoriesSteps;

    @When("^User sends a GET request to list endpoint of categories$")
    public void userSendsAGETRequestToListEndpointOfCategories() {
        response=new CategoriesSteps().getcategories();

    }

    @Then("^User must get back a valid status code (\\d+) of categories$")
    public void userMustGetBackAValidStatusCodeOfCategories(int code) {
        response.statusCode(code);
    }

    @When("^I create a new categories by providing the categoriesId$")
    public void iCreateANewCategoriesByProvidingTheCategoriesId() {
        response=categoriesSteps.createCategories(id,name);
        response.log().all().statusCode(201);
        categoriesID=response.log().all().extract().path("id");
        System.out.println(categoriesID);
    }

    @When("^I update a new categories by providing the categoriesId$")
    public void iUpdateANewCategoriesByProvidingTheCategoriesId() {
        name = name + "_updated";

    response=    categoriesSteps.updateCategories(categoriesID,id,name)
                .log().all().statusCode(200);

        HashMap<Object, Object> categoryMap = categoriesSteps.getCategoriesBYID(categoriesID);
        Assert.assertThat(categoryMap, hasValue(name));
    }

    @When("^I delete a new store by providing the categoriesId$")
    public void iDeleteANewStoreByProvidingTheCategoriesId() {
     response=   categoriesSteps.deleteCategories(categoriesID).statusCode(200);
    }

    @Then("^User must get back a valid status code (\\d+) of categories for varrify$")
    public void userMustGetBackAValidStatusCodeOfCategoriesForVarrify(int code) {
    response=    categoriesSteps.getCategoriesById(categoriesID).statusCode(404);
    }
}
