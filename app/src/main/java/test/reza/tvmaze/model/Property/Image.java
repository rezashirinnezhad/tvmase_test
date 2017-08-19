package test.reza.tvmaze.model.Property;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

/**
 * Class to expose Image property, retrieved  from TVMaze
 */

public class Image implements Serializable{

    @JsonProperty("medium")
    private String medium;

    @JsonProperty("original")
    private String original;


    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }


}
