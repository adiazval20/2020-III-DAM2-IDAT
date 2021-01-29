package edu.idat.semana9.adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import edu.idat.semana9.R;
import edu.idat.semana9.api.CommentApi;
import edu.idat.semana9.api.PhotoApi;
import edu.idat.semana9.config.RetrofitConfig;
import edu.idat.semana9.entity.Photo;
import edu.idat.semana9.entity.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewHolder extends RecyclerView.ViewHolder {
    private ImageView imgFoto;
    private PhotoApi photoApi;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        imgFoto = itemView.findViewById(R.id.imgFoto);
        photoApi = RetrofitConfig.getPhotoApi();
    }

    public void loadData(Post post) {
        photoApi.find(post.getId()).enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {
                Photo photo = response.body();
                Picasso.get().load(photo.getUrl()).into(imgFoto);
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {

            }
        });
    }
}
