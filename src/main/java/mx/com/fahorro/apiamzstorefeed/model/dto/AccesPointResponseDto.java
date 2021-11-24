package mx.com.fahorro.apiamzstorefeed.model.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class AccesPointResponseDto implements Serializable {

    private ArrayList< AccespointDto > accessPoints = new ArrayList < AccespointDto > ();

    public ArrayList<AccespointDto> getAccessPoints() {
        return accessPoints;
    }

    public void setAccessPoints(ArrayList<AccespointDto> accessPoints) {
        this.accessPoints = accessPoints;
    }
}
