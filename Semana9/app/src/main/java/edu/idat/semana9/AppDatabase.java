package edu.idat.semana9;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase DB;
    private static final int HILOS = 4;
    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(HILOS);

    public static AppDatabase getDatabase(Context context) {
        if (DB == null) {
            synchronized (AppDatabase.class) {
                if (DB == null) {
                    DB = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "DAM2")
                            .build();
                }
            }
        }
        return DB;
    }
}
