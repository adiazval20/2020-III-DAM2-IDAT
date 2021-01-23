package edu.idat.semana9.api;

import edu.idat.semana9.entity.Photo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PhotoApi {
    @GET("/photos/{id}")
    Call<Photo> find(@Path("id") long id);
}
