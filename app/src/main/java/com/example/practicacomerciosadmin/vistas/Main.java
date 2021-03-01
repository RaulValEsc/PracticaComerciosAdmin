package com.example.practicacomerciosadmin.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.practicacomerciosadmin.R;
import com.example.practicacomerciosadmin.vistas.Comercio.ActivityComercios;
import com.example.practicacomerciosadmin.vistas.Usuario.ActivityUsuarios;

public class Main extends AppCompatActivity {

    Button bComercio, bUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bComercio= findViewById(R.id.bComercio);
        bUsuario= findViewById(R.id.bUsuario);

        setup();
    }

    private void setup() {
        bComercio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityComercios.class);
                startActivity(intent);
            }
        });

        bUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityUsuarios.class);
                startActivity(intent);
            }
        });
    }
}