package com.example.aplikasikrs.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasikrs.EditMahasiswa;
import com.example.aplikasikrs.Model.Mahasiswa;
import com.example.aplikasikrs.R;

import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.ViewHolder> {
    ArrayList<Mahasiswa> MahasiswaArrayList;
    private Context context;
    public MahasiswaAdapter(  ArrayList<Mahasiswa> mahasiswaArrayLista) {
        MahasiswaArrayList = mahasiswaArrayLista;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_crud_mahasiswa,parent,false);
        context = parent.getContext();
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder mahasiswa, int position) {
        mahasiswa.txtNim.setText(MahasiswaArrayList.get(position).getNIM());
        mahasiswa.txtNama.setText(MahasiswaArrayList.get(position).getNama());
        mahasiswa.txtAlamat.setText(MahasiswaArrayList.get(position).getAlamat());
        mahasiswa.txtEmail.setText(MahasiswaArrayList.get(position).getEmail());
        mahasiswa.cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(context !=null){
                    Intent intent = new Intent(context, EditMahasiswa.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {

        return (MahasiswaArrayList !=null) ? MahasiswaArrayList.size():0;
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNim,txtNama,txtAlamat,txtEmail;
        private ImageView Gambar;
        private CardView cd;
        public ViewHolder(View view){
            super(view);
            txtNim = view.findViewById(R.id.txt_nim_mhs);
            txtNama = view.findViewById(R.id.txt_nama_mhs);
            txtEmail = view.findViewById(R.id.txt_email_mhs);
            txtAlamat = view.findViewById(R.id.txt_alamat_mhs);
            cd = view.findViewById(R.id.CV_Mahasiswa);
        }
    }
}
