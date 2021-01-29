package edu.idat.semana9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.squareup.picasso.Picasso;

import java.util.List;

import edu.idat.semana9.adapter.CommentAdapter;
import edu.idat.semana9.api.CommentApi;
import edu.idat.semana9.api.PhotoApi;
import edu.idat.semana9.api.PostApi;
import edu.idat.semana9.config.RetrofitConfig;
import edu.idat.semana9.entity.Comment;
import edu.idat.semana9.entity.Photo;
import edu.idat.semana9.entity.Post;
import edu.idat.semana9.viewmodel.MainViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private MainViewModel viewModel;
    private MaterialButton btnMostrar;
    private ImageView imgFoto;
    private EditText edtPostId;
    private TextView txtTitulo, txtContenido;
    private ListView lsvComentarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PostApi postApi = RetrofitConfig.getPostApi();
        PhotoApi photoApi = RetrofitConfig.getPhotoApi();
        CommentApi commentApi = RetrofitConfig.getCommentApi();

        imgFoto = findViewById(R.id.imgFoto);
        btnMostrar = findViewById(R.id.btnMostrar);
        edtPostId = findViewById(R.id.edtPostId);
        txtTitulo = findViewById(R.id.txtTitulo);
        txtContenido = findViewById(R.id.txtContenido);
        lsvComentarios = findViewById(R.id.lsvComentarios);

        CommentAdapter adapter = new CommentAdapter(this, R.layout.item_comment);
        lsvComentarios.setAdapter(adapter);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long postId = Long.parseLong(edtPostId.getText().toString());

                postApi.find(postId).enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        Post post = response.body();
                        txtTitulo.setText(post.getTitle());
                        txtContenido.setText(post.getBody());
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {

                    }
                });

                photoApi.find(postId).enqueue(new Callback<Photo>() {
                    @Override
                    public void onResponse(Call<Photo> call, Response<Photo> response) {
                        Photo photo = response.body();
                        Picasso.get().load(photo.getUrl()).into(imgFoto);
                    }

                    @Override
                    public void onFailure(Call<Photo> call, Throwable t) {

                    }
                });

                commentApi.listByPostId(postId).enqueue(new Callback<List<Comment>>() {
                    @Override
                    public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                        List<Comment> comments = response.body();
                        adapter.loadData(comments);
                    }

                    @Override
                    public void onFailure(Call<List<Comment>> call, Throwable t) {

                    }
                });
            }
        });

    }
}