package com.example.aplikasikrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class DosenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen);
        this.setTitle("SI KRS - HAI Michael");

        ImageButton datakelas = findViewById(R.id.imageButton7);
        datakelas.setOnClickListener(btnkelas);

        ImageButton Daftardata = findViewById(R.id.img_data);
        Daftardata.setOnClickListener(btndata);

        ImageButton datakrs = findViewById(R.id.imageButton8);
        datakrs.setOnClickListener(Btnkrs);


    }
    private View.OnClickListener btndata= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(DosenActivity.this,EditDosenActivity.class);
            startActivity(intent);
        }
    };
    private  View.OnClickListener btnkelas = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(DosenActivity.this,MatakuliahActivity.class);
            startActivity(intent);
        }
    };
    private  View.OnClickListener Btnkrs = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(DosenActivity.this,KelolaKRSActivity.class);
            startActivity(intent);
        }
    };
}
