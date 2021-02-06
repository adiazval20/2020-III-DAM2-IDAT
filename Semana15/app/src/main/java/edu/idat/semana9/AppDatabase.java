package edu.idat.semana9;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import edu.idat.semana9.dao.PostDao;
import edu.idat.semana9.dao.ProductoDao;
import edu.idat.semana9.entity.Post;
import edu.idat.semana9.entity.Producto;

@Database(entities = {Producto.class, Post.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase DB;
    private static final int HILOS = 4;
    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(HILOS);

    public abstract ProductoDao productoDao();

    public abstract PostDao postDao();

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
                    productoDao.insert(new Producto("Iphone", "Descripción de Iphone", 3500, "https://www.apple.com/newsroom/images/product/iphone/standard/Apple_announce-iphone12pro_10132020.jpg.og.jpg?202012212048"));
                    productoDao.insert(new Producto("Samsung Galaxy", "Descripción de Samsung Galaxy", 2500, "https://d500.epimg.net/cincodias/imagenes/2020/09/02/smartphones/1599028334_859258_1599028423_sumario_normal.jpg"));
                    productoDao.insert(new Producto("Alcatel", "Descripción de Alcatel", 500, "https://http2.mlstatic.com/celular-alcatel-1v-16gb-2gb-android-pie-garantia-oficial-pce-D_Q_NP_951031-MLA41694789763_052020-F.webp"));
                }
            });
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            dbExecutor.execute(new Runnable() {
                @Override
                public void run() {
                }
            });
        }
    };
}
