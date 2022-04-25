package com.example.pines;

import static com.example.pines.CodigoAleatorio.getRandomString;
import static com.example.pines.FechaActual.getFecha;
import static com.example.pines.FechaActual.getFechaHora;
import static com.example.pines.FechaActual.getHora;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class DescripcionPlanes extends AppCompatActivity {


    ImageButton btnAtras;

    TextView tvBienvenida;
    EditText etDocumentoComprador;
    Intent intent;
    DBHistorial DBHistorial;
    DBTrabajadores DBTrabajadores;
    ArrayList<Trabajador> trabajador;
    ArrayList<Trabajador> listaTrabajadores = new ArrayList<Trabajador>();

    List<Plan> plan;
    List<Historial> historial;
    ArrayList<Historial> historial1;
    TextView tvNombrePlan, Codigo, Fecha, Precio, Hora;
    Button btnPagar;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_planes);
        intent = this.getIntent();
        tvNombrePlan = findViewById(R.id.tvNombrePlan);
        Codigo = findViewById(R.id.Codigo);
        Fecha = findViewById(R.id.Fecha);
        Hora = findViewById(R.id.tvHora);
        Precio = findViewById(R.id.Precio);
        btnPagar = findViewById(R.id.btnPagar);
        btnAtras = findViewById(R.id.imageAtras);


        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        etDocumentoComprador = findViewById(R.id.etDocumentoComprador);
        DBHistorial = new DBHistorial(this);
        String nombreUsuario = getIntent().getStringExtra("nombreUsuario");
        Plan plan = (Plan) getIntent().getSerializableExtra("Plan");
        Paquete paquete = (Paquete) getIntent().getSerializableExtra("Paquete");

        DBTrabajadores DBtrabajador = new DBTrabajadores(this);

        int Trabajador_id = DBtrabajador.selecionarUsuario2(nombreUsuario);
        int Saldo = DBtrabajador.selecionarSaldo(nombreUsuario);
        tvNombrePlan.setText(plan.getNombre());
        int i = 10;
        String Code = getRandomString(i);
        Codigo.setText(Code);
        String valor1 ="$"+(plan.getValor());
        Precio.setText(valor1);
        String miliseconds= (getFecha());
        int Maxventa = 0;

        try {
            Boolean fechas=DBHistorial.consultarFechas(getFecha(),Trabajador_id);
            if(fechas==true){

            }else{
                Trabajador trabajador = new Trabajador();
                trabajador.setNombreUsuario(nombreUsuario);
                trabajador.setSaldo("1000000");
                DBtrabajador.actualizarTrabajador(trabajador);
            }
            Fecha.setText("no hay registros");
        }catch (Exception e){}
        Fecha.setText(getFecha());
        Hora.setText(getHora());

        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alerta = new AlertDialog.Builder(DescripcionPlanes.this);
                alerta.setMessage("Estas Seguro Que Deseas Comprar")
                        .setCancelable(false)
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String etDocumentoComprador1 = etDocumentoComprador.getText().toString();
                                String costo_pin = plan.getValor();
                                int costo_pin1 = Integer.parseInt(costo_pin);
                                int Total = Saldo - costo_pin1;

                                if(!etDocumentoComprador1.equals("")){
                                    if(etDocumentoComprador1.length()>=7){
                                        if(Saldo>=costo_pin1){
                                            String TotalPagar= String.valueOf(Total);
                                            String Documento = etDocumentoComprador.getText().toString();
                                            Historial historial1 = new Historial();
                                            historial1.setNombre_pin(plan.getNombre());
                                            historial1.setNombre_plan((plan.getNombre_pin()));
                                            historial1.setFk_trabajador_id(Trabajador_id);
                                            historial1.setComprador_id(Documento);
                                            historial1.setHash_pin(Code);
                                            historial1.setValor_compra(costo_pin);
                                            historial1.setFecha_compra(getFechaHora());
                                            int Maxventa1 = Integer.parseInt(TotalPagar);
                                            String Maxventa2 =   String.valueOf(Maxventa1);
                                            if (DBHistorial.insertarHistorial(historial1)) {
                                                Trabajador trabajador = new Trabajador();
                                                trabajador.setNombreUsuario(nombreUsuario);
                                                trabajador.setSaldo(Maxventa2);
                                                if (DBtrabajador.actualizarTrabajador(trabajador)){
                                                    Toast.makeText(DescripcionPlanes.this, "Agregado", Toast.LENGTH_SHORT).show();

                                                }
                                                onBackPressed();
                                            } else if (DBHistorial.insertarHistorial(historial1) == false) {
                                                Toast.makeText(DescripcionPlanes.this, "No Agregado", Toast.LENGTH_SHORT).show();
                                            }
                                        }else{
                                            Toast.makeText(DescripcionPlanes.this, "Saldo Insuficiente", Toast.LENGTH_SHORT).show();
                                        }
                                    }else{
                                        Toast.makeText(DescripcionPlanes.this, "Ingresar documento valido", Toast.LENGTH_SHORT).show();
                                    }

                                }else{
                                    Toast.makeText(DescripcionPlanes.this, "Documento No Valido", Toast.LENGTH_SHORT).show();
                                }
                                dialogInterface.cancel();
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });


                AlertDialog titulo = alerta.create();
                titulo.setTitle("Confirmar Compra");
                titulo.show();


            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        String nombreUsuario = getIntent().getStringExtra("nombreUsuario");
        Paquete paquete =(Paquete) getIntent().getSerializableExtra("Paquete");
        intent = new Intent(DescripcionPlanes.this, Inicio.class);
        intent.putExtra("nombreUsuario", nombreUsuario);
        intent.putExtra("Paquete", paquete);
        startActivity(intent);

    }

}