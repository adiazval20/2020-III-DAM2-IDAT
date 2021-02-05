package edu.idat.semana9.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import edu.idat.semana9.R;
import edu.idat.semana9.entity.Producto;

public class ProductoViewHolder extends RecyclerView.ViewHolder {
    private ImageView imgProducto;
    private TextView txtNombre, txtPrecio, txtDescripcion;

    public ProductoViewHolder(@NonNull View itemView) {
        super(itemView);

        imgProducto = itemView.findViewById(R.id.imgProducto);
        txtNombre = itemView.findViewById(R.id.txtNombre);
        txtPrecio = itemView.findViewById(R.id.txtPrecio);
        txtDescripcion = itemView.findViewById(R.id.txtDescripcion);
    }

    public void loadData(Producto producto) {
        txtNombre.setText(producto.getNombre());
        txtPrecio.setText(String.format("S/%.2f", producto.getPrecio()));
        txtDescripcion.setText(producto.getDescripcion());

        Picasso.get().load(producto.getUrlImagen()).into(imgProducto);
    }
}
