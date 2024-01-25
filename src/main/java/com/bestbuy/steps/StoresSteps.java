package com.bestbuy.steps;

import com.bestbuy.constants.EndPoints;
import com.bestbuy.model.StoresAPIRequest;
import com.bestbuy.model.StoresPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

public class StoresSteps {
    @Step("Creating store with; name : {0}, type : {1}, address : {2}, address2 : {3}, city : {4}, state : {5}, zip : {6}, lat : {7}, lng : {8}, hours : {9}")
    public ValidatableResponse createStore(String name, String type, String address, String address2, String city, String state, String zip, int lat, int lng, String hours ) {
        StoresPojo storesPojo = StoresAPIRequest.getAPIStoresRequest(name, type,address,address2,city,state,zip,lat,lng,hours);
        return SerenityRest.rest()
                .given()
                .log()
                .all().contentType(ContentType.JSON)
                .when()
                .body(storesPojo)
                .post(EndPoints.CREATE_STORE)
                .then().log().ifValidationFails();
    }


}
