package com.example.aplikasikrs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class DosenActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.layout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.Openbrowser){
            AlertDialog.Builder builder = new AlertDialog.Builder(DosenActivity.this);
            builder.setMessage("Apakahh anda yakin untuk Logout ??")
                    .setNegativeButton("No", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int which)
                    { Toast.makeText(DosenActivity.this, "Tidak Logout", Toast.LENGTH_SHORT).show(); } })
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int which)
                    { Toast.makeText(DosenActivity.this, "Behasil Logout !!", Toast.LENGTH_SHORT).show();
                        SharedPreferences prefs = DosenActivity.this.getSharedPreferences
                                ("prefs_file", MODE_PRIVATE);
                        String statusLogin = prefs.getString
                                ("isLogin", null);
                        SharedPreferences.Editor edit = prefs.edit();
                        edit.putString("isLogin", null);
                        edit.commit();
                        Intent intent = new Intent(DosenActivity.this,MainActivity.class);
                        startActivity(intent);
                    }});
            AlertDialog dialog = builder.create(); dialog.show();
        }

        return true;
    }

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
