package edu.idat.semana5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.idat.semana5.adapter.SeccionAdapter;
import edu.idat.semana5.entity.Seccion;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Seccion> secciones = new ArrayList<>();
        secciones.add(new Seccion(1, "Inicio", R.drawable.ic_baseline_home_24));
        secciones.add(new Seccion(2, "Mapa", R.drawable.ic_baseline_location_on_24));
        secciones.add(new Seccion(3, "Configuración", R.drawable.ic_baseline_settings_24));

        GridView grvSecciones = findViewById(R.id.grvSecciones);

        SeccionAdapter adapter = new SeccionAdapter(this, R.layout.item_seccion, secciones);
        grvSecciones.setAdapter(adapter);

        grvSecciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment fragment = new Fragment();

                switch (i) {
                    case 0:
                        fragment = new InicioFragment();
                        break;
                    case 1:
                        fragment = new MapaFragment();
                        break;
                    case 2:
                        fragment = new ConfiguracionFragment();
                        break;
                }

                transaction.replace(R.id.frmContenedor, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}