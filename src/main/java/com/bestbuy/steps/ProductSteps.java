package com.bestbuy.steps;

import com.bestbuy.constants.EndPoints;
import com.bestbuy.model.ProductAPIRequest;
import com.bestbuy.model.ProductsPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

public class ProductSteps {
    static int productId;

    @Step("Creating product with name : {0}, type : {1}, price : {2}, shipping : {3}, upc : {4}, description : {5}, manufacturer : {6}, model : {7}, url : {8}, image : {9}")
    public ValidatableResponse createProduct(String name, String type, double price, String shipping, String upc, String description, String manufacturer, String model, String url, String image) {
        ProductsPojo productsPojo = ProductAPIRequest.getAPIProductRequest(name, type, price, shipping, upc, description, manufacturer, model, url, image);
        return SerenityRest.rest()
                .given()
                .log()
                .all().contentType(ContentType.JSON)
                .when()
                .body(productsPojo)
                .post(EndPoints.CREATE_PRODUCT)
                .then().log().ifValidationFails();
    }

    @Step("Getting the Product information with productID:{0}")
    public ValidatableResponse getProductsById(int productId) {
        return SerenityRest.rest()
                .given()
                .log()
                .all()
                .pathParam("productId", productId)
                .contentType(ContentType.JSON)
                .when()
                .get(EndPoints.GET_PRODUCT_BY_ID)
                .then().log().ifValidationFails();
    }

    @Step("Getting all the products information")
    public ValidatableResponse getAllProducts() {
        return SerenityRest.rest()
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .when()
                .get(EndPoints.GET_ALL_PRODUCTS)
                .then().log().ifValidationFails();
    }

    @Step("Updating product information with productId: {0}, updated field{1}")
    public ValidatableResponse updateProduct(String name, String type, double price, String shipping, String upc, String description, String manufacturer, String model, String url, String image) {
        ProductsPojo productsPojo = ProductAPIRequest.getAPIProductRequest(name, type, price, shipping, upc, description, manufacturer, model, url, image);
        return SerenityRest.rest()
                .given()
                .log()
                .all().contentType(ContentType.JSON)
                .pathParam("productId", productId)
                .when()
                .body(productsPojo)
                .patch(EndPoints.UPDATE_PRODUCT_BY_ID)
                .then().log().ifValidationFails();
    }

    @Step("Deleting product information")
    public ValidatableResponse deleteProduct(int productId) {
        return SerenityRest.rest()
                .given()
                .log()
                .all()
                .pathParam("productId", productId)
                .when()
                .delete(EndPoints.DELETE_PRODUCT)
                .then().log().ifValidationFails();
    }

    @Step("Verifying the Product id information with productID:{0} , if deleted!")
    public ValidatableResponse verifyProductId(int productId) {
        return SerenityRest.rest()
                .given()
                .log()
                .all()
                .pathParam("productId", productId)
                .when()
                .get(EndPoints.GET_PRODUCT_BY_ID)
                .then();
    }
}
