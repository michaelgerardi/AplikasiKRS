package com.example.aplikasikrs.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasikrs.EditMatakuliahActivity;
import com.example.aplikasikrs.Model.Matakuliah;
import com.example.aplikasikrs.R;

import java.util.ArrayList;

public class MatakuliahAdapter extends RecyclerView.Adapter<MatakuliahAdapter.ViewHolder> {
    ArrayList<Matakuliah> MatakuliahArrayList;
    private Context context;
    public MatakuliahAdapter(  ArrayList<Matakuliah> matakuliahArrayList) {
        MatakuliahArrayList = matakuliahArrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_curd_matkul,parent,false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder Matakuliah , int position) {
        Matakuliah.txtKodematkul.setText(MatakuliahArrayList.get(position).getKodematkul());
        Matakuliah.txtnamamatkul.setText(MatakuliahArrayList.get(position).getNamaMatkul());
        Matakuliah.txthari.setText(MatakuliahArrayList.get(position).getHari());
        Matakuliah.txtsesi.setText(MatakuliahArrayList.get(position).getSesi());
        Matakuliah.txtjumlahsks.setText(MatakuliahArrayList.get(position).getJumlahsks());
        Matakuliah.cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(context !=null){
                    Intent intent = new Intent(context, EditMatakuliahActivity.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return (MatakuliahArrayList!=null) ? MatakuliahArrayList.size():0;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtKodematkul,txtnamamatkul,txthari,txtsesi,txtjumlahsks;
        private CardView cd;
        public ViewHolder (View view){
            super(view);
            txtKodematkul = view.findViewById(R.id.txt_kode_matkul);
            txtnamamatkul = view.findViewById(R.id.txt_nama_matkul);
            txthari       = view.findViewById(R.id.txt_hari);
            txtsesi       = view.findViewById(R.id.txt_sesi_matkul);
            txtjumlahsks  = view.findViewById(R.id.txt_jumlah_sks_matkul);
            cd = view.findViewById(R.id.CV_matkul);
        }
    }

}
