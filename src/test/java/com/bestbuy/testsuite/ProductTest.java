package com.bestbuy.testsuite;

import com.bestbuy.steps.ProductSteps;
import com.bestbuy.testbase.TestBase;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.annotations.WithTag;
import net.serenitybdd.annotations.WithTags;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.bestbuy.utils.TestUtils.getRandomValue;

@RunWith(SerenityRunner.class)
public class ProductTest extends TestBase {
    static int productId;
    String name = "Philips TurboMax Batteries" + getRandomValue();
    String type = "HardLine";

    String shipping = "Cruise";
    String url = "Strings";
    String image = "Strings";
    String manufacturer ="philips";
    String upc = "666777" + getRandomValue();
    double price = 4.50;
    String description = "Creating a new product";
    String model = "203203" + getRandomValue();

    @Steps
    ProductSteps steps;
    @Title("Creating new product")
    @Test
    public void creatingNewProduct() {
        steps.createProduct(name, type, price, shipping, upc, description, manufacturer, model, url, image).statusCode(200);
    }

    @Title("Getting product by ID")
    @Test
    public void getProductByID() {
        int productId = steps.getAllProducts().extract().path("id");
        steps.getProductsById(productId).statusCode(200);
    }


    @Title("Getting all Products information")
    @Test
    public void getAllProducts() {
        steps.getAllProducts().statusCode(200);
    }


    @Title("Deleting product")
    @Test
    public void deleteProduct() {
        int productId = steps.getAllProducts().extract().path("data[0].id");
        steps.deleteProduct(productId).statusCode(200);
    }

}
