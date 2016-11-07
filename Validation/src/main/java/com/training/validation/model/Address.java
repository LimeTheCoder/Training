package com.training.validation.model;

import com.training.validation.view.View;

/**
 * Part of the model that describes address entity
 *
 * @version 06 Nov 2016
 * @author Taras Sakharchuk
 */
public class Address {
    private String postalCode;
    private String city;
    private String street;
    private String building;
    private int apartment;


    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    /**
     * Combine fields of object to produce full information about it.
     *
     * @return full address
     */
    public String getFullAddress(){
        return new StringBuilder().append(postalCode)
                .append(View.SPACE_DELIMITER)
                .append(city).append(View.SPACE_DELIMITER)
                .append(street).append(View.SPACE_DELIMITER)
                .append(building).append(View.SPACE_DELIMITER)
                .append(apartment)
                .toString();
    }
}