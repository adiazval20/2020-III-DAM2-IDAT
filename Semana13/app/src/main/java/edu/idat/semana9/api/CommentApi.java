package edu.idat.semana9.api;

import java.util.List;

import edu.idat.semana9.entity.Comment;
import edu.idat.semana9.entity.ResponseListApi;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CommentApi {
    @GET("post/{postId}/comment")
    Call<ResponseListApi<List<Comment>>> listByPostId(@Path("postId") String postId);
}
