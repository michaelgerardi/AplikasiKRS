package com.example.aplikasikrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class SplasshScreen extends AppCompatActivity {

    TextView Splassh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splassh_screen);
        Splassh = (TextView) findViewById(R.id.screensplassh);
        this.getSupportActionBar().hide();


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, 900L); //3000 L = 3 detik

    }
}
