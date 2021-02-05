package edu.idat.semana9.config;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import edu.idat.semana9.api.CommentApi;
import edu.idat.semana9.api.PhotoApi;
import edu.idat.semana9.api.PostApi;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    private static Retrofit client;
    private static PostApi postApi;
    private static PhotoApi photoApi;
    private static CommentApi commentApi;

    static {
        String baseUrl = "https://dummyapi.io/data/api/";
        client = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClientBuilder().build())
                .build();
    }

    private static OkHttpClient.Builder getClientBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        HttpLoggingInterceptor loggin = new HttpLoggingInterceptor();
        loggin.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggin);

        builder.addInterceptor(new Interceptor() {
            @NotNull
            @Override
            public Response intercept(@NotNull Chain chain) throws IOException {
                Request auth = chain.request().newBuilder()
                        .addHeader("app-id", "6014597c989c2242753fe082")
                        .build();
                return chain.proceed(auth);
            }
        });

        return builder;
    }

    public static PostApi getPostApi() {
        if (postApi == null) {
            postApi = client.create(PostApi.class);
        }
        return postApi;
    }

    public static PhotoApi getPhotoApi() {
        if (photoApi == null) {
            photoApi = client.create(PhotoApi.class);
        }
        return photoApi;
    }

    public static CommentApi getCommentApi() {
        if (commentApi == null) {
            commentApi = client.create(CommentApi.class);
        }
        return commentApi;
    }
}
