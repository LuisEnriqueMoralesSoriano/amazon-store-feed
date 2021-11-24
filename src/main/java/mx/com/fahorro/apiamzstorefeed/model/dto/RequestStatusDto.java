package mx.com.fahorro.apiamzstorefeed.model.dto;

import java.io.Serializable;

public class RequestStatusDto implements Serializable {

    private String feedId;

    public String getFeedId() {
        return feedId;
    }

    public void setFeedId(String feedId) {
        this.feedId = feedId;
    }
}
