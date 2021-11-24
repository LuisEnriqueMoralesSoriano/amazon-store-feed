package mx.com.fahorro.apiamzstorefeed.model.dto;

import java.io.Serializable;

public class AddressDto implements Serializable {


    private String addressFieldOne;

    private String addressFieldTwo;

    private String city;

    private String region;

    private String postalCode;

    private String countryCode;

    private String latitude;

    private String longitude;

    public String getAddressFieldOne() {
        return addressFieldOne;
    }

    public void setAddressFieldOne(String addressFieldOne) {
        this.addressFieldOne = addressFieldOne;
    }

    public String getAddressFieldTwo() {
        return addressFieldTwo;
    }

    public void setAddressFieldTwo(String addressFieldTwo) {
        this.addressFieldTwo = addressFieldTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
