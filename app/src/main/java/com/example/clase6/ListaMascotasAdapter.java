package com.example.clase6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListaMascotasAdapter extends  RecyclerView.Adapter<ListaMascotasAdapter.MascotaViewHolder>{
    private List<Mascota> listaMascotas;
    private Context context;


    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        Mascota e = listaMascotas.get(position);
        holder.mascota = e;

        TextView textViewMascota = holder.itemView.findViewById(R.id.textView13);
        textViewMascota.setText(e.getMascota());
        TextView textViewGenero = holder.itemView.findViewById(R.id.textView14);
        textViewGenero.setText(e.getGenero());
        TextView textViewDueno = holder.itemView.findViewById(R.id.textView15);
        textViewDueno.setText(e.getDueno());
        TextView textViewDNI = holder.itemView.findViewById(R.id.textView16);
        textViewDNI.setText(e.getDni());
        TextView textViewDescripcion = holder.itemView.findViewById(R.id.textView17);
        textViewDescripcion.setText(e.getDescripcion());
        TextView textViewRuta = holder.itemView.findViewById(R.id.textView18);
        textViewRuta.setText(e.getRuta());

    }
    @Override
    public int getItemCount() {
        return listaMascotas.size();
    }
    public class MascotaViewHolder extends RecyclerView.ViewHolder{

        Mascota mascota;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public List<Mascota> getListaMascotas() {
        return listaMascotas;
    }

    public void setListaMascotas(List<Mascota> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
