package edu.idat.semana9;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import edu.idat.semana9.dao.ProductoDao;
import edu.idat.semana9.entity.Producto;

@Database(entities = {Producto.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase DB;
    private static final int HILOS = 4;
    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(HILOS);

    public abstract ProductoDao productoDao();

    public static AppDatabase getDatabase(Context context) {
        if (DB == null) {
            synchronized (AppDatabase.class) {
                if (DB == null) {
                    DB = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "DAM2")
                            .addCallback(initCallback)
                            .build();
                }
            }
        }
        return DB;
    }

    private static Callback initCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            dbExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    ProductoDao productoDao = DB.productoDao();
                    productoDao.insert(new Producto("Iphone", "Descripción de Iphone", 3500, ""));
                    productoDao.insert(new Producto("Samsung Galaxy", "Descripción de Samsung Galaxy", 2500, ""));
                }
            });
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };
}
