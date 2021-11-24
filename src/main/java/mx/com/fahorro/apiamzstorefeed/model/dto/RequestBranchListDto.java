package mx.com.fahorro.apiamzstorefeed.model.dto;

import java.io.Serializable;
import java.util.List;

public class RequestBranchListDto implements Serializable {

    private List<RequestBranchDto> feeds;

    public List<RequestBranchDto> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<RequestBranchDto> feeds) {
        this.feeds = feeds;
    }
}
