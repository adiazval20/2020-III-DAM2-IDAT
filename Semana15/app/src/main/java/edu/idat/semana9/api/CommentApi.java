package edu.idat.semana9.api;

import java.util.List;

import edu.idat.semana9.entity.Comment;
import edu.idat.semana9.entity.ResponseApi;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CommentApi {
    @GET("post/{postId}/comment")
    Call<ResponseApi<List<Comment>>> listByPostId(@Path("postId") String postId);
}