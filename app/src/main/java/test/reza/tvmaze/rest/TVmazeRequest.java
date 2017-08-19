package test.reza.tvmaze.rest;

import java.io.IOException;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import test.reza.tvmaze.model.Show;

/**
 * Class to implement make TVmaze Requests
 * on Services defined in TVmazeApi intenface
 */

public class TVmazeRequest {

    public static final String BASE_URL = "http://api.tvmaze.com";
    private static Retrofit retrofit = null;
    private TVmazeApi api;


    /**
     * Rertrofit and TVmazeApi Initialization in Constructor
     */
    public TVmazeRequest(){
        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();
        }

        api = retrofit.create(TVmazeApi.class);
    }


    /**
     * Method to make get all of shows existing in
     * TVmaze database It returns a list of shows ,
     * deserialization is done by Jackson
     */
    public List<Show> getAllShows(){

        Call<List<Show>> call = api.getAllShows();

        List<Show>  shows = null;

        try {
            shows = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return shows;
    }
}
