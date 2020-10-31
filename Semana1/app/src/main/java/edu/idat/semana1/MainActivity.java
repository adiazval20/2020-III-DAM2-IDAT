package edu.idat.semana1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import edu.idat.semana1.adapter.PlanetaAdapter;
import edu.idat.semana1.entity.Planeta;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // CTRL + ALT + S -> spellcheck

        // 1. Obtengo la referencia de la vista SPINNER y la almaceno en una variable de java
        Spinner spPlanetas = findViewById(R.id.spPlanetas);

        // 2. Creo mi fuente de datos (Para este ejemplo una lista de objetos de java)
        List<String> planetas = new ArrayList<>();
        planetas.add("Mercurio");
        planetas.add("Venus");
        planetas.add("Tierra");
        planetas.add("Marte");
        planetas.add("Jupiter");
        planetas.add("Saturno");
        planetas.add("Urano");
        planetas.add("Neptuno");

        // 3. Creo mi adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planetas);

        // 4. Enlazo el adapter con la vista
        spPlanetas.setAdapter(adapter);

        // Cargando un spinner desde un archivo de recursos del proyecto
        // --------------------------------------------------------------
        Spinner spEstadoCivil = findViewById(R.id.spEstadoCivil);
        ArrayAdapter adapterFromR = ArrayAdapter.createFromResource(this, R.array.estadoCivil, android.R.layout.simple_list_item_1);
        spEstadoCivil.setAdapter(adapterFromR);

        // Cargando un GridView
        GridView grwPlanetas = findViewById(R.id.grwPlanetas);
//        grwPlanetas.setAdapter(adapter);

        List<Planeta> lstPlanetas = new ArrayList<>();
        lstPlanetas.add(new Planeta(1, "Mercurio", R.drawable.marte));
        lstPlanetas.add(new Planeta(2, "Venus", R.drawable.venus));
        lstPlanetas.add(new Planeta(3, "Tierra", R.drawable.tierra));

        PlanetaAdapter planetaAdapter = new PlanetaAdapter(this, R.layout.item_planeta, lstPlanetas);
        grwPlanetas.setAdapter(planetaAdapter);

    }
}












