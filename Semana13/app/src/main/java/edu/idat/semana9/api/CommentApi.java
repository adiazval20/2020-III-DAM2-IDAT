package edu.idat.semana9.api;

import java.util.List;

import edu.idat.semana9.entity.Comment;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CommentApi {
    @GET("/posts/{postId}/comments")
    Call<List<Comment>> listByPostId(@Path("postId") long postId);
}
