package com.example.practicacomerciosadmin.vistas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practicacomerciosadmin.R;
import com.example.practicacomerciosadmin.modelos.Comercio;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class CrearComercio extends AppCompatActivity {
    private EditText nombreComercio;
    private Button crear;
    private boolean comercioexiste = false;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_comercio);

        crear = findViewById(R.id.crear);
        nombreComercio = findViewById(R.id.nombreComercio);

        database = FirebaseDatabase.getInstance().getReference();

        setup();
    }

    private void setup() {
        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.child("comercios");
                Query query = database.orderByKey();
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot child : dataSnapshot.getChildren()) {
                            if (nombreComercio.getText().toString().equals(child.child("nombre").getValue().toString())) {
                                comercioexiste=true;
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }

                });
                if (comercioexiste==false){
                    crearComercio();
                }else{
                    Toast.makeText(getApplicationContext(),"Este comercio ya está registrado",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void crearComercio(){
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Comercio c = new Comercio(nombreComercio.getText().toString());
                database.child("comercios").push().setValue(c);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}