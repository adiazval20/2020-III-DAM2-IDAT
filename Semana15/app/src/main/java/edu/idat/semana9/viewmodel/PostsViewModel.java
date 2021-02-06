package edu.idat.semana9.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.idat.semana9.entity.Post;
import edu.idat.semana9.repository.PostRepository;

public class PostsViewModel extends AndroidViewModel {
    private PostRepository postRepo;

    public PostsViewModel(@NonNull Application application) {
        super(application);
        postRepo = new PostRepository(application);
    }

    public LiveData<List<Post>> listPosts() {
        return postRepo.list();
    }
}
