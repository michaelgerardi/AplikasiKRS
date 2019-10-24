package com.example.aplikasikrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aplikasikrs.Model.Dosen;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().hide();

        Button btnsign = findViewById(R.id.Signin);
        btnsign.setOnClickListener(btnmasuk);

        Button btndosen = findViewById(R.id.btn_dosen);
        btndosen.setOnClickListener(btndosen1);

    }
    private View.OnClickListener btnmasuk = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,DaftarIsiActivity.class);
            startActivity(intent);
        }
    };
    private  View.OnClickListener btndosen1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, DosenActivity.class);
            startActivity(intent);
        }
    };
}
