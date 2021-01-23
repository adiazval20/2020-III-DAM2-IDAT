package edu.idat.semana9.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import edu.idat.semana9.R;
import edu.idat.semana9.entity.Comment;

public class CommentAdapter extends ArrayAdapter<Comment> {
    private TextView txtNombre, txtEmail, txtContenido;

    public CommentAdapter(@NonNull Context context, int resource, @NonNull List<Comment> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_comment, parent, false);
        }

        txtNombre = convertView.findViewById(R.id.txtNombre);
        txtEmail = convertView.findViewById(R.id.txtEmail);
        txtContenido = convertView.findViewById(R.id.txtContenido);

        Comment comment = getItem(position);
        txtNombre.setText(comment.getName());
        txtEmail.setText(comment.getEmail());
        txtContenido.setText(comment.getBody());

        return convertView;
    }
}
