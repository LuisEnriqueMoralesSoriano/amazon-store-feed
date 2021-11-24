package mx.com.fahorro.apiamzstorefeed.model.dto;

import java.io.Serializable;

public class CommunicationDetailsDto implements Serializable {


    private String phoneNumber;

    private String emailId;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
