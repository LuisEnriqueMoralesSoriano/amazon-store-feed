package mx.com.fahorro.apiamzstorefeed.model.dto;

import java.io.Serializable;

public class ResponseFeedDto  implements Serializable {

    private String feedId;

    private String clientId;

    private String sequenceNumber;

    private String status;

    private DocumentDto[] inputDocuments;

    private DocumentDto[] outputDocuments;

    private String createDate;

    public String getFeedId() {
        return feedId;
    }

    public void setFeedId(String feedId) {
        this.feedId = feedId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DocumentDto[] getInputDocuments() {
        return inputDocuments;
    }

    public void setInputDocuments(DocumentDto[] inputDocuments) {
        this.inputDocuments = inputDocuments;
    }

    public DocumentDto[] getOutputDocuments() {
        return outputDocuments;
    }

    public void setOutputDocuments(DocumentDto[] outputDocuments) {
        this.outputDocuments = outputDocuments;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
