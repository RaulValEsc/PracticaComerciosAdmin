package com.example.practicacomerciosadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practicacomerciosadmin.vistas.Main;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText email,pass;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        login = findViewById(R.id.login);

        setup();
    }

    private void setup() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().isEmpty() && pass.getText().toString().isEmpty()){

                    Toast.makeText(getApplicationContext(),"Rellena los campos para iniciar sesión", Toast.LENGTH_LONG).show();

                } else {

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email.getText().toString(),pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){

                                Intent intent = new Intent(getApplicationContext(), Main.class);
                                startActivity(intent);

                                Toast.makeText(getApplicationContext(),"Conectado correctamente.", Toast.LENGTH_LONG).show();

                            } else {

                                Toast.makeText(getApplicationContext(),"Error al iniciar sesión", Toast.LENGTH_LONG).show();
                                email.setText("");
                                pass.setText("");

                            }

                        }
                    });



                }
            }
        });
    }
}