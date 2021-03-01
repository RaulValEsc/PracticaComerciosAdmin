package com.example.practicacomerciosadmin.controladores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.practicacomerciosadmin.R;
import com.example.practicacomerciosadmin.modelos.Comercio;
import com.example.practicacomerciosadmin.vistas.Comercio.VistaComercio;

import java.util.ArrayList;

public class ComercioAdapter extends RecyclerView.Adapter<ComercioAdapter.ComercioViewHolder> implements View.OnClickListener{

    Context c;
    ArrayList<Comercio> listaComercios;

    public ComercioAdapter(ArrayList<Comercio> listaComercios) {
        this.listaComercios = listaComercios;
    }

    @NonNull
    @Override
    public ComercioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comercio,null,false);
        return new ComercioViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ComercioViewHolder holder, int position) {

        holder.asignarDatos(listaComercios.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, VistaComercio.class);
                intent.putExtra("nombre_comercio",holder.nombre.getText().toString());
                intent.putExtra("descripcion",holder.descripcion.getText().toString());
                c.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaComercios.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class ComercioViewHolder extends RecyclerView.ViewHolder {

        TextView nombre,descripcion;
        ImageView ivItemComercio;

        public ComercioViewHolder(@NonNull View itemView) {
            super(itemView);
            c = itemView.getContext();

            ivItemComercio=itemView.findViewById(R.id.ivItemComercio);
            descripcion=itemView.findViewById(R.id.tvDescripcion);
            nombre=itemView.findViewById(R.id.tvNombre);
        }

        public void asignarDatos(Comercio comercio) {

            Glide.with(itemView.getContext()).load(comercio.getImageUri()).into(ivItemComercio);

            descripcion.setText(comercio.getDescripcion());
            nombre.setText(comercio.getNombre());

        }
    }
}
