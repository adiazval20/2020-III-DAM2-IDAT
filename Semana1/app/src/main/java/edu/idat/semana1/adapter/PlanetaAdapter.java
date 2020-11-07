package edu.idat.semana1.adapter;

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

import edu.idat.semana1.R;
import edu.idat.semana1.entity.Planeta;

public class PlanetaAdapter extends ArrayAdapter<Planeta> {
    public PlanetaAdapter(@NonNull Context context, int resource, @NonNull List<Planeta> objects) {
        super(context, resource, objects);
    }

    // CTRL + O

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_planeta, parent, false);
        }

        TextView txtNombre = convertView.findViewById(R.id.txtNombre);
        ImageView imgPlaneta = convertView.findViewById(R.id.imgPlaneta);
        TextView txtDescripcion = convertView.findViewById(R.id.txtDescripcion);

        Planeta planeta = getItem(position);
        imgPlaneta.setImageResource(planeta.getImagenId());
        txtNombre.setText(planeta.getNombre());
        txtDescripcion.setText(planeta.getDescripcion());

        return convertView;
    }
}
