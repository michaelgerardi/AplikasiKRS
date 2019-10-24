package com.example.aplikasikrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DataDiriActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_diri);
        this.setTitle("SI KRS - HAI Michael");

        Button simpan1 = findViewById(R.id.button7);
        simpan1.setOnClickListener(btspn1);
    }
    private View.OnClickListener btspn1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(DataDiriActivity.this,DaftarIsiActivity.class);
            startActivity(intent);
        }
    };
}
