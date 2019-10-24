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

import com.example.aplikasikrs.EditKelolaKRSActivity;
import com.example.aplikasikrs.Model.KelolaKRS;
import com.example.aplikasikrs.R;

import java.util.ArrayList;

public class KelaolaKrsAdapter extends RecyclerView.Adapter<KelaolaKrsAdapter.ViewHolder> {
    ArrayList<KelolaKRS> KelolaKRSArrayList;
    private Context context;
    public KelaolaKrsAdapter(  ArrayList<KelolaKRS> kelolaKRSArrayList) {
        KelolaKRSArrayList = kelolaKRSArrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_kelola_krs,parent,false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder KRS, int position) {
        KRS.txtKodematkul.setText(KelolaKRSArrayList.get(position).getKode());
        KRS.txtmatakuliah.setText(KelolaKRSArrayList.get(position).getMatkul());
        KRS.txthari.setText(KelolaKRSArrayList.get(position).getHari());
        KRS.txtsesi.setText(KelolaKRSArrayList.get(position).getSesi());
        KRS.txtjumlahsiswa.setText(KelolaKRSArrayList.get(position).getJumlahMHS());
        KRS.txtdosenpengampu.setText(KelolaKRSArrayList.get(position).getPengampu());
        KRS.txtjumlahkrs.setText(KelolaKRSArrayList.get(position).getJumlahkrs());
        KRS.CV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(context !=null){
                    Intent intent = new Intent(context,EditKelolaKRSActivity.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return (KelolaKRSArrayList!=null) ? KelolaKRSArrayList.size():0;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        private TextView txtKodematkul,txtmatakuliah,txthari,txtsesi,txtdosenpengampu,txtjumlahsiswa,txtjumlahkrs;
        private  CardView CV;

        public ViewHolder( View view) {
            super(view);
            txtKodematkul = view.findViewById(R.id.txt_kode);
            txtmatakuliah = view.findViewById(R.id.txt_matakul);
            txthari = view.findViewById(R.id.txt_hari_kul);
            txtsesi = view.findViewById(R.id.txt_sesi_krs);
            txtdosenpengampu = view.findViewById(R.id.txt_dosen_pengampu);
            txtjumlahsiswa = view.findViewById(R.id.txt_jumlah_mahasiswa);
            txtjumlahkrs = view.findViewById(R.id.txt_jumlah_krs);
            CV = view.findViewById(R.id.CV_Kelola_Krs);

        }
    }
}
