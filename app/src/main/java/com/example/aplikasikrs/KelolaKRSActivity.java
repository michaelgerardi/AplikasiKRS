package com.example.aplikasikrs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.aplikasikrs.Adapter.KelaolaKrsAdapter;
import com.example.aplikasikrs.Model.KelolaKRS;

import java.util.ArrayList;

public class KelolaKRSActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private KelaolaKrsAdapter kelaolaKrsAdapter;
    private ArrayList<KelolaKRS> kelolaKRSArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelola_krs);
        this.setTitle("SI KRS - HAI Michael");
        addData();


        recyclerView = findViewById(R.id.RrcvKelolaKRS);
        kelaolaKrsAdapter = new KelaolaKrsAdapter(kelolaKRSArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(KelolaKRSActivity.this);
        recyclerView .setLayoutManager(layoutManager);
        recyclerView .setAdapter(kelaolaKrsAdapter);

    }
    private  void  addData(){
        kelolaKRSArrayList = new ArrayList<>();
        kelolaKRSArrayList.add(new KelolaKRS("12","Dasar","4","4","3","45" ,"minggu"));
        kelolaKRSArrayList.add(new KelolaKRS("124","DASAR","3","3","pak argo","45","minggu"));
    }
}
