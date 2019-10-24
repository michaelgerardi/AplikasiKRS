package com.example.aplikasikrs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageButton;

import com.example.aplikasikrs.Adapter.DosenAdapter;
import com.example.aplikasikrs.Model.Dosen;

import java.util.ArrayList;

public class Cruddosen extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DosenAdapter dosenAdapter;
    private ArrayList<Dosen>dosenArrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cruddosen);
        this.setTitle("SI KRS - HAI Michael");
        addData();


        recyclerView = findViewById(R.id.RcvCrudDosen);
        dosenAdapter = new DosenAdapter( dosenArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Cruddosen.this);
        recyclerView .setLayoutManager(layoutManager);
        recyclerView .setAdapter( dosenAdapter );


    }
    private void addData(){
        dosenArrayList= new ArrayList<>();
        dosenArrayList.add(new Dosen("72170100","Jong Jek Siang","Profesor","jongjeksiang@staff.ukdw.ac.id",R.drawable.siang, "jogja"));
        dosenArrayList.add(new Dosen("72170100","Argo Wibowo", "Magister","ArgoWobowo@staff.ukdw.ac.id",R.drawable.argo,"Jogja"));
    }
}
