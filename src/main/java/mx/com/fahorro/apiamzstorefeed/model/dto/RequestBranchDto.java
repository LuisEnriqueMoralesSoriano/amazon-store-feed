package mx.com.fahorro.apiamzstorefeed.model.dto;

import java.io.Serializable;
import java.util.List;

public class RequestBranchDto implements Serializable {


    private String id;

    private String accessPointId;

    private String name;

    private String capacity;

    private String phoneNumber;

    private String active;

    private List<ScheduleDto> scheduleList;

    private List<ClosureExceptionDto> closureExceptionList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccessPointId() {
        return accessPointId;
    }

    public void setAccessPointId(String accessPointId) {
        this.accessPointId = accessPointId;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ScheduleDto> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<ScheduleDto> scheduleList) {
        this.scheduleList = scheduleList;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<ClosureExceptionDto> getClosureExceptionList() {
        return closureExceptionList;
    }

    public void setClosureExceptionList(List<ClosureExceptionDto> closureExceptionList) {
        this.closureExceptionList = closureExceptionList;
    }

    @Override
    public String toString() {
        return "feeds{" +
                "id='" + id + '\'' +
                ", accessPointId='" + accessPointId + '\'' +
                ", name='" + name + '\'' +
                ", active='" + active + '\'' +
                '}';
    }
}
