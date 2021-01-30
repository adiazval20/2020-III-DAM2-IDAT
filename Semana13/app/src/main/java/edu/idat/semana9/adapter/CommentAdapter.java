package edu.idat.semana9.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

import edu.idat.semana9.R;
import edu.idat.semana9.entity.Comment;
import edu.idat.semana9.entity.User;

public class CommentAdapter extends ArrayAdapter<Comment> {
    private TextView txtNombre, txtEmail, txtContenido;
    private ImageView imgFoto;

    public CommentAdapter(@NonNull Context context, int resource) {
        super(context, resource);
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
        imgFoto = convertView.findViewById(R.id.imgFoto);

        Comment comment = getItem(position);
        User user = comment.getUser();
        txtNombre.setText(String.format("%s %s", user.getFirstName(), user.getLastName()));
        txtEmail.setText(user.getEmail());
        txtContenido.setText(comment.getMessage());

        Picasso.get().load(user.getPicture()).into(imgFoto);

        return convertView;
    }

    public void loadData(List<Comment> comments) {
        clear();
        addAll(comments);
        notifyDataSetChanged();
    }
}
