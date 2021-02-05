package edu.idat.semana9.api;

import java.util.List;

import edu.idat.semana9.entity.Post;
import edu.idat.semana9.entity.ResponseListApi;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PostApi {
    @GET("post")
    Call<ResponseListApi<List<Post>>> list();

    @GET("post/{id}")
    Call<Post> find(@Path("id") String id);
}
