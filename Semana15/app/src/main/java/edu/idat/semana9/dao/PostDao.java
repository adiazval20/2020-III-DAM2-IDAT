package edu.idat.semana9.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.idat.semana9.entity.Post;

@Dao
public interface PostDao {
    @Query("SELECT * FROM Post")
    LiveData<List<Post>> list();

    @Insert
    void insert(Post post);

    @Insert
    void insertAll(Post... posts);

    @Update
    void update(Post post);

    @Delete
    void delete(Post post);

    @Query("DELETE FROM Post")
    void clear();
}
