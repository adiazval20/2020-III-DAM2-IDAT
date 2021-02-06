package edu.idat.semana9.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.idat.semana9.AppDatabase;
import edu.idat.semana9.api.PostApi;
import edu.idat.semana9.config.RetrofitConfig;
import edu.idat.semana9.dao.PostDao;
import edu.idat.semana9.entity.Post;
import edu.idat.semana9.entity.ResponseApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {
    private PostDao dao;
    private PostApi api;
    private boolean flagCalling;

    public PostRepository(Application application) {
        dao = AppDatabase.getDatabase(application).postDao();
        api = RetrofitConfig.getPostApi();
        flagCalling = false;
    }

    public LiveData<List<Post>> list() {
        if (!flagCalling) {
            listApi();
        }
        return dao.list();
    }

    private void listApi() {
        flagCalling = true;

        api.list().enqueue(new Callback<ResponseApi<List<Post>>>() {
            @Override
            public void onResponse(Call<ResponseApi<List<Post>>> call, Response<ResponseApi<List<Post>>> response) {
                List<Post> posts = response.body().getData();
                AppDatabase.dbExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        dao.clear();
                        for (Post post : posts) {
                            dao.insert(post);
                        }
                        flagCalling = false;
                    }
                });
            }

            @Override
            public void onFailure(Call<ResponseApi<List<Post>>> call, Throwable t) {
                flagCalling = false;
            }
        });
    }

    public LiveData<Post> create(Post post) {
        if (!flagCalling) {
            createApi(post);
        }
        return dao.find(post.getId());
    }

    private void createApi(Post post) {
        flagCalling = true;

        api.create(post).enqueue(new Callback<ResponseApi<Post>>() {
            @Override
            public void onResponse(Call<ResponseApi<Post>> call, Response<ResponseApi<Post>> response) {
                Post resPost = response.body().getData();

                AppDatabase.dbExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        dao.delete(resPost);
                        dao.insert(resPost);
                        flagCalling = false;
                    }
                });
            }

            @Override
            public void onFailure(Call<ResponseApi<Post>> call, Throwable t) {
                flagCalling = false;
            }
        });
    }
}
