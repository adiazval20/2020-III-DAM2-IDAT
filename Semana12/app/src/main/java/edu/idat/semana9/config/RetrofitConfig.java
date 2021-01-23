package edu.idat.semana9.config;

import edu.idat.semana9.api.PhotoApi;
import edu.idat.semana9.api.PostApi;
import edu.idat.semana9.entity.Photo;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    private static Retrofit client;
    private static PostApi postApi;
    private static PhotoApi photoApi;

    static {
        String baseUrl = "https://jsonplaceholder.typicode.com/";
        client = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getLogginBuilder().build())
                .build();
    }

    private static OkHttpClient.Builder getLogginBuilder() {
        HttpLoggingInterceptor loggin = new HttpLoggingInterceptor();
        loggin.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(loggin);

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
}
