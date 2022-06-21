package com.localhost.swagger.cucumber.steps;

import com.localhost.swagger.productinfo.ProductSteps;
import com.localhost.swagger.utils.TestUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class MyStepdefs {
    static String name = "Connected Home & Housewares" + TestUtils.getRandomValue();
    static String type = "HardGood" + TestUtils.getRandomValue();
    static double price = 10000;
    static double shipping = 1;
    static String upc = "0413334300" + TestUtils.getRandomValue();
    static String description = "Compatible with select electronic devices; D size; DURALOCK Power Preserve technology; 6-pack" + TestUtils.getRandomValue();
    static String manufacture = "Duracell";
    static String model = "MN1400R3K" + TestUtils.getRandomValue();
    static String url = "http://www.bestbuy.com/site/duracell-c-batteries-4-pack/185230.p?id=1051384046486&skuId=185230&cmp=RMXCC" + TestUtils.getRandomValue();
    static String image = "http://img.bbystatic.com/BestBuy_US/images/products/1852/185230_sa.jpg" + TestUtils.getRandomValue();

    static int productID;
     static ValidatableResponse response;
    @Steps
    ProductSteps productSteps;

    @When("^User sends a GET request to list endpoint$")
    public void userSendsAGETRequestToListEndpoint() {
        response= new ProductSteps().getproducts();

    }

    @Then("^User must get back a valid status code (\\d+)$")
    public void userMustGetBackAValidStatusCode(int code) {
        response.statusCode(code);
    }

    @When("^I create a new product by providing the productId$")
    public void iCreateANewProductByProvidingTheProductId() {
        response=productSteps.createProduct(name, type, price, shipping, upc, description, manufacture, model, url, image);
        response.log().all().statusCode(201);
        productID = response.log().all().extract().path("id");
        System.out.println(productID);
    }


    @When("^I update a new product by providing the productId$")
    public void iUpdateANewProductByProvidingTheProductId() {
        response=productSteps.updateProduct(productID, name, type, price, shipping, upc, description, manufacture,
                model, url, image).log().all().statusCode(200);

        HashMap<String, Object> productMap = productSteps.getProductInfoByID(productID);
        Assert.assertThat(productMap, hasValue(name));

    }

    @When("^I delete a new product by providing the productId$")
    public void iDeleteANewProductByProvidingTheProductId() {
        response= productSteps.deleteproduct(productID).statusCode(200);
        productSteps.getproducttById(productID).statusCode(404);



    }

    @And("^User should verify that product is deleted with (\\d+)$")
    public void userShouldVerifyThatProductIsDeletedWith(int code) {
        productSteps.getproducttById(productID).statusCode(404);
    }
}
