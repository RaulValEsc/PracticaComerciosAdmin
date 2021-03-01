package com.example.practicacomerciosadmin.vistas.Pedido;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.practicacomerciosadmin.R;
import com.example.practicacomerciosadmin.controladores.PedidoAdapter;
import com.example.practicacomerciosadmin.controladores.ProductoAdapter;
import com.example.practicacomerciosadmin.modelos.Pedido;
import com.example.practicacomerciosadmin.modelos.Producto;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class ActivityPedidos extends AppCompatActivity {

    public static String nombreusuario;

    RecyclerView rvProductos;
    ArrayList<Pedido> arrayPedidos;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        Bundle bundle = getIntent().getExtras();
        nombreusuario = bundle.getString("nombreusuario");
        arrayPedidos = new ArrayList<Pedido>();

        database= FirebaseDatabase.getInstance().getReference();

        rvProductos = findViewById(R.id.rvPedidos);

        cargarComercios();
    }

    private void cargarComercios() {
        database = FirebaseDatabase.getInstance().getReference();
        database.child("pedidos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                arrayPedidos.clear();
                rvProductos.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                rvProductos.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));
                rvProductos.setAdapter(new PedidoAdapter(arrayPedidos));
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    if(child.child("idUser").getValue().toString().equals(nombreusuario)) {
                        Pedido p = child.getValue(Pedido.class);
                        arrayPedidos.add(p);
                        rvProductos.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        rvProductos.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
                        rvProductos.setAdapter(new PedidoAdapter(arrayPedidos));
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }
}