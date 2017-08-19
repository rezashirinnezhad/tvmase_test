package test.reza.tvmaze.rest;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import test.reza.tvmaze.model.Show;

/**
 * Created by Reza on 8/17/2017.
 */

public interface TVmazeApi {

    /**
     *
     * Method to
     */

    @GET("/shows")
    Call<List<Show>> getAllShows();

}
