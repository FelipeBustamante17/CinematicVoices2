package com.santotomas.cinematicvoices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.santotomas.cinematicvoices.InicioActivity;
import com.santotomas.cinematicvoices.R;

public class MainActivity extends AppCompatActivity {
    Button btn_registrarse;
    Button btn_login;
    Button btn_visitante;

    TextView text;

    EditText email, password;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        btn_visitante = findViewById(R.id.btn_visitante);
        email = findViewById(R.id.txt_correoInicio);
        password = findViewById(R.id.txt_passInicio);
        btn_login = findViewById(R.id.btn_inicioSesion);
        text = findViewById(R.id.txt_registrar);

        btn_visitante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginVisitante();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailUser = email.getText().toString().trim();
                String passUser = password.getText().toString().trim();

                if (emailUser.isEmpty() && passUser.isEmpty()){
                    Toast.makeText(MainActivity.this,"Ingresar los datos",Toast.LENGTH_SHORT).show();

                }else{
                    loginUser(emailUser, passUser);

                }
            }
        });

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrarse = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(registrarse);
            }
        });
    }

    private void loginVisitante() {
        mAuth.signInAnonymously()
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(new Intent(MainActivity.this, InicioActivity.class));
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        startActivity(new Intent(MainActivity.this, InicioActivity.class));
                        Toast.makeText(MainActivity.this,"Bienvenido",Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void loginUser(String emailUser, String passUser) {
        mAuth.signInWithEmailAndPassword(emailUser, passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    finish();
                    startActivity(new Intent(MainActivity.this, InicioActivity.class));
                    Toast.makeText(MainActivity.this,"Bienvenido",Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(new Intent(MainActivity.this, InicioActivity.class));
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this,"Error al iniciar sesión",Toast.LENGTH_SHORT).show();
            }
        });
    }


}