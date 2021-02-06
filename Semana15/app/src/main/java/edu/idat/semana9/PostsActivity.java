package edu.idat.semana9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import edu.idat.semana9.adapter.PostAdapter;
import edu.idat.semana9.api.PostApi;
import edu.idat.semana9.config.RetrofitConfig;
import edu.idat.semana9.entity.Post;
import edu.idat.semana9.entity.ResponseApi;
import edu.idat.semana9.viewmodel.PostsViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsActivity extends AppCompatActivity {
    private RecyclerView rcvPosts;
    private PostAdapter postAdapter;
    private PostsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        viewModel = new ViewModelProvider(this).get(PostsViewModel.class);

        rcvPosts = findViewById(R.id.rcvPosts);
        rcvPosts.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        postAdapter = new PostAdapter();
        rcvPosts.setAdapter(postAdapter);

        viewModel.listPosts().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                postAdapter.loadData(posts);
            }
        });
    }
}