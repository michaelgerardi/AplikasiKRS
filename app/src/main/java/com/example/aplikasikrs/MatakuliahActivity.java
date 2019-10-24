package com.example.aplikasikrs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.aplikasikrs.Adapter.MatakuliahAdapter;
import com.example.aplikasikrs.Model.Matakuliah;

import java.util.ArrayList;

public class MatakuliahActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MatakuliahAdapter matakuliahAdapter;
    private ArrayList<Matakuliah> matakuliahArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matakuliah);
        this.setTitle("SI KRS - HAI Michael");
        addData();

        recyclerView = findViewById(R.id.RcvMatakuliah);
        matakuliahAdapter = new MatakuliahAdapter(matakuliahArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MatakuliahActivity.this);
        recyclerView .setLayoutManager(layoutManager);
        recyclerView .setAdapter(matakuliahAdapter);


    }
    private  void addData(){
        matakuliahArrayList= new ArrayList<>();
        matakuliahArrayList.add(new Matakuliah("12","dasar","sabtu","4","3"));
        matakuliahArrayList.add(new Matakuliah("1235","isbd","sabtu","4","3"));
    }
}
