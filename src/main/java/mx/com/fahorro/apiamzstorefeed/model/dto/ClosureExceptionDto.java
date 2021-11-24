package mx.com.fahorro.apiamzstorefeed.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ClosureExceptionDto implements Serializable {

    @JsonFormat(pattern = "yyyy-mm-dd", locale = "es-MX", timezone = "America/Mexico_City")
    private Date startDateTime;

    @JsonFormat(pattern = "yyyy-mm-dd", locale = "es-MX", timezone = "America/Mexico_City")
    private Date endDateTime;

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }
}
