package edu.idat.semana9.api;

import java.util.List;

import edu.idat.semana9.entity.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PostApi {
    @GET("/posts")
    Call<List<Post>> list();

    @GET("/posts/{id}")
    Call<Post> find(@Path("id") long id);
}
