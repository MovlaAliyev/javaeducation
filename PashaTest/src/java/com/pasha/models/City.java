package com.pasha.models;


public class City implements Model{
    
    private long   id;
    private String name;
    private String countryCode;
    private String district;

    public City() {
    }

    public City(long id, String name, String countryCode, String district) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getDistrict() {
        return district;
    }
    
    
}
