package edu.idat.semana9.entity;

import com.google.gson.annotations.SerializedName;

public class Comment {
    private String id;
    private String message;

    @SerializedName("owner")
    private User user;

    private long postId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }
}
