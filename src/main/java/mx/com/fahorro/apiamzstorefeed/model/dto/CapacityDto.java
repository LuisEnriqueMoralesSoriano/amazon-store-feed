package mx.com.fahorro.apiamzstorefeed.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CapacityDto implements Serializable {

    private int threshold;

    @JsonCreator
    public CapacityDto(@JsonProperty("treshold") int threshold) {
        this.threshold = threshold;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }


}
