package com.example.pines;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdaptadorHistorial extends RecyclerView.Adapter<ListAdaptadorHistorial.ViewHolder> {


    private List<Historial> mDatos;
    private LayoutInflater minflater;
    private Context context;
    final ListAdaptadorHistorial.OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(Historial historial);
    }


    public ListAdaptadorHistorial(List<Historial> mDatos, Context context, ListAdaptadorHistorial.OnItemClickListener listener) {
        this.minflater = LayoutInflater.from(context);
        this.context = context;
        this.mDatos = mDatos;
        this.listener = listener;
    }



    public int getItemCount() {return mDatos.size();}

    @NonNull
    public ListAdaptadorHistorial.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = minflater.inflate(R.layout.pines_historial, null);
        return new ListAdaptadorHistorial.ViewHolder(view);
    }


    public void onBindViewHolder(ListAdaptadorHistorial.ViewHolder holder, final int position) {
        holder.binData(mDatos.get(position));
    }

    public void setItems(List<Historial> items){ mDatos = items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView plan, pin, descripcion, comprador, fecha, valor, codigo;

        ViewHolder(View itemView){
            super(itemView);
            plan = itemView.findViewById(R.id.nombrePlan);
            pin =itemView.findViewById(R.id.nombrePin);
            comprador = itemView.findViewById(R.id.CompradorPlan);
            fecha = itemView.findViewById(R.id.FechaCompra);
            valor = itemView.findViewById(R.id.ValorPLan);
            codigo = itemView.findViewById(R.id.codigoPlan);
        }


        void binData(final Historial items){
            int id1= items.getId();
            String id2 = String.valueOf(id1);
            String pin1= items.getNombre_pin();
            String plan1 = items.getNombre_plan();
            DBHistorial DBHistorial = new DBHistorial(context);
            plan.setText(pin1);
            pin.setText(plan1);
            comprador.setText(items.getComprador_id());
            fecha.setText(items.getFecha_compra());
            String valor1 ="$"+(items.getValor_compra());
            valor.setText(valor1);
            codigo.setText(items.getHash_pin());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) { listener.onItemClick(items); }
            });
        }


    }

}
