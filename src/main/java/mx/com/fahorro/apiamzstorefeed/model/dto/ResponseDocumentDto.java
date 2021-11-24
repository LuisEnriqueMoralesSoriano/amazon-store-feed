package mx.com.fahorro.apiamzstorefeed.model.dto;

import java.io.Serializable;
import java.util.List;

public class ResponseDocumentDto implements Serializable {

    private String feedId;

    private String noOfAccessPointsProcessed;

    private String noOfAccessPointsSuccessfullyProcessed;

    private String noOfAccessPointsFailedToProcess;

    private ProcessingDetailDto[] failedAccessPointProcessingDetails;

    public String getFeedId() {
        return feedId;
    }

    public void setFeedId(String feedId) {
        this.feedId = feedId;
    }

    public String getNoOfAccessPointsProcessed() {
        return noOfAccessPointsProcessed;
    }

    public void setNoOfAccessPointsProcessed(String noOfAccessPointsProcessed) {
        this.noOfAccessPointsProcessed = noOfAccessPointsProcessed;
    }

    public String getNoOfAccessPointsSuccessfullyProcessed() {
        return noOfAccessPointsSuccessfullyProcessed;
    }

    public void setNoOfAccessPointsSuccessfullyProcessed(String noOfAccessPointsSuccessfullyProcessed) {
        this.noOfAccessPointsSuccessfullyProcessed = noOfAccessPointsSuccessfullyProcessed;
    }

    public String getNoOfAccessPointsFailedToProcess() {
        return noOfAccessPointsFailedToProcess;
    }

    public void setNoOfAccessPointsFailedToProcess(String noOfAccessPointsFailedToProcess) {
        this.noOfAccessPointsFailedToProcess = noOfAccessPointsFailedToProcess;
    }

    public ProcessingDetailDto[] getFailedAccessPointProcessingDetails() {
        return failedAccessPointProcessingDetails;
    }

    public void setFailedAccessPointProcessingDetails(ProcessingDetailDto[] failedAccessPointProcessingDetails) {
        this.failedAccessPointProcessingDetails = failedAccessPointProcessingDetails;
    }


}
