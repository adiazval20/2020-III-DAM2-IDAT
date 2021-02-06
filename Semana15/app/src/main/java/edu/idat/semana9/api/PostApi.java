package edu.idat.semana9.api;

import java.util.List;

import edu.idat.semana9.entity.Post;
import edu.idat.semana9.entity.ResponseApi;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PostApi {
    @GET("post")
    Call<ResponseApi<List<Post>>> list();

    @GET("post/{id}")
    Call<ResponseApi<Post>> find(@Path("id") String id);
}