package mx.com.fahorro.apiamzstorefeed.model;

import java.io.Serializable;

public class StandardHours implements Serializable {

    private String day;

    private String openingTime;

    private String closingTime;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }
}
