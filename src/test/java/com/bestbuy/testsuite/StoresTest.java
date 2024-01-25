package com.bestbuy.testsuite;

import com.bestbuy.steps.ProductSteps;
import com.bestbuy.steps.StoresSteps;
import com.bestbuy.testbase.TestBase;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class StoresTest extends TestBase {
    String name = "Prime maker ltd";
    String type = "";
    String address = "23 abs street ";
    String address2 = "Hamster 56YDF";
    String city = "Tampa";
    String state = "Florida";
    String zip = "23 FT890";
    int lat = 123456;
    int lng = 678999;
    String hours = "10:20";
static int storeId;
    @Steps
    StoresSteps steps;

    @Title("Creating new Store")
    @Test
    public void creatingNewStore() {
        steps.createStore(name, type, address, address2, city, state, zip, lat, lng, hours).statusCode(200);
    }

    @Title("Getting store by ID")
    @Test
    public void getStoreByID() {
       // int storeId = steps.getAllStores( ).extract().path("id");
     //   steps.getStoreById(storeId).statusCode(200);
    }


}
