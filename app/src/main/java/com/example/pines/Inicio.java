package com.example.pines;

import static com.example.pines.FechaActual.getFecha;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Inicio extends AppCompatActivity {

    ImageButton btnAtras;
    TextView tvBienvenida,tvSaldo;
    Intent intent;
    ExtendedFloatingActionButton extended;
    int contador=0;

    List<Paquete> paquetes1;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        String nombreUsuario= getIntent().getStringExtra("nombreUsuario");
        tvBienvenida = findViewById(R.id.textView);
        tvSaldo = findViewById(R.id.textViewSaldo);
        extended = findViewById(R.id.floatingActionButton);
        btnAtras = findViewById(R.id.imageAtras);


        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



        DBTrabajadores DBtrabajador = new DBTrabajadores(this);
        int Trabajador_id = DBtrabajador.selecionarUsuario2(nombreUsuario);
        DBHistorial DBHistorial = new DBHistorial(this);
        Boolean fechas=DBHistorial.consultarFechas(getFecha(),Trabajador_id);
        if(fechas==true){

        }else{
                    Trabajador trabajador = new Trabajador();
                   trabajador.setNombreUsuario(nombreUsuario);
                   trabajador.setSaldo("1000000");
                   DBtrabajador.actualizarTrabajador(trabajador);
        }



        DBTrabajadores DBTrabajador = new DBTrabajadores(this);
        int saldo = DBTrabajador.selecionarSaldo(nombreUsuario);
        String SaldoView = String.valueOf(saldo);

        String valor1 ="$"+(SaldoView);
        tvSaldo.setText(valor1);
        tvBienvenida.setText(nombreUsuario);
        intent = this.getIntent();
        extended.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreUsuario= getIntent().getStringExtra("nombreUsuario");
                Intent i = new Intent(getApplicationContext(), HistorialTrabajador.class);
                i.putExtra("nombreUsuario", nombreUsuario);
                startActivity(i);
            }
        });
        init();

    }

    public void init(){


        paquetes1 = new ArrayList<>();
        paquetes1.add(new Paquete(0,R.drawable.netflix,"Netflix","Netflix es un servicio de streaming que ofrece una gran variedad de películas, series y documentales premiados en casi cualquier pantalla conectada a internet.","4 Paquetes Disponibles"));
        paquetes1.add(new Paquete(1,R.drawable.amazon,"Prime video","Amazon Prime Video ofrece una biblioteca cada vez más grande de contenido original de calidad y una buena colección de películas y programas de televisión para transmitir.","4 Paquetes Disponibles"));
        paquetes1.add(new Paquete(2,R.drawable.hbo,"HBO MAX","HBO Max™ es una plataforma de streaming donde encontrarás contenido para toda la familia. Disfruta de todos los partidos de la UEFA Champions League en vivo, Max Originals, HBO®, el Universo DC, Warner Bros y Cartoon Network","4 Paquetes Disponibles"));
        paquetes1.add(new Paquete(3,R.drawable.disney,"Disney+","Para toda la familia y lleno de nuevas colaboraciones televisivas de gran éxito con Marvel y Star Wars, Disney+ compensa una biblioteca disponible en general más pequeña con algunos pesos pesados nostálgicos y algunos programas increíbles de National Geographic. También tiene un precio muy asequible. ","4 Paquetes Disponibles"));
        paquetes1.add(new Paquete(4,R.drawable.spo,"Spotify","Spotify es un servicio de música, pódcasts y vídeos digitales que te da acceso a millones de canciones y a otro contenido de creadores de todo el mundo.","4 Paquetes Disponibles"));
        paquetes1.add(new Paquete(5,R.drawable.yt,"Youtube Premium","YouTube Premium es un servicio de suscripción de transmisión de pago para YouTube que proporciona transmisión sin publicidad de todos los vídeos alojados en YouTube, contenido original exclusivo producido en colaboración con los principales creadores del sitio.","4 Paquetes Disponibles"));


        ListAdaptadorPaquete listAdaptadorPaquete = new ListAdaptadorPaquete(paquetes1, this, new ListAdaptadorPaquete.OnItemClickListener() {
            @Override
            public void onItemClick(Paquete paquete) {
                moveToDescription(paquete);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.recycleViewPines);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdaptadorPaquete);

    }


    public void moveToDescription(Paquete paquete){
        String nombreUsuario= getIntent().getStringExtra("nombreUsuario");
        intent = new Intent(this, PlanesInicio.class);
        intent.putExtra("Paquete", paquete);
        intent.putExtra("nombreUsuario", nombreUsuario);
        startActivity(intent);
        finish();

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alerta = new AlertDialog.Builder(Inicio.this);
         alerta.setMessage("¿Estas Seguro Que Deseas salir de la Aplicación?")
            .setCancelable(false)
            .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                    finishAffinity();
                }
            })
            .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });

            AlertDialog titulo = alerta.create();
            titulo.show();


    }

}