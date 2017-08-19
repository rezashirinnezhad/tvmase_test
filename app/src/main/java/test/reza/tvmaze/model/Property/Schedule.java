package test.reza.tvmaze.model.Property;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;

/**
 * Class to expose Schedule property , retrieved  from TVMaze
 */

public class Schedule implements Serializable{

    @JsonProperty("time")
    private String time;

    @JsonProperty("days")
    private List<String> days;


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

}
