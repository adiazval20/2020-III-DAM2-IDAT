package edu.idat.semana5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import edu.idat.semana5.adapter.SeccionAdapter;
import edu.idat.semana5.entity.Seccion;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bvnSecciones = findViewById(R.id.bnvSecciones);
        bvnSecciones.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                loadFragment(item.getItemId());
                return true;
            }
        });

        loadFragment(R.id.optInicio);
    }

    private void loadFragment(int id) {
        Fragment fragment = new Fragment();

        switch (id) {
            case R.id.optInicio:
                fragment = new InicioFragment();
                break;
            case R.id.optProductos:
                fragment = new ProductosFragment();
                break;
            case R.id.optContacto:
                fragment = new MapaFragment();
                break;
            case R.id.optConfiguracion:
                fragment = new ConfiguracionFragment();
                break;
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.frmContenedor, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}