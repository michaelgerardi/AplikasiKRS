package com.example.aplikasikrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.aplikasikrs.Model.Dosen;

public class SplasshScreen extends AppCompatActivity {

    TextView Splassh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splassh_screen);
        Splassh = (TextView) findViewById(R.id.screensplassh);
        this.getSupportActionBar().hide();



        SharedPreferences prefs = SplasshScreen.this.getSharedPreferences("prefs_file",MODE_PRIVATE);
        String statusLogin = prefs.getString("isLogin",null);
        if (statusLogin != null){
            if (statusLogin .equals("Dosen"))
            {
                Intent intent = new Intent(SplasshScreen.this, DosenActivity.class) ;
                startActivity(intent);
            }else if (statusLogin .equals("Admin") ){
                Intent intent = new Intent( SplasshScreen.this,DaftarIsiActivity.class);
                startActivity(intent);
            }
        }else{
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



}
