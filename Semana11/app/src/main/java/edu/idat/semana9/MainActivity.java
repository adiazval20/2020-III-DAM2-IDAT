package edu.idat.semana9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import edu.idat.semana9.adapter.ProductoAdapter;
import edu.idat.semana9.api.PostApi;
import edu.idat.semana9.config.RetrofitConfig;
import edu.idat.semana9.entity.Post;
import edu.idat.semana9.entity.Producto;
import edu.idat.semana9.viewmodel.MainViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rcvProductos = findViewById(R.id.rcvProductos);
        rcvProductos.setLayoutManager(new LinearLayoutManager(this));
        ProductoAdapter adapter = new ProductoAdapter();
        rcvProductos.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.listProductos().observe(this, new Observer<List<Producto>>() {
            @Override
            public void onChanged(List<Producto> productos) {
                adapter.updateData(productos);
            }
        });

        PostApi postApi = RetrofitConfig.getPostApi();
//        postApi.list().enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//                List<Post> posts = response.body();
//                Toast.makeText(MainActivity.this, String.valueOf(posts.size()), Toast.LENGTH_LONG).show();
//            }
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//            }
//        });

        long postId = 2;
        postApi.find(postId).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post post = response.body();
                Toast.makeText(MainActivity.this, post.getTitle(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }
}