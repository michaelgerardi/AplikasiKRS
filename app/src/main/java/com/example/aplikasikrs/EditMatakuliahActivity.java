package com.example.aplikasikrs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class EditMatakuliahActivity extends AppCompatActivity {
    private Spinner spinner1;
    private Spinner spinner2;
    private  static  final String[] hari = {"senin","selala","rabu","kamis","jumat"};
    private  static  final String[]Sesi = {"1","2","3","4"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_matakuliah);
        this.setTitle("SI KRS - HAI Michael");

        spinner1 = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(EditMatakuliahActivity.this,android.R.layout.simple_spinner_item,hari);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(adapter);


        spinner2= findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(EditMatakuliahActivity.this,android.R.layout.simple_spinner_item,Sesi);
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner2.setAdapter(adapter1);

        Button matkul = findViewById(R.id.button5);
        matkul.setOnClickListener(edit_matkul);
    }
    private View.OnClickListener edit_matkul = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(EditMatakuliahActivity.this);
            builder.setMessage("Apakahh anda yakin untuk menyimpan ??")
                    .setNegativeButton("No", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int which)
                    { Toast.makeText(EditMatakuliahActivity.this, "Tidak Menyimpan", Toast.LENGTH_SHORT).show(); } })
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int which)
                    { Toast.makeText(EditMatakuliahActivity.this, "Behasil Menyimpan !!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(EditMatakuliahActivity.this,DaftarIsiActivity.class);
                        startActivity(intent);
                    }});
            AlertDialog dialog = builder.create(); dialog.show();
        }
    };
}
