package mx.com.fahorro.apiamzstorefeed.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AccespointDto implements Serializable {

    private String accessPointId;

    private String accessPointName;

    private Boolean isActive;

    private String timeZone;

    private String loginClaim;

    private CapacityDto capacity;

    private AddressDto address;

    private String terminationDate;

    private ArrayList<Object> capabilities = new ArrayList<Object>();

    private ArrayList<StandardHoursDto> standardHours = new ArrayList<StandardHoursDto>();

    private List<ClosureExceptionDto> closureExceptionList;

    private CommunicationDetailsDto communicationDetails;

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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getLoginClaim() {
        return loginClaim;
    }

    public void setLoginClaim(String loginClaim) {
        this.loginClaim = loginClaim;
    }

    public CapacityDto getCapacity() {
        return capacity;
    }

    public void setCapacity(CapacityDto capacity) {
        this.capacity = capacity;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public String getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(String terminationDate) {
        this.terminationDate = terminationDate;
    }

    public ArrayList<Object> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(ArrayList<Object> capabilities) {
        this.capabilities = capabilities;
    }

    public ArrayList<StandardHoursDto> getStandardHours() {
        return standardHours;
    }

    public void setStandardHours(ArrayList<StandardHoursDto> standardHours) {
        this.standardHours = standardHours;
    }

    public CommunicationDetailsDto getCommunicationDetails() {
        return communicationDetails;
    }

    public void setCommunicationDetails(CommunicationDetailsDto communicationDetails) {
        this.communicationDetails = communicationDetails;
    }

    public List<ClosureExceptionDto> getClosureExceptionList() {
        return closureExceptionList;
    }

    public void setClosureExceptionList(List<ClosureExceptionDto> closureExceptionList) {
        this.closureExceptionList = closureExceptionList;
    }
}




