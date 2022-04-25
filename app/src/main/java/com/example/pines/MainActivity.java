package com.example.pines;

import static com.example.pines.Validaciones.ValidarEmail;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    CheckBox checkBox;
    private DBTrabajadores DBTrabajadores;
    private Button botonRegistrar;
    ImageButton imageButtonSalir;
    private EditText editTextNombre, editTextApellido, editTextDocumento, editTextCorreo, editTextNombreUsuario, editTextContrasena, editTextContrasena1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = findViewById(R.id.editTextNombre1);
        editTextApellido = findViewById(R.id.editTextApellido1);
        editTextDocumento = findViewById(R.id.editTextDocumento1);
        editTextCorreo = findViewById(R.id.editTextCorreo1);
        editTextNombreUsuario = findViewById(R.id.editTextNombreUsuario1);
        editTextContrasena = findViewById(R.id.editTextContrasena2);
        editTextContrasena1 = findViewById(R.id.editTextContrasena3);
        botonRegistrar = findViewById(R.id.buttonRegistrar2);
        DBTrabajadores = new DBTrabajadores(this);
        imageButtonSalir = findViewById(R.id.imageButton2);


        imageButtonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        botonRegistrar.setOnClickListener(new View.OnClickListener() {
            private static final long TIEMPO_MINIMO = 3500;
            private long ultimoClick = 0;
            @Override
            public void onClick(View view) {
                if (SystemClock.elapsedRealtime() - ultimoClick < TIEMPO_MINIMO) {
                    return;
                }
                ultimoClick = SystemClock.elapsedRealtime();
                String Nombre = editTextNombre.getText().toString();
                String Apellido = editTextApellido.getText().toString();
                String Correo = editTextCorreo.getText().toString();
                String NombreUsuario = editTextNombreUsuario.getText().toString();
                String contrasena1 = editTextContrasena.getText().toString();
                String contrasena2 = editTextContrasena1.getText().toString();
                String documento = editTextDocumento.getText().toString();
                checkBox=findViewById(R.id.checkBoxRe);
                Trabajador trabajador = new Trabajador();
                trabajador.setNombre(Nombre);
                trabajador.setApellido(Apellido);
                trabajador.setDocumento(documento);
                trabajador.setCorreo(Correo);
                trabajador.setNombreUsuario(NombreUsuario);
                trabajador.setSaldo("1000000");
                trabajador.setContrasena(contrasena1);

                if(!(Nombre.length()<3)){
                     if(!(Apellido.length()<4)){
                         if(!(documento.length()<=7)){
                             if(!(NombreUsuario.length()<5)){
                                 if(!(contrasena1.length()<7) && !(contrasena2.length()<7)){
                                     if (trabajador.isNull()) {
                                         Toast.makeText(MainActivity.this, "Campos Vacios", Toast.LENGTH_SHORT).show();
                                     } else if (contrasena1.equals(contrasena2)) {
                                         if (ValidarEmail(editTextCorreo.getText().toString())){
                                             if(checkBox.isChecked()){
                                                 if (DBTrabajadores.consultarNombreUsuario(NombreUsuario)!=true) {
                                                     if (DBTrabajadores.insertarUser(trabajador)) {
                                                         Toast.makeText(MainActivity.this, "Registro Exitoso", Toast.LENGTH_LONG).show();
                                                         Intent i = new Intent(getApplicationContext(), login.class);
                                                         startActivity(i);
                                                         finish();
                                                     } else {
                                                         Toast.makeText(MainActivity.this, "usuario ya registrado", Toast.LENGTH_LONG).show();
                                                     }
                                                 } else {
                                                     Toast.makeText(MainActivity.this, "usuario ya  registrado", Toast.LENGTH_LONG).show();
                                                 }
                                             }else{
                                                 Toast.makeText(MainActivity.this, "Acepta TyC para poder registrarte", Toast.LENGTH_SHORT).show();
                                             }
                                         }else {
                                             Toast.makeText(MainActivity.this, "Correo Erroneo", Toast.LENGTH_SHORT).show();
                                         }
                                     } else {
                                         Toast.makeText(MainActivity.this, "Contraseñas Diferentes", Toast.LENGTH_SHORT).show();
                                     }


                                 }else{
                                     Toast.makeText(MainActivity.this, "Ingresar contraseñas Validas(minimo 7 caracteres).", Toast.LENGTH_SHORT).show();
                                 }
                             }else{
                                 Toast.makeText(MainActivity.this, "Ingresar Nombre de usuario Valido.", Toast.LENGTH_SHORT).show();
                             }
                         }else{
                             Toast.makeText(MainActivity.this,"Ingresar documento Valido." , Toast.LENGTH_SHORT).show();
                         }
                    }else{
                        Toast.makeText(MainActivity.this, "Ingresar Apellido Valido.", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Ingresar Nombre Valido.", Toast.LENGTH_SHORT).show();
                }




            }
        });

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(getApplicationContext(), login.class);
        startActivity(i);
    }
}