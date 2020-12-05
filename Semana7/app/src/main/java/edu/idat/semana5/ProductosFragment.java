package edu.idat.semana5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.idat.semana5.adapter.ProductoAdapter;
import edu.idat.semana5.entity.Producto;

public class ProductosFragment extends Fragment {

    public ProductosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_productos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "Iphone", "Descripción de Iphone", 3000, R.drawable.iphone));
        productos.add(new Producto(2, "Samsung", "Descripción de samsung", 2500, R.drawable.samsung));
        productos.add(new Producto(3, "Xiaomi", "Descripción de xiaomi", 3000, R.drawable.xiaomi));

        RecyclerView rcvProductos = view.findViewById(R.id.rcvProductos);
        rcvProductos.setLayoutManager(new LinearLayoutManager(getContext()));

        ProductoAdapter adapter = new ProductoAdapter(productos);
        rcvProductos.setAdapter(adapter);
    }
}