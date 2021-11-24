package mx.com.fahorro.apiamzstorefeed.model.dto;

import java.io.Serializable;

public class ProcessingDetailDto implements Serializable {

    private String indexNumber;

    private String accessPointId;

    private ErrorDto[] errors;

    private String resultStatus;

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public String getAccessPointId() {
        return accessPointId;
    }

    public void setAccessPointId(String accessPointId) {
        this.accessPointId = accessPointId;
    }

    public ErrorDto[] getErrors() {
        return errors;
    }

    public void setErrors(ErrorDto[] errors) {
        this.errors = errors;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }
}
