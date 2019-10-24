package com.example.aplikasikrs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class DaftarIsiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_isi);
        this.setTitle("SI KRS - HAI Michael");
        ImageButton Daftardosen = findViewById(R.id.imageButton2);
        Daftardosen.setOnClickListener(btnDosen);

        ImageButton DaftarMahasiswa = findViewById(R.id.imageButton5);
        DaftarMahasiswa.setOnClickListener(btnmhs);

        ImageButton Daftarmatkul= findViewById(R.id.imageButton3);
        Daftarmatkul.setOnClickListener(btnmatkul);

        ImageButton Daftarkelola = findViewById(R.id.imageButton4);
        Daftarkelola.setOnClickListener(btnkelolakrs);

        ImageButton daftardiri =findViewById(R.id.imageButton);
        daftardiri.setOnClickListener(btndatadiri);


    }
    private View.OnClickListener btnDosen = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(DaftarIsiActivity.this,Cruddosen.class);
            startActivity(intent);
        }
    };
    private  View.OnClickListener btnmhs  = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(DaftarIsiActivity.this,CrudMahasiswa.class);
            startActivity(intent);
        }
    };
    private  View.OnClickListener btnmatkul = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(DaftarIsiActivity.this,MatakuliahActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener btnkelolakrs = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(DaftarIsiActivity.this,KelolaKRSActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener btndatadiri = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent =new Intent(DaftarIsiActivity.this,DataDiriActivity.class);
            startActivity(intent);
        }
    };
}
