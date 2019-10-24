package com.example.aplikasikrs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class EditMatakuliahActivity extends AppCompatActivity {
    private  static  final String[] hari = {"senin","selala","rabu","kamis","jumat"};
    private  static  final String[]Sesi = {"1","2","3","4"};
    private Spinner spinner1,spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_matakuliah);

        spinner1 = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(EditMatakuliahActivity.this,android.R.layout.simple_spinner_item,hari);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(adapter);


        spinner2= findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(EditMatakuliahActivity.this,android.R.layout.simple_spinner_item,Sesi);
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(adapter1);
    }
}
