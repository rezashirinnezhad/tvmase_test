package test.reza.tvmaze.rest;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import test.reza.tvmaze.model.Show;

/**
 * Interface that should be created to use Retrofit
 */
public interface TVmazeApi {

    /**
     * Method to get Shows from specified url
     */
    @GET("/shows")
    Call<List<Show>> getAllShows();
}
