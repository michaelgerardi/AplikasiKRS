package com.example.aplikasikrs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.aplikasikrs.Adapter.MahasiswaAdapter;
import com.example.aplikasikrs.Model.Mahasiswa;

import java.util.ArrayList;

public class CrudMahasiswa extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MahasiswaAdapter mahasiswaAdapter;
    private ArrayList<Mahasiswa> mahasiswaArrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_mahasiswa);
        this.setTitle("SI KRS - HAI Michael");
        addData();

        recyclerView = findViewById(R.id.RcvMahasiswa);
        mahasiswaAdapter= new MahasiswaAdapter( mahasiswaArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CrudMahasiswa.this);
        recyclerView .setLayoutManager(layoutManager);
        recyclerView .setAdapter( mahasiswaAdapter );
    }
    private void addData(){
        mahasiswaArrayList = new ArrayList<>();
        mahasiswaArrayList.add(new Mahasiswa("72170100","arry","jogja","arrymail",R.drawable.arry));
    }
}
