package mx.com.fahorro.apiamzstorefeed.model;

import java.io.Serializable;
import java.util.List;

public class StoreFeed implements Serializable {

    private String accessPointId;

    private String accessPointName;

    private String address;

    private String city;

    private String postalCode;

   private List<StandardHours> standardHoursList;

   private String email;


    public String getAccessPointId() {
        return accessPointId;
    }

    public void setAccessPointId(String accessPointId) {
        this.accessPointId = accessPointId;
    }

    public String getAccessPointName() {
        return accessPointName;
    }

    public void setAccessPointName(String accessPointName) {
        this.accessPointName = accessPointName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public List<StandardHours> getStandardHoursList() {
        return standardHoursList;
    }

    public void setStandardHoursList(List<StandardHours> standardHoursList) {
        this.standardHoursList = standardHoursList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
