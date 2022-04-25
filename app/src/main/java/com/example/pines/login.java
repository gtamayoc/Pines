package com.example.pines;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    private DBTrabajadores DBTrabajadores;
    private Button botonLoguearse,botonRegistrarse;
    private EditText editTextLoginNombreUsuario, editTextLoginContrasena;
    BDConexion conn;
    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        botonLoguearse=findViewById(R.id.buttonLoguear);
        botonRegistrarse=findViewById(R.id.buttonRegistrar);
        editTextLoginNombreUsuario=findViewById(R.id.editTextLoginNombreUsuario1);
        editTextLoginContrasena=findViewById(R.id.editTextLoginContrasena1);
        DBTrabajadores = new DBTrabajadores(this);
        conn=new BDConexion(getApplicationContext(),"BDPines", null,1);


        botonRegistrarse.setOnClickListener(new View.OnClickListener() {
            private static final long TIEMPO_MINIMO = 3500;
            private long ultimoClick = 0;
            @Override
            public void onClick(View view) {
                if (SystemClock.elapsedRealtime() - ultimoClick < TIEMPO_MINIMO) {
                    return;
                }
                ultimoClick = SystemClock.elapsedRealtime();

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        botonLoguearse.setOnClickListener(new View.OnClickListener() {

            private static final long TIEMPO_MINIMO = 3500;
            private long ultimoClick = 0;

            @Override
            public void onClick(View view) {
                String nombreUsuario = editTextLoginNombreUsuario.getText().toString();
                String contrasena = editTextLoginContrasena.getText().toString();


                if (SystemClock.elapsedRealtime() - ultimoClick < TIEMPO_MINIMO) {
                    return;
                }
                ultimoClick = SystemClock.elapsedRealtime();

                if(nombreUsuario.equals("")||contrasena.equals("")){
                    Toast.makeText(login.this, "Error: Campos Vacios", Toast.LENGTH_SHORT).show();
                }else if (DBTrabajadores.consultar(nombreUsuario, contrasena)) {
                    Intent i = new Intent(getApplicationContext(), Inicio.class);
                    i.putExtra("nombreUsuario", nombreUsuario);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(login.this, "Nombre de usuario o Contraseña no validos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}