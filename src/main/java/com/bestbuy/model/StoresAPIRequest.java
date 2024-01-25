package com.bestbuy.model;

public class StoresAPIRequest {
    public static StoresPojo getAPIStoresRequest(String name, String type, String address, String address2, String city, String state, String zip, int lat, int lng, String hours) {
        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName(name);
        storesPojo.setType(type);
        storesPojo.setAddress(address);
        storesPojo.setAddress2(address2);
        storesPojo.setCity(city);
        storesPojo.setState(state);
        storesPojo.setZip(zip);
        storesPojo.setLat(lat);
        storesPojo.setLng(lng);
        storesPojo.setHours(hours);
        return storesPojo;
    }
}
