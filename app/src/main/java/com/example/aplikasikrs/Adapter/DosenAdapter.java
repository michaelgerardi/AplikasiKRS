package com.example.aplikasikrs.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasikrs.Cruddosen;
import com.example.aplikasikrs.EditDosenActivity;
import com.example.aplikasikrs.Model.Dosen;
import com.example.aplikasikrs.R;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.ArrayList;



public class DosenAdapter extends RecyclerView.Adapter<DosenAdapter.ViewHolder> {
    ArrayList<Dosen>DosenArrayList;
    private Context context;


    public DosenAdapter(  ArrayList<Dosen> dosenArrayList) {
        DosenArrayList = dosenArrayList;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_crud_dosen,parent,false);
        context = parent.getContext();
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder Dosen, int position) {

        Dosen.txtNIDN.setText(DosenArrayList.get(position).getNIDN());
        Dosen.txtNamaDosen.setText(DosenArrayList.get(position).getNamaDosen());
        Dosen.txtGelar.setText(DosenArrayList.get(position).getGelar());
        Dosen.txtEmail.setText(DosenArrayList.get(position).getEmail());
        Dosen.txtAlamat.setText(DosenArrayList.get(position).getAlamat());
        Dosen.img.getLayoutParams().width=100;
        Dosen.img.getLayoutParams().height=100;
        if (DosenArrayList.get(position).getImg()!=null){
            Picasso.with(this.context)
            .load("https://kpsi.fti.ukdw.ac.id/progmob/" +DosenArrayList.get(position).getImg())
            .into(Dosen.img);
        }



    }

    @Override
    public int getItemCount() {

        return (DosenArrayList !=null) ? DosenArrayList.size():0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    implements View.OnCreateContextMenuListener{

        private TextView txtNIDN, txtNamaDosen, txtGelar, txtEmail, txtAlamat;
        private ImageView img;
        private CardView cd;

        public ViewHolder(View view) {
            super(view);
            txtNIDN = view.findViewById(R.id.NIDN_dosen);
            txtNamaDosen = view.findViewById(R.id.Nama_dosen);
            txtGelar = view.findViewById(R.id.Gelar_Dosen);
            txtEmail = view.findViewById(R.id.Email_dosen);
            txtAlamat = view.findViewById(R.id.Alamat_dosen);
            img = view.findViewById(R.id.Foto_Dosen);
            cd = view.findViewById(R.id.CV_dosen);
            view.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu Menu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            Menu.setHeaderTitle("Silahkan Pilih");
            Menu.add(this.getAdapterPosition(),view.getId(),0,"Ubah data dosen ");
            Menu.add(this.getAdapterPosition(),view.getId(),0,"Delete data dosen ");
        }


    }

}


