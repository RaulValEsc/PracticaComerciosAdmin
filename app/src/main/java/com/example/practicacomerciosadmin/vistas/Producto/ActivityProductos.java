package com.example.practicacomerciosadmin.vistas.Producto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.practicacomerciosadmin.R;
import com.example.practicacomerciosadmin.controladores.ProductoAdapter;
import com.example.practicacomerciosadmin.modelos.Producto;
import com.example.practicacomerciosadmin.vistas.Comercio.VistaComercio;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;

public class ActivityProductos extends AppCompatActivity {

    String nombreComercio;

    FloatingActionButton fButton;
    RecyclerView rvProductos;
    ArrayList<Producto> arrayProductos;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        Bundle bundle = getIntent().getExtras();
        nombreComercio = bundle.getString("comercio");

        arrayProductos = new ArrayList<Producto>();

        database= FirebaseDatabase.getInstance().getReference();

        fButton = findViewById(R.id.fbAñadirProducto);
        rvProductos = findViewById(R.id.recyclerViewProductos);

        cargarComercios();

        setup();
    }

    private void setup() {
        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), CrearProducto.class);
                startActivity(intent);
            }
        });
    }

    private void cargarComercios() {
        database = FirebaseDatabase.getInstance().getReference();
        database.child("productos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                arrayProductos.clear();
                rvProductos.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                rvProductos.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));
                rvProductos.setAdapter(new ProductoAdapter(arrayProductos));
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    if(child.child("idComercio").getValue().toString().equals(VistaComercio.nombrecomercio)) {
                        Producto p = child.getValue(Producto.class);
                        arrayProductos.add(p);
                        rvProductos.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        rvProductos.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
                        rvProductos.setAdapter(new ProductoAdapter(arrayProductos));
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }
}