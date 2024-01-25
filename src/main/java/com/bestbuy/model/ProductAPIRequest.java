package com.bestbuy.model;

public class ProductAPIRequest {
    public static ProductsPojo getAPIProductRequest(String name, String type,double price,String shipping, String upc, String description, String manufacturer, String model, String url, String image) {
        ProductsPojo productsPojo = new ProductsPojo();
        productsPojo.setName(name);
        productsPojo.setType(type);
        productsPojo.setUpc(upc);
        productsPojo.setPrice(price);
        productsPojo.setDescription(description);
        productsPojo.setModel(model);
        productsPojo.setManufacturer(manufacturer);
        productsPojo.setUrl(url);
        productsPojo.setImage(image);
        productsPojo.setShipping(shipping);
        return productsPojo;
    }
}