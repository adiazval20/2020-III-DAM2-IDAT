package edu.idat.semana9;

import androidx.room.Database;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {}, version = 1)
public abstract class AppDatabase {
    private static volatile AppDatabase DB;
    private static final int HILOS = 4;
    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(HILOS);
}
