package edu.idat.semana5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import edu.idat.semana5.R;
import edu.idat.semana5.entity.Seccion;

public class SeccionAdapter extends ArrayAdapter<Seccion> {
    public SeccionAdapter(@NonNull Context context, int resource, @NonNull List<Seccion> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_seccion, parent, false);
        }

        Seccion seccion = getItem(position);

        ImageView imgSeccion = convertView.findViewById(R.id.imgSeccion);
        TextView txtNombre = convertView.findViewById(R.id.txtNombre);

        imgSeccion.setImageResource(seccion.getImagenId());
        txtNombre.setText(seccion.getNombre());

        return convertView;
    }
}
