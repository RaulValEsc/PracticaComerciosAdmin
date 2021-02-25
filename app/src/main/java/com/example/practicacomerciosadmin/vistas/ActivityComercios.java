package com.example.practicacomerciosadmin.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.practicacomerciosadmin.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ActivityComercios extends AppCompatActivity {

    FloatingActionButton fButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comercios);

        fButton = findViewById(R.id.fbAñadir);

        setup();
    }

    private void setup() {
        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),CrearComercio.class);
                startActivity(intent);
            }
        });
    }
}