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

public class ListAdaptadorPaquete extends RecyclerView.Adapter<ListAdaptadorPaquete.ViewHolder> {

    private List<Paquete> mDatos;
    private LayoutInflater minflater;
    private Context context;
    final ListAdaptadorPaquete.OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(Paquete paquete);
    }


    public ListAdaptadorPaquete(List<Paquete> mDatos, Context context, ListAdaptadorPaquete.OnItemClickListener listener) {
        this.minflater = LayoutInflater.from(context);
        this.context = context;
        this.mDatos = mDatos;
        this.listener = listener;
    }


    @Override
    public int getItemCount() {return mDatos.size();}

    @NonNull
    @Override
    public ListAdaptadorPaquete.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = minflater.inflate(R.layout.pines_element, null);
        return new ListAdaptadorPaquete.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListAdaptadorPaquete.ViewHolder holder, final int position) {
        holder.binData(mDatos.get(position));
    }

    public void setItems(List<Paquete> items){ mDatos = items;}

        public class ViewHolder extends RecyclerView.ViewHolder{
            ImageView iconImagen;
            TextView  nombre, descripcion, planes;

            ViewHolder(View itemView){
                super(itemView);
                iconImagen = itemView.findViewById(R.id.iconoImagen);
                nombre= itemView.findViewById(R.id.nombrePin);
                descripcion=itemView.findViewById(R.id.nombrePinDescrip);
                planes= itemView.findViewById(R.id.nombrePindisponibilidad);
            }


            void binData(final Paquete items){
                iconImagen.setImageResource(items.getImagen());
                nombre.setText(items.getNombrePin());
                descripcion.setText(items.getDescripcionPin());
                planes.setText(items.getCantPin());
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) { listener.onItemClick(items); }
                });
        }





    }



}
