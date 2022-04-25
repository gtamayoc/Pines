package com.example.pines;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class ListAdaptadorPlan extends RecyclerView.Adapter<ListAdaptadorPlan.ViewHolder>{

    private final LayoutInflater minflater;
    private List<Plan> mDatos;
    private LayoutInflater inflater;
    private Context context;
    final ListAdaptadorPlan.OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(Plan plan);
    }


    public ListAdaptadorPlan(List<Plan> mDatos, Context context, ListAdaptadorPlan.OnItemClickListener listener) {
        this.minflater = LayoutInflater.from(context);
        this.context = context;
        this.mDatos = mDatos;
        this.listener = listener;
    }


    @Override
    public int getItemCount() {return mDatos.size();}

    @NonNull
    @Override
    public ListAdaptadorPlan.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = minflater.inflate(R.layout.planes_element, null);
        return new ListAdaptadorPlan.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdaptadorPlan.ViewHolder holder, final int position) {
        holder.binData(mDatos.get(position));
    }


    public void setItems(List<Plan> items){ mDatos = items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImagen;
        TextView  nombre, valor, duracion, descripcion,codigo;
        int fkPin;

        ViewHolder(View itemView){
            super(itemView);
            iconImagen = itemView.findViewById(R.id.iconoImagen);
            nombre= itemView.findViewById(R.id.nombrePlan);
            valor=itemView.findViewById(R.id.ValorPLan);
            duracion= itemView.findViewById(R.id.CompradorPlan);
            descripcion= itemView.findViewById(R.id.nombrePlanDescrip);
            codigo=itemView.findViewById(R.id.codigoPlan);
        }


        void binData(@NonNull final Plan items){
            iconImagen.setImageResource(items.getImagen());
            nombre.setText(items.getNombre());
            String valor1 ="$"+(items.getValor());
            valor.setText(valor1);
            duracion.setText(items.getDuracion());
            codigo.setId(items.getCodigo());
            descripcion.setText(items.getDescripcion());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(items);
                }
            });
        }





    }

}
