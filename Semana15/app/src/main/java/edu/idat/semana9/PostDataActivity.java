package edu.idat.semana9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.idat.semana9.adapter.PostAdapter;
import edu.idat.semana9.entity.Post;
import edu.idat.semana9.viewmodel.PostsViewModel;

public class PostDataActivity extends AppCompatActivity {
    private PostsViewModel viewModel;
    private EditText edtText, edtImage, edtLink;
    private Button btnCancelar, btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_data);

        viewModel = new ViewModelProvider(this).get(PostsViewModel.class);

        edtText = findViewById(R.id.edtText);
        edtImage = findViewById(R.id.edtImage);
        edtLink = findViewById(R.id.edtLink);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Post post = new Post();
                post.setText(edtText.getText().toString().trim());
                post.setImage(edtImage.getText().toString().trim());
                post.setLink(edtLink.getText().toString().trim());

                viewModel.createPost(post).observe(PostDataActivity.this, new Observer<Post>() {
                    @Override
                    public void onChanged(Post post) {
                        finish();
                    }
                });
            }
        });
    }
}