package edu.idat.semana5.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;
import edu.idat.semana5.R;
import edu.idat.semana5.entity.Producto;

public class ProductoViewHolder extends RecyclerView.ViewHolder {
    private CircleImageView imgMiniatura;
    private ImageView imgProducto;
    private TextView txtNombre, txtPrecio, txtDescripcion;

    public ProductoViewHolder(@NonNull View itemView) {
        super(itemView);

        imgMiniatura = itemView.findViewById(R.id.imgMiniatura);
        txtNombre = itemView.findViewById(R.id.txtNombre);
        txtPrecio = itemView.findViewById(R.id.txtPrecio);
        imgProducto = itemView.findViewById(R.id.imgProducto);
        txtDescripcion = itemView.findViewById(R.id.txtDescripcion);
    }

    public void loadData(Producto producto) {
        imgMiniatura.setImageResource(producto.getImagenId());
        txtNombre.setText(producto.getNombre());
        txtPrecio.setText(String.format("Precio: S/%.2f", producto.getPrecio()));
        imgProducto.setImageResource(producto.getImagenId());
        txtDescripcion.setText(producto.getDecscripcion());
    }
}
