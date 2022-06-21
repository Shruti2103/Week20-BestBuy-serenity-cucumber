package com.localhost.swagger.productinfo;


import com.localhost.swagger.constants.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UtilitiesSteps {

    @Step("Getting store information of utilities: {0}")
    public ValidatableResponse getVersiondetal() {
        return SerenityRest
                .given()
                .when()
                .get(EndPoints.GET_ALL_UTILITIES)
                .then();
    }

    @Step("Getting store information of utilities: {0}")
    public ValidatableResponse getHealthcheckupDetail() {
        return SerenityRest
                .given()
                .when()
                .get(EndPoints.GET_ALL_Healthcheck)
                .then();
    }
    @Step("Getting utilities information :{0}")
    public ValidatableResponse getutilities(){
        return SerenityRest.given()
                .contentType(ContentType.JSON)
                .when()
                .get(EndPoints.GET_ALL_UTILITIES)
                .then()
                .log()
                .all();
    }



}
