package mx.com.fahorro.apiamzstorefeed.model.dto;

public class ResponseBranchListDto {

    private String feedId;

    private AccesPointResponseDto feeds;

    private String statusTransaction;

    private ResponseDocumentDto feedsResponse;

    public String getFeedId() {
        return feedId;
    }

    public void setFeedId(String feedId) {
        this.feedId = feedId;
    }

    public AccesPointResponseDto getFeeds() {
        return feeds;
    }

    public void setFeeds(AccesPointResponseDto feeds) {
        this.feeds = feeds;
    }

    public ResponseDocumentDto getFeedsResponse() {
        return feedsResponse;
    }

    public void setFeedsResponse(ResponseDocumentDto feedsResponse) {
        this.feedsResponse = feedsResponse;
    }

    public String getStatusTransaction() {
        return statusTransaction;
    }

    public void setStatusTransaction(String statusTransaction) {
        this.statusTransaction = statusTransaction;
    }
}
