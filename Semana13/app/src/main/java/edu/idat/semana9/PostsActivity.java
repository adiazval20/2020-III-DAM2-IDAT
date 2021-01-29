package edu.idat.semana9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import edu.idat.semana9.adapter.PostAdapter;
import edu.idat.semana9.api.PostApi;
import edu.idat.semana9.config.RetrofitConfig;
import edu.idat.semana9.entity.Post;
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
        rcvPosts.setLayoutManager(new GridLayoutManager(this, 3));
        postAdapter = new PostAdapter();
        rcvPosts.setAdapter(postAdapter);

        postApi = RetrofitConfig.getPostApi();
        postApi.list().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> posts = response.body();
                postAdapter.loadData(posts);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }
}