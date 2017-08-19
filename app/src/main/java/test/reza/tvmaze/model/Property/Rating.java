package test.reza.tvmaze.model.Property;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

/**
 * Class to expose Rating property, retrieved  from TVMaze
 */

public class Rating implements Serializable{

    @JsonProperty("average")
    private float average;

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }


}
