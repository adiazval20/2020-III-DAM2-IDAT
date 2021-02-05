package edu.idat.semana9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import edu.idat.semana9.adapter.PostAdapter;
import edu.idat.semana9.api.PostApi;
import edu.idat.semana9.config.RetrofitConfig;
import edu.idat.semana9.entity.Post;
import edu.idat.semana9.entity.ResponseListApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsActivity extends AppCompatActivity {
    private RecyclerView rcvPosts;
    private PostAdapter postAdapter;
    private PostApi postApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        rcvPosts = findViewById(R.id.rcvPosts);
        rcvPosts.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        postAdapter = new PostAdapter();
        rcvPosts.setAdapter(postAdapter);

        postApi = RetrofitConfig.getPostApi();
        postApi.list().enqueue(new Callback<ResponseListApi<List<Post>>>() {
            @Override
            public void onResponse(Call<ResponseListApi<List<Post>>> call, Response<ResponseListApi<List<Post>>> response) {
                List<Post> posts = response.body().getData();
                postAdapter.loadData(posts);
            }

            @Override
            public void onFailure(Call<ResponseListApi<List<Post>>> call, Throwable t) {
                Toast.makeText(PostsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}