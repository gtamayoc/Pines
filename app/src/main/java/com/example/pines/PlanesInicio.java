package com.example.pines;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PlanesInicio extends AppCompatActivity {

    Intent intent;
    List<Plan> paquetes1;
    TextView tvNombrePin;
    String nombreUsuario;
    ImageButton imageButtonSalir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_plan);
        intent = this.getIntent();
        tvNombrePin = findViewById(R.id.tvNombrePin);

        Paquete paquete =(Paquete) getIntent().getSerializableExtra("Paquete");
        tvNombrePin.setText(paquete.getNombrePin());
        nombreUsuario= getIntent().getStringExtra("nombreUsuario");
        int idPaquete=paquete.getId();

        imageButtonSalir = findViewById(R.id.imageButton2);


        imageButtonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        init(idPaquete);
}


    public void init(int idPaquete){
        paquetes1 = new ArrayList<>();
        if (idPaquete == 0) {
            paquetes1.add(new Plan(0,"Básico","16900","1 mes","Calidad de video decente, Resolución 480p, Ve Netflix en tu TV, computadora, celular y tablet.","Netflix",R.drawable.netflix));
            paquetes1.add(new Plan(1,"Estándar","26900","2 meses","Calidad de video decente, Resolución 720p, Ve Netflix en tu TV, computadora, celular y tablet.","Netflix",R.drawable.netflix));
            paquetes1.add(new Plan(2,"Premium","38900","3 meses","Calidad de video decente, Resolución 1080p, Ve Netflix en tu TV, computadora, celular y tablet.","Netflix",R.drawable.netflix));
            paquetes1.add(new Plan(3,"VIP","48900","4 meses","Calidad de video decente, Resolución 4K+HDR, Ve Netflix en tu TV, computadora, celular y tablet.","Netflix",R.drawable.netflix));
        }else if(idPaquete == 1){
            paquetes1.add(new Plan(0,"Básico","14900","1 mes","El servicio incluye conexión hasta en 1 dispositivos de manera simultánea, así como calidad de imagen en SD, HD o UHD 4K.","Prime video",R.drawable.amazon));
            paquetes1.add(new Plan(1,"Estándar","24900","2 meses","El servicio incluye conexión hasta en 3 dispositivos de manera simultánea, así como calidad de imagen en SD, HD o UHD 4K.","Prime video",R.drawable.amazon));
            paquetes1.add(new Plan(1,"Premium","34900","3 meses","El servicio incluye conexión hasta en 6 dispositivos de manera simultánea, así como calidad de imagen en SD, HD o UHD 4K.","Prime video",R.drawable.amazon));
            paquetes1.add(new Plan(1,"VIP","44900","4 meses","El servicio incluye conexión hasta en 12 dispositivos de manera simultánea, así como calidad de imagen en SD, HD o UHD 4K.","Prime video",R.drawable.amazon));

        }else if(idPaquete == 2){
            paquetes1.add(new Plan(0, "Básico","13900","1 mes","Todos los dispositivos, Maximo 1 dispositivos a la vez, Alta definición y 4K Descarga hasta 30 títulos, 1 Perfiles","HBO MAX",R.drawable.hbo));
            paquetes1.add(new Plan(1,"Estándar","23900","2 mes","Todos los dispositivos, Maximo 3 dispositivos a la vez, Alta definición y 4K Descarga hasta 60 títulos, 2 Perfiles","HBO MAX",R.drawable.hbo));
            paquetes1.add(new Plan(2,"Premium","33900","3 mes","Todos los dispositivos, Maximo 5 dispositivos a la vez, Alta definición y 4K Descarga hasta 90 títulos, 5 Perfiles","HBO MAX",R.drawable.hbo));
            paquetes1.add(new Plan(3,"VIP","43900","4 mes","Todos los dispositivos, Maximo 8 dispositivos a la vez, Alta definición y 4K Descarga hasta 120 títulos, 7 Perfiles","HBO MAX",R.drawable.hbo));

        }else if(idPaquete == 3){
            paquetes1.add(new Plan(0, "Básico","20000","1 mes","El servicio Disney+ incluye conexión hasta en 1 dispositivos de manera simultánea, así como calidad de imagenn SD, HD o UHD 4K, la calidad depende de tu conexion a internet.","Disney+",R.drawable.disney));
            paquetes1.add(new Plan(1,"Estándar","31000","2 mes","El servicio Disney+ incluye conexión hasta en 3 dispositivos de manera simultánea, así como calidad de imagenn SD, HD o UHD 4K, la calidad depende de tu conexion a internet.","Disney+",R.drawable.disney));
            paquetes1.add(new Plan(2,"Premium","42000","3 mes","El servicio Disney+ incluye conexión hasta en 5 dispositivos de manera simultánea, así como calidad de imagenn SD, HD o UHD 4K, la calidad depende de tu conexion a internet.","Disney+",R.drawable.disney));
            paquetes1.add(new Plan(3,"VIP","55000","4 mes","El servicio Disney+ incluye conexión hasta en 7 dispositivos de manera simultánea, así como calidad de imagenn SD, HD o UHD 4K, la calidad depende de tu conexion a internet.","Disney+",R.drawable.disney));
        }else if(idPaquete == 4){
            paquetes1.add(new Plan(0, "Básico","15600","1 mes","Spotify Premium te ofrece un servicio cero anuncios; por lo que podrás disfrutar de tus canciones favoritas sin ningún tipo de interrupción de publicidad en 1 dispositivos.","Spotify",R.drawable.spo));
            paquetes1.add(new Plan(1,"Estándar","25600","2 mes","Spotify Premium te ofrece un servicio cero anuncios; por lo que podrás disfrutar de tus canciones favoritas sin ningún tipo de interrupción de publicidad en 2 dispositivos.","Spotify",R.drawable.spo));
            paquetes1.add(new Plan(2,"Premium","35600","3 mes","Spotify Premium te ofrece un servicio cero anuncios; por lo que podrás disfrutar de tus canciones favoritas sin ningún tipo de interrupción de publicidad en 3 dispositivos.","Spotify",R.drawable.spo));
            paquetes1.add(new Plan(3,"VIP","45600","4 mes","Spotify Premium te ofrece un servicio cero anuncios; por lo que podrás disfrutar de tus canciones favoritas sin ningún tipo de interrupción de publicidad en 4 dispositivos.","Spotify",R.drawable.spo));
        }else{
            paquetes1.add(new Plan(0, "Básico","100000","1 mes","El servicio incluye conexión hasta en 1 dispositivos de manera simultánea, así como calidad de imagen en SD.","Youtube Premium",R.drawable.yt));
            paquetes1.add(new Plan(1,"Estándar","200000","2 mes","El servicio incluye conexión hasta en 4 dispositivos de manera simultánea, así como calidad de imagen en SD y HD .","Youtube Premium",R.drawable.yt));
            paquetes1.add(new Plan(2,"Premium","350000","3 mes","El servicio incluye conexión hasta en 6 dispositivos de manera simultánea, así como calidad de imagen en SD, HD o UHD 4K.","Youtube Premium",R.drawable.yt));
            paquetes1.add(new Plan(3,"VIP","500000","4 mes","El servicio incluye conexión hasta en 8 dispositivos de manera simultánea, así como calidad de imagen en SD, HD o UHD 4K.","Youtube Premium",R.drawable.yt));
        }


        ListAdaptadorPlan listAdaptadorPlan = new ListAdaptadorPlan(paquetes1, this, new ListAdaptadorPlan.OnItemClickListener() {
            @Override
            public void onItemClick(Plan plan) {
                moveToDescription(plan);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.recycleViewPlanes);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdaptadorPlan);

    }


    public void moveToDescription(Plan plan){
        Paquete paquete =(Paquete) getIntent().getSerializableExtra("Paquete");
        String nombreUsuario= getIntent().getStringExtra("nombreUsuario");
        intent = new Intent(this, DescripcionPlanes.class);
        intent.putExtra("Plan", plan);
        intent.putExtra("Paquete", paquete);
        intent.putExtra("nombreUsuario", nombreUsuario);
        startActivity(intent);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        intent = new Intent(this, Inicio.class);
        String nombreUsuario= getIntent().getStringExtra("nombreUsuario");
        intent.putExtra("nombreUsuario", nombreUsuario);
        startActivity(intent);
    }
}