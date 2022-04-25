package com.example.pines;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistorialTrabajador extends AppCompatActivity {

    DBHistorial DBHistorial;
    List<Historial> historial1;
    TextView tvRegistros;

    ImageButton imageButtonSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_trabajador);
        tvRegistros = findViewById(R.id.Registros);
        DBTrabajadores DBTrabajador = new DBTrabajadores(this);
        DBHistorial DBHistorial = new DBHistorial(this);
        imageButtonSalir = findViewById(R.id.imageButton2);
        String nombreUsuario= getIntent().getStringExtra("nombreUsuario");
        int id_trabajador =DBTrabajador.selecionarUsuario2(nombreUsuario);
        String id_trabajador1 = String.valueOf(id_trabajador);
        if(DBHistorial.consultar(id_trabajador)){
            init(nombreUsuario);
        }else {
            tvRegistros.setText("No se han realizado compras");
        }


        imageButtonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }


    public void init(String nombreUsuario){
        DBTrabajadores DBTrabajador = new DBTrabajadores(this);
        DBHistorial DBHistorial = new DBHistorial(this);
        int id_trabajador =DBTrabajador.selecionarUsuario2(nombreUsuario);
        String id_trabajador1 = String.valueOf(id_trabajador);
        historial1 = DBHistorial.selecionarHistorialTrabajador(id_trabajador1);
        historial1 = new ArrayList<>(historial1);
        Collections.reverse(historial1);
        ListAdaptadorHistorial listAdaptadorHistorial = new ListAdaptadorHistorial(historial1, this, new ListAdaptadorHistorial.OnItemClickListener() {
            @Override
            public void onItemClick(Historial historial) {

            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycleViewPines);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdaptadorHistorial);

    }

}